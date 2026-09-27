SUMMARY = "Lua sd-bus bindings"
DEPENDS = "systemd lua libmxml"
RDEPENDS:${PN}-tools += "lua ${PN} uutils"

LSDBUS_LUA = "lua"
RDEPENDS:${PN}-ptest += "luaposix"

require lua-lsdbus.inc
