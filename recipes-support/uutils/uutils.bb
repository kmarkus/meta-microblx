DESCRIPTION = "A couple of useful Lua modules"
LICENSE = "MIT"
RDEPENDS:${PN} = "lua"
LIC_FILES_CHKSUM = "file://License;md5=596f176fbcaaafa9489a583a69acba69"

PV = "1.2+git${SRCPV}"
BRANCH = "master"
SRCREV = "13810202859e4f2e8122dfd2bc46696c2d76dcd8"

SRC_URI = "git://github.com/kmarkus/uutils.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git"

LUA_MODULE_DIR = "${datadir}/lua"

# installs strict, ansicolors, utils, time and prettytable for each
# supported lua version
FILES:${PN} += "${LUA_MODULE_DIR}"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
