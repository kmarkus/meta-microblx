DESCRIPTION = "A pure Lua JSON module"
LICENSE = "MIT"
RDEPENDS:${PN} = "lua"
LIC_FILES_CHKSUM = "file://LICENSE;md5=90e6c59a540ccc7a7be85367c8457b7a"

PV = "+git${SRCPV}"

SRC_URI = "git://github.com/rxi/json.lua.git;protocol=https;branch=master"
SRCREV = "dbf4b2dd2eb7c23be2773c89eb059dadd6436f94"

S = "${WORKDIR}/git"

LUA_MODULE_DIR = "${datadir}/lua"

FILES:${PN} += "${LUA_MODULE_DIR}/5.*/json.lua"

do_install () {
    install -d ${D}${LUA_MODULE_DIR}/5.1/
    install -d ${D}${LUA_MODULE_DIR}/5.2/
    install -d ${D}${LUA_MODULE_DIR}/5.3/
    install -d ${D}${LUA_MODULE_DIR}/5.4/

    install -m 0644 ${S}/json.lua ${D}${LUA_MODULE_DIR}/5.1/
    ln -srf ${D}${LUA_MODULE_DIR}/5.1/json.lua ${D}${LUA_MODULE_DIR}/5.2/
    ln -srf ${D}${LUA_MODULE_DIR}/5.1/json.lua ${D}${LUA_MODULE_DIR}/5.3/
    ln -srf ${D}${LUA_MODULE_DIR}/5.1/json.lua ${D}${LUA_MODULE_DIR}/5.4/
}
