SUMMARY = "build helpers for microblx"
DEPENDS = "luajit-native"
RDEPENDS_${PN} = "luajit"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=40663994a34d497bf17c10d49c3aaeaf"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
PV = "0.8.0-rc5"
TAG = "v${PV}"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH};tag=${TAG}"

S = "${WORKDIR}/git"

do_install () {
	   install -d ${D}${bindir}
	   install -m755 ${S}/tools/ubx-tocarr ${D}${bindir}/
}

BBCLASSEXTEND = "native nativesdk"
