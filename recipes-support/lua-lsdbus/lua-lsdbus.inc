HOMEPAGE = "https://github.com/kmarkus/lsdbus"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

PACKAGES =+ "${PN}-tools"

PV = "1.0.0~rc1+git"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/lsdbus.git;protocol=https;branch=${BRANCH}"

SRCREV = "97e402b70bc81aa119aa00d0c833bda02f58ac28"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

FILES:${PN} += " \
	${datadir}/lua/*/lsdbus/common.lua \
	${datadir}/lua/*/lsdbus/error.lua \
	${datadir}/lua/*/lsdbus/expat.lua \
	${datadir}/lua/*/lsdbus/init.lua \
	${datadir}/lua/*/lsdbus/job.lua \
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
