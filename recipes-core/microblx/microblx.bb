SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash cproto-native"
RDEPENDS:${PN} += "luajit uutils"

LICENSE = "MPL-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e731c30608cf88d4fcd9e57fa60e1f6"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
PV = "0.9.1"
TAG = "v${PV}"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH};tag=${TAG};protocol=https"

require microblx.inc
