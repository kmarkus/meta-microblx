SUMMARY = "FFI reflection library for LuaJIT"
HOMEPAGE = "https://github.com/corsix/ffi-reflect"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://reflect.lua;beginline=4;endline=20;md5=5a9dfc801af3eb49df2055c9b07918b2"

RDEPENDS:${PN} = "luajit"

SRC_URI = "git://github.com/corsix/ffi-reflect.git;branch=master;protocol=https"
SRCREV = "d9923b00d128ba27e7c85b02d979af6d25876ff7"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
	install -d ${D}${datadir}/lua/5.1/
	install -m 0644 ${S}/reflect.lua ${D}${datadir}/lua/5.1/
}

FILES:${PN} += "${datadir}/lua/5.1/reflect.lua"
