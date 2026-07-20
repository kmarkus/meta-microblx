SUMMARY = "LuaSocket network library built against LuaJIT"
HOMEPAGE = "https://github.com/lunarmodules/luasocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d5850c0e7e7928460cd638a38f062263"

DEPENDS = "luajit"
RDEPENDS:${PN} += "luajit"

SRC_URI = "git://github.com/lunarmodules/luasocket;protocol=https;branch=master"
PV = "+git${SRCPV}"
SRCREV = "fa69770e52ba869feb8339d49e7c3c536953fbde"

S = "${WORKDIR}/git"

FILES:${PN} = "${libdir}/lua/5.1 ${datadir}/lua/5.1"

# Pass our flags through MYCFLAGS/MYLDFLAGS (the makefile's documented hooks:
# CFLAGS=$(MYCFLAGS) $(CFLAGS_$(PLAT))). Overriding CFLAGS directly would clobber
# the makefile's per-platform flags -- notably -fpic -- and the .o files would
# then fail to link into the shared .so on ARM (R_ARM_MOVW_ABS_NC ... -fPIC).
EXTRA_OEMAKE = 'DESTDIR=${D} BASELIB=${base_libdir} PREFIX=/usr CC="${CC}" LD="${CC}" MYCFLAGS="${CFLAGS}" MYLDFLAGS="${LDFLAGS}"'

inherit pkgconfig

do_configure[noexec] = "1"

do_compile () {
   # LUAINC_linux: don't let the makefile default to host /usr/include lua
   # paths (poison-system-directories is a hard error since walnascar)
   oe_runmake linux LUAV=5.1 LUAINC_linux="${STAGING_INCDIR}/luajit-2.1" MYCFLAGS="${CFLAGS} `pkg-config --cflags luajit`" MYLDFLAGS="${LDFLAGS} `pkg-config --libs luajit`"
}

do_install () {
    oe_runmake -C ${S}/src install LUAV=5.1
}