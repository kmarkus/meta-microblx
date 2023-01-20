# bitbake recipe for lfds, a portable, license-free, lock-free data
# structure library written in C.

SUMMARY = "lfds lock free library"
SECTION = "libs"
HOMEPAGE = "https://www.liblfds.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "353229e83e77930ff33f98e99390128bf9c4ea06"
SRC_URI = "git://liblfds.org/git/liblfds6.1.1;branch=master;protocol=https \
	file://0001-Autotoolise-liblfds611.patch \
	file://0002-Add-LGPL.patch \
	file://0003-Add-gitignore.patch \
	file://0004-Add-bootstrap-file.patch \
	file://0005-add-pkg-config-support.patch"

S = "${WORKDIR}/git"
B = "${S}/liblfds611"

inherit autotools
