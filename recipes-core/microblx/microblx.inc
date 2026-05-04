DEPENDS = "luajit luajit-native uthash cproto-native"
RDEPENDS:${PN} += "luajit uutils"
RDEPENDS:${PN}-test += "${PN}"

PACKAGES =+ "${PN}-test"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "USE_LFDS_611 BLOCK_WEBGRAPH"
PACKAGECONFIG[USE_LFDS_611] = "-DBLOCK_LFDS_CYCLIC=1,-DBLOCK_LFDS_CYCLIC=0,liblfds"
PACKAGECONFIG[USE_TIMESRC_TSC] = "-DENABLE_TIMESRC_TSC=1,-DENABLE_TIMESRC_TSC=0"
PACKAGECONFIG[USE_TIMESRC_CNTVCT] = "-DENABLE_TIMESRC_CNTVCT=1,-DENABLE_TIMESRC_CNTVCT=0"
PACKAGECONFIG[BLOCK_LSDB_INTF] = "-DBLOCK_LSDB_INTF=1,-DBLOCK_LSDB_INTF=0,,luajit-lsdbus"
PACKAGECONFIG[BLOCK_WEBGRAPH] = "-DBLOCK_WEBGRAPH=1,-DBLOCK_WEBGRAPH=0,,luasocket-jit lua-json"

inherit cmake pkgconfig

# for profiling
# EXTRA_OECMAKE += "-DCMAKE_C_FLAGS=-pg -DCMAKE_CXX_FLAGS=-pg"

# libs, headers and lua modules
FILES:${PN} += " \
	${libdir}/libubx.so.* \
	${libdir}/librtlog_client.so.* \
	${includedir}/ubx/* \
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

# dev files
FILES:${PN}-dev = " \
	${libdir}/libubx.so \
	${libdir}/liblfq.so \
	${libdir}/librtlog_client.so \
	${libdir}/*.la \
	${libdir}/pkgconfig/ubx0.pc \
	${libdir}/pkgconfig/ubxrtl0.pc \
	"
