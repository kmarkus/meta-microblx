DEPENDS = "luajit luajit-native uthash cproto-native"
RDEPENDS:${PN} += "luajit uutils ${PN}-ffi-headers"
RDEPENDS:${PN}-test += "${PN}"

# ${PN}-ffi-headers is prepended so it is populated *before* ${PN}-dev:
# it opts-in exactly the headers required at runtime, everything else
# under ${includedir} falls to ${PN}-dev by default (see below)
PACKAGES =+ "${PN}-test ${PN}-ffi-headers"
ALLOW_EMPTY:${PN}-ffi-headers = "1"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "USE_LFDS_611 BLOCK_WEBGRAPH UBX_LOG_DAEMON"
PACKAGECONFIG[USE_LFDS_611] = "-DBLOCK_LFDS_CYCLIC=1,-DBLOCK_LFDS_CYCLIC=0,liblfds"
PACKAGECONFIG[USE_TIMESRC_TSC] = "-DENABLE_TIMESRC_TSC=1,-DENABLE_TIMESRC_TSC=0"
PACKAGECONFIG[USE_TIMESRC_CNTVCT] = "-DENABLE_TIMESRC_CNTVCT=1,-DENABLE_TIMESRC_CNTVCT=0"
PACKAGECONFIG[BLOCK_LSDB_INTF] = "-DBLOCK_LSDB_INTF=1,-DBLOCK_LSDB_INTF=0,,luajit-lsdbus lua-optparse"
PACKAGECONFIG[BLOCK_WEBGRAPH] = "-DBLOCK_WEBGRAPH=1,-DBLOCK_WEBGRAPH=0,,luasocket-jit lua-json"
PACKAGECONFIG[UBX_LOG_DAEMON] = ",,libdaemon,libdaemon"

inherit cmake pkgconfig ptest

# the lua unit tests (packaged in ${PN}-test) run as ptests, one
# interpreter and dbus session per test file (see files/run-ptest).
# Needs 'ptest' in DISTRO_FEATURES.
SRC_URI += "file://run-ptest"
RDEPENDS:${PN}-ptest += "${PN}-test luaunit dbus"

# for profiling
# EXTRA_OECMAKE += "-DCMAKE_C_FLAGS=-pg -DCMAKE_CXX_FLAGS=-pg"

# the LuaJIT FFI bindings read these headers at *runtime* to build the
# ffi cdefs and hard-fail without them (see ubx_ffi_headers in
# lua/ubx.lua). Keep this list in sync with ubx.lua. Any header NOT
# listed here defaults to ${PN}-dev and stays off the target image.
FILES:${PN}-ffi-headers = " \
	${includedir}/ubx/ubx_uthash_ffi.h \
	${includedir}/ubx/ubx_types.h \
	${includedir}/ubx/ubx_core.h \
	${includedir}/ubx/ubx_time.h \
	${includedir}/ubx/md5.h \
	${includedir}/ubx/ubx_utils.h \
	"

# libs and lua modules
FILES:${PN} += " \
	${libdir}/libubx.so.* \
	${libdir}/librtlog_client.so.* \
	${datadir}/lua/* \
	${datadir}/ubx/blocks/* \
	${bindir}/* \
	"

# blocks
FILES:${PN} += "${libdir}/ubx/*"

# docs
FILES:${PN}-doc += " \
	${datadir}/ubx/examples/* \
	${datadir}/ubx/lsdb-intf.d/lsdb_intf_test_plugin.lua \
	"

# tests
FILES:${PN}-test = " \
	${datadir}/ubx/tests/* \
	"

# dev files. ${includedir} catches ALL headers not already claimed by
# ${PN}-ffi-headers (populated first), so new headers land here by
# default rather than on the target image.
FILES:${PN}-dev = " \
	${libdir}/libubx.so \
	${libdir}/liblfq.so \
	${libdir}/librtlog_client.so \
	${libdir}/*.la \
	${libdir}/pkgconfig/ubx0.pc \
	${libdir}/pkgconfig/ubxrtl0.pc \
	${includedir} \
	"
