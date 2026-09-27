SUMMARY = "Lua sd-bus bindings (LuaJIT)"
DEPENDS = "systemd luajit lua-compat53 libmxml"
RDEPENDS:${PN} += "lua-compat53"
RDEPENDS:${PN}-tools += "luajit ${PN} uutils"

require lua-lsdbus.inc

# the unit tests (packaged in ${PN}-test) run as ptests in a private
# dbus session (see files/run-ptest). Needs 'ptest' in DISTRO_FEATURES.
inherit ptest
SRC_URI += "file://run-ptest"
RDEPENDS:${PN}-ptest += "${PN}-test luaunit dbus"

do_install:append() {
    sed -i 's/#!\/usr\/bin\/lua/#!\/usr\/bin\/luajit/g' ${D}${bindir}/lsdb-*
}
