SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash cproto-native"
RDEPENDS_${PN} = "luajit liblfds uutils"

LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=40663994a34d497bf17c10d49c3aaeaf"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
PV = "0.6.1"
TAG = "v${PV}"
BRANCH = "rtlogging"
#SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH};tag=${TAG}"
SRC_URI = "git://github.com/hamishguthrie/microblx.git;branch=${BRANCH}"
SRCREV = "f566739ad62f4874500f0fce7218e0ab291db25b"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

# libs, headers and lua modules
FILES_${PN} += " \
	${libdir}/lib*.so.* \
	${includedir}/ubx/*.h \
	${includedir}/ubx/internal/*.h \
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
	${libdir}/lib*.so \
	${libdir}/*.la \
	${libdir}/pkgconfig/*.pc \
	"
