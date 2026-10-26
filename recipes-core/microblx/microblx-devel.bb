SUMMARY = "Real-time, embedded, reflective function blocks"

LICENSE = "MPL-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e731c30608cf88d4fcd9e57fa60e1f6"
HOMEPAGE = "https://github.com/kmarkus/microblx"

RDEPENDS:${PN} += "ffi-reflect"

PV = "1.0+git${SRCPV}"
SRCREV = "7162c09a6afd6f2ce157185cd601bea55475e2e9"
BRANCH = "dev"
SRC_URI = "git://github.com/kmarkus/microblx.git;branch=${BRANCH};protocol=https"

require microblx.inc