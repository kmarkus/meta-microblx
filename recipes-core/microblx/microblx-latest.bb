SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash cproto-native"
RDEPENDS_${PN} = "luajit liblfds uutils"

LICENSE = "MPL-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e731c30608cf88d4fcd9e57fa60e1f6"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
BRANCH = "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

# libs, headers and lua modules
FILES_${PN} += " \
	${libdir}/libubx.so.* \
	${libdir}/librtlog_client.so.* \
	${includedir}/ubx/* \
	${datadir}/lua/* \
	${bindir}/* \
	"

# blocks
FILES_${PN} += "${libdir}/ubx/*"

# docs
FILES_${PN}-doc += " \
	${datadir}/ubx/* \
	"

# dev files
FILES_${PN}-dev = " \
	${libdir}/libubx.so \
	${libdir}/librtlog_client.so \
	${libdir}/*.la \
	${libdir}/pkgconfig/ubx0.pc \
	${libdir}/pkgconfig/ubxrtl0.pc \
	"

