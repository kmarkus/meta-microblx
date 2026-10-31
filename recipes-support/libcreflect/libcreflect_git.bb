SUMMARY = "Reflection of C data types"
DESCRIPTION = "Parse C type declarations at runtime, compute their layout \
and access instances generically, with a command line tool and Lua bindings."
HOMEPAGE = "https://gitlab.com/kmarkus/libcreflect"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=9ec28527f3d544b51ceb0e1907d0bf3f"

PV = "0.1.0+git"
SRCREV = "980762529588c276a720a6c6b585165eecbe562b"
SRC_URI = "git://gitlab.com/kmarkus/libcreflect.git;branch=main;protocol=https \
           file://run-ptest \
           "

inherit cmake pkgconfig ptest qemu

EXTRA_OECMAKE = "-DCREFL_SANITIZE=OFF \
                 ${@bb.utils.contains('PTEST_ENABLED', '1', '-DBUILD_TESTING=ON', '-DBUILD_TESTING=OFF', d)}"

# Lua bindings, one module per Lua, installable side by side: luajit
# (as used by microblx) and lua (PUC Lua from oe-core)
PACKAGECONFIG ??= "luajit"
PACKAGECONFIG[luajit] = ",,luajit lua-compat53"
PACKAGECONFIG[lua] = ",,lua"
CREFL_LUAS = "${@','.join(v for p, v in (('luajit', 'jit'), ('lua', 'lua')) if bb.utils.contains('PACKAGECONFIG', p, True, False, d))}"
EXTRA_OECMAKE += "${@'-DCONFIG_LUA_VER=${CREFL_LUAS} -DCONFIG_LIBDIR=${libdir}/lua' if d.getVar('CREFL_LUAS') else '-DCREFL_LUA=OFF'}"

# ptests: unit tests (cmocka), the compiler oracle and the Lua tests.
# The oracle compares crefl with the cross compiler: the check programs
# are generated for the target ABI (generator under qemu-user), built
# here and run on the target. They run once under qemu here as well.
DEPENDS += "${@bb.utils.contains('PTEST_ENABLED', '1', 'cmocka qemu-native', '', d)}"
ORACLE_RANDOM_SEEDS ?= "40"

do_compile_ptest() {
	cat > ${B}/qemu-run <<EOF
#!/bin/sh
${@qemu_wrapper_cmdline(d, '${STAGING_DIR_TARGET}', ['${STAGING_DIR_TARGET}${libdir}', '${STAGING_DIR_TARGET}${base_libdir}'])} "\$@"
EOF
	chmod +x ${B}/qemu-run

	# results are checked on the target, a DIFFER here does not fail the build
	CC="${CC}" ABI_CFLAGS="${LDFLAGS}" RUN=${B}/qemu-run \
		${S}/test/oracle.sh ${B}/oracle ${S}/test/testcases/*.h || true
	CC="${CC}" ABI_CFLAGS="${LDFLAGS}" RUN=${B}/qemu-run JOBS=${@oe.utils.cpu_count()} \
		${S}/test/random-oracle.sh ${B}/oracle-random 1 ${ORACLE_RANDOM_SEEDS} || true
}

do_install_ptest() {
	install -m 0755 ${B}/crefl-test ${D}${PTEST_PATH}/
	install -d ${D}${PTEST_PATH}/oracle
	for f in ${B}/oracle/*-check ${B}/oracle-random/job*/*-check; do
		install -m 0755 $f ${D}${PTEST_PATH}/oracle/
	done
	install -d ${D}${PTEST_PATH}/lua/test ${D}${PTEST_PATH}/lua/examples
	install -m 0644 ${S}/lua/test/*.lua ${D}${PTEST_PATH}/lua/test/
	install -m 0644 ${S}/lua/examples/*.lua ${D}${PTEST_PATH}/lua/examples/
}

PACKAGES =+ "${PN}-tool ${PN}-luajit ${PN}-lua"
FILES:${PN}-tool = "${bindir}/crefl-tool"
# the library is compiled into the modules, no libcreflect dependency
FILES:${PN}-luajit = "${libdir}/lua/5.1/creflect.so"
FILES:${PN}-lua = "${libdir}/lua/5.[2-9]/creflect.so"
RDEPENDS:${PN}-luajit = "luajit"
RDEPENDS:${PN}-lua = "lua"
RDEPENDS:${PN}-ptest += "luaunit \
	${@bb.utils.contains('PACKAGECONFIG', 'luajit', '${PN}-luajit', '', d)} \
	${@bb.utils.contains('PACKAGECONFIG', 'lua', '${PN}-lua', '', d)}"
