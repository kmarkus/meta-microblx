# as in newer meta-oe: point luke at the target Lua headers, otherwise
# it picks up the host's /usr/include/lua5.4 when that is installed
do_compile() {
    ${S}/build-aux/luke LUA_INCDIR=${STAGING_INCDIR}
}
