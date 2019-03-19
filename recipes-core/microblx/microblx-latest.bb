SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash cproto-native"
RDEPENDS_${PN} = "luajit liblfds uutils"

LICENSE = "GPL-2.0+ & eCos-exception-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=40663994a34d497bf17c10d49c3aaeaf"
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
	${includedir}/ubx/*.h \
	${includedir}/ubx/*.hexarr \
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
	${libdir}/*.la \
	${libdir}/pkgconfig/ubx0.pc \
	"

