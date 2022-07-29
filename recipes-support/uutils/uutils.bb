DESCRIPTION = "A couple of useful Lua modules"
LICENSE = "MIT"
RDEPENDS:${PN} = "lua"
LIC_FILES_CHKSUM = "file://License;md5=596f176fbcaaafa9489a583a69acba69"

PV = "1.1.2"
PR = "r2"
BRANCH = "master"
TAG = "30864a67e6f49f30b5110694de895af56b2975b7"

SRC_URI = "git://github.com/kmarkus/uutils.git;protocol=https;branch=${BRANCH};tag=${TAG}"

S = "${WORKDIR}/git"

LUA_MODULE_DIR = "/usr/share/lua"
FILES:${PN} += "\
	${LUA_MODULE_DIR}/5.1/strict.lua\
	${LUA_MODULE_DIR}/5.1/ansicolors.lua\
	${LUA_MODULE_DIR}/5.1/utils.lua\
	${LUA_MODULE_DIR}/5.1/time.lua\
	${LUA_MODULE_DIR}/5.2/strict.lua\
	${LUA_MODULE_DIR}/5.2/ansicolors.lua\
	${LUA_MODULE_DIR}/5.2/utils.lua\
	${LUA_MODULE_DIR}/5.2/time.lua\
	${LUA_MODULE_DIR}/5.3/strict.lua\
	${LUA_MODULE_DIR}/5.3/ansicolors.lua\
	${LUA_MODULE_DIR}/5.3/utils.lua\
	${LUA_MODULE_DIR}/5.3/time.lua \
	${LUA_MODULE_DIR}/5.4/strict.lua \
	${LUA_MODULE_DIR}/5.4/ansicolors.lua\
	${LUA_MODULE_DIR}/5.4/utils.lua \
	${LUA_MODULE_DIR}/5.4/time.lua"

do_install () {
oe_runmake 'DESTDIR=${D}' install
}
