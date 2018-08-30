SUMMARY = "build helpers for microblx"
DEPENDS = "luajit-native"
RDEPENDS_${PN} = "luajit"

LICENSE = "eCos-exception-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=40663994a34d497bf17c10d49c3aaeaf"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
PV = "0.3.4"
TAG = "v${PV}"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH};tag=${TAG}"

S = "${WORKDIR}/git"

# FILES_${PN} += " \
# 	${libdir}/libubx.so.* \
# 	${includedir}/*.h \
# 	${datadir}/lua/* \
# 	${bindir}/* \
# 	"

do_install () {
	   install -d ${D}${bindir}
	   install -m755 ${S}/tools/ubx_tocarr ${D}${bindir}/
}

BBCLASSEXTEND = "native nativesdk"