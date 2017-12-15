SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash"
RDEPENDS_${PN} = "luajit liblfds uutils"

LICENSE = "eCos-exception-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=40663994a34d497bf17c10d49c3aaeaf"
HOMEPAGE = "https://github.com/kmarkus/microblx"

BRANCH = "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=master"

S = "${WORKDIR}/git"

inherit autotools pkgconfig externalsrc

# libs and headers
FILES_${PN} += " \
	${libdir}/libubx.so.0.2.2 \
	${libdir}/libubx.so.0 \
	${includedir}/*.h \
	"

# dev files
FILES_${PN}-dev = "${libdir}/*.la \
	${libdir}/libubx.so \
	${libdir}/pkgconfig/ubx0.pc"

# lua modules and docs
FILES_${PN} += "${datadir}/lua/* \
	${datadir}/${PN}/*"

# blocks
FILES_${PN} += "${libdir}/${PN}/*"

EXTERNALSRC = "/home/mk/prog/c/microblx"
EXTERNALSRC_BUILD = "/home/mk/prog/c/microblx"
