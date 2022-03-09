DESCRIPTION = "A couple of useful Lua modules"
LICENSE = "MIT"
RDEPENDS:${PN} = "lua"
LIC_FILES_CHKSUM = "file://License;md5=596f176fbcaaafa9489a583a69acba69"

PV = "1.1.2"
PR = "r0"
BRANCH = "master"
TAG = "9983f4813860d9c750e5aa2b9e6224786431dc79"

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
	${LUA_MODULE_DIR}/5.3/time.lua"
	

do_install () {
oe_runmake 'DESTDIR=${D}' install
}
