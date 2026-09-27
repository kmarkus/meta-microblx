HOMEPAGE = "https://github.com/kmarkus/lsdbus"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

PACKAGES =+ "${PN}-tools ${PN}-test"

PV = "1.0.0~rc1+git"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/lsdbus.git;protocol=https;branch=${BRANCH}"

SRCREV = "e9da2519705418e92e39d10a9355647610879902"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# the unit tests, runnable with luaunit from ${datadir}/${BPN}/test
EXTRA_OECMAKE += "-DINSTALL_TESTS=ON -DCONFIG_TESTDIR=${datadir}/${BPN}/test"

FILES:${PN} += " \
	${datadir}/lua/*/lsdbus/*.lua \
	${libdir}/lua/*/lsdbus/core.so \
"	

FILES:${PN}-tools += " \
	${bindir}/lsdb-call \
	${bindir}/lsdb-emit \
	${bindir}/lsdb-info \
	${bindir}/lsdb-mon \
	${bindir}/lsdb-prop \
"

FILES:${PN}-test = "${datadir}/${BPN}/test"
RDEPENDS:${PN}-test += "${PN}"
