DESCRIPTION = "A pure Lua command-line option parser"
LICENSE = "MIT"
RDEPENDS:${PN} = "lua"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=9c172b56f5b3455eb94f621ee99dae8c"

PV = "+git${SRCPV}"

SRC_URI = "git://github.com/gvvaughan/optparse.git;protocol=https;branch=master"
SRCREV = "e1bdaeb7b8b05f6dd0c9604abd5fdee02ef074a0"

S = "${WORKDIR}/git"

LUA_MODULE_DIR = "${datadir}/lua"

FILES:${PN} += "${LUA_MODULE_DIR}/5.*/"

do_install () {
    install -d ${D}${LUA_MODULE_DIR}/5.1/optparse
    install -m 0644 ${S}/lib/optparse/init.lua    ${D}${LUA_MODULE_DIR}/5.1/optparse/
    install -m 0644 ${S}/lib/optparse/_strict.lua ${D}${LUA_MODULE_DIR}/5.1/optparse/

    for v in 5.2 5.3 5.4 5.5; do
        install -d ${D}${LUA_MODULE_DIR}/${v}
        ln -srf ${D}${LUA_MODULE_DIR}/5.1/optparse ${D}${LUA_MODULE_DIR}/${v}/optparse
    done
}
