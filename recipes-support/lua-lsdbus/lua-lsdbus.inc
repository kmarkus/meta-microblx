HOMEPAGE = "https://github.com/kmarkus/lsdbus"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

PACKAGES =+ "${PN}-tools ${PN}-test"

PV = "1.0.0~rc1+git"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/lsdbus.git;protocol=https;branch=${BRANCH}"

SRCREV = "e9da2519705418e92e39d10a9355647610879902"


inherit cmake pkgconfig ptest

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

# the unit tests run as ptests with ${LSDBUS_LUA} in a private dbus
# session (see files/run-ptest). Needs 'ptest' in DISTRO_FEATURES.
SRC_URI += "file://run-ptest"
RDEPENDS:${PN}-ptest += "${PN}-test ${LSDBUS_LUA} luaunit dbus"

do_install_ptest() {
	sed -i -e 's|@LUA@|${LSDBUS_LUA}|g' -e 's|@BPN@|${BPN}|g' ${D}${PTEST_PATH}/run-ptest
}
