SUMMARY = "Lua-5.3-style APIs for Lua 5.2 and 5.1"
HOMEPAGE = "https://github.com/keplerproject/lua-compat-5.3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b863a95a5f6ff64e40a0bb54501225d0"

PV = "0.14.4+git${SRCPV}"
BRANCH = "master"
SRCREV = "9c6f75a88db1462ff655dc006588b25d3bc2a5be"

SRC_URI = "git://github.com/keplerproject/lua-compat-5.3.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git"

FILES:${PN} += "\
    ${datadir}/lua/5.*/compat53/init.lua \
    ${datadir}/lua/5.*/compat53/module.lua"

FILES:${PN}-dev += "\
    ${includedir}/lua5.1/compat-5.3.h \
    ${includedir}/lua5.1/compat-5.3.c \
    ${includedir}/lua5.2/compat-5.3.h \
    ${includedir}/lua5.2/compat-5.3.c"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    # 5.1
    install -d ${D}${includedir}/lua5.1
    install -m 0644 ${S}/c-api/compat-5.3.h ${D}${includedir}/lua5.1/
    install -m 0644 ${S}/c-api/compat-5.3.c ${D}${includedir}/lua5.1/

    install -d ${D}${datadir}/lua/5.1/compat53
    install -m 0644 ${S}/compat53/init.lua ${D}${datadir}/lua/5.1/compat53/
    install -m 0644 ${S}/compat53/module.lua ${D}${datadir}/lua/5.1/compat53/

    # 5.2
    install -d ${D}${includedir}/lua5.2
    ln -srf ${D}${includedir}/lua5.1/compat-5.3.h ${D}${includedir}/lua5.2/
    ln -srf ${D}${includedir}/lua5.1/compat-5.3.c ${D}${includedir}/lua5.2/

    install -d ${D}${datadir}/lua/5.2/compat53
    ln -srf ${D}${datadir}/lua/5.1/compat53/init.lua ${D}${datadir}/lua/5.2/compat53/
    ln -srf ${D}${datadir}/lua/5.1/compat53/module.lua ${D}${datadir}/lua/5.2/compat53/
}
