HOMEPAGE = "https://github.com/kmarkus/lsdbus"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

PACKAGES =+ "${PN}-tools"

PV = "1.0+git${SRCPV}"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/lsdbus.git;protocol=https;branch=${BRANCH}"

SRCREV = "1137c20488538199095aaad53821366efc79824f"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

FILES:${PN} += " \
	${datadir}/lua/*/lsdbus/common.lua \
	${datadir}/lua/*/lsdbus/error.lua \
	${datadir}/lua/*/lsdbus/expat.lua \
	${datadir}/lua/*/lsdbus/init.lua \
	${datadir}/lua/*/lsdbus/proxy.lua \
	${datadir}/lua/*/lsdbus/server.lua \
	${libdir}/lua/*/lsdbus/core.so \
"	

FILES:${PN}-tools += " \
	${bindir}/lsdb-call \
	${bindir}/lsdb-emit \
	${bindir}/lsdb-info \
	${bindir}/lsdb-mon \
	${bindir}/lsdb-prop \
"
