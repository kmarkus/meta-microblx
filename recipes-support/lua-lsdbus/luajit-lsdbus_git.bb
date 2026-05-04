SUMMARY = "Lua sd-bus bindings (LuaJIT)"
DEPENDS = "systemd luajit lua-compat53 libmxml"
RDEPENDS:${PN} += "lua-compat53"
RDEPENDS:${PN}-tools += "luajit ${PN} uutils"

require lua-lsdbus.inc

do_install:append() {
    sed -i 's/#!\/usr\/bin\/lua/#!\/usr\/bin\/luajit/g' ${D}${bindir}/lsdb-*
}
