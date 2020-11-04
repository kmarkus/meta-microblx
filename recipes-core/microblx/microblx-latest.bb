SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash"
RDEPENDS_${PN} += "luajit liblfds uutils"

LICENSE = "MPL-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e731c30608cf88d4fcd9e57fa60e1f6"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
BRANCH = "dev"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH}"

require microblx.inc
