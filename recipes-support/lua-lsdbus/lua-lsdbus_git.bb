SUMMARY = "Lua sd-bus bindings"
DEPENDS = "systemd lua libmxml"
RDEPENDS:${PN}-tools += "lua ${PN} uutils"

require lua-lsdbus.inc
