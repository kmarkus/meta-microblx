SUMMARY = "Real-time, embedded, reflective function blocks"
DEPENDS = "luajit luajit-native liblfds uthash cproto-native"
RDEPENDS:${PN} += "luajit uutils"

LICENSE = "MPL-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e731c30608cf88d4fcd9e57fa60e1f6"
HOMEPAGE = "https://github.com/kmarkus/microblx"

PR = "r0"
PV = "0.9.2"
BRANCH = "master"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH};protocol=https"
SRCREV = "66c830083461ec5e7e9d5a7f37fef53b8e1fd264"

require microblx.inc
