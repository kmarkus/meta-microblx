#
# bitbake recipe for lfds, a portable, license-free, lock-free data
# structure library written in C.
#

SUMMARY = "lfds lock free library"
SECTION = "libs"
HOMEPAGE = "https://www.liblfds.org/"
LICENSE = "LGPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

SRCREV = "5c385e4fdd48e20c56c3682533e931a43b446180"
SRC_URI = "git://github.com/liblfds/liblfds6.1.1;protocol=https \
	file://0001-Autotoolise-liblfds611.patch \
	file://0002-Add-LGPL.patch \
	file://0003-Add-gitignore.patch \
	file://0004-Add-bootstrap-file.patch"

S = "${WORKDIR}/git"
B = "${S}/liblfds611"

inherit autotools
