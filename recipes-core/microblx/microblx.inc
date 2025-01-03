DEPENDS = "luajit luajit-native uthash cproto-native"
RDEPENDS:${PN} += "luajit uutils"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "USE_LFDS_611"
PACKAGECONFIG[USE_LFDS_611] = "-DBLOCK_LFDS_CYCLIC=1, -DBLOCK_LFDS_CYCLIC=0, liblfds"

inherit cmake pkgconfig

# libs, headers and lua modules
FILES:${PN} += " \
	${libdir}/libubx.so.* \
	${libdir}/librtlog_client.so.* \
	${includedir}/ubx/* \
	${datadir}/lua/* \
	${bindir}/* \
	"

# blocks
FILES:${PN} += "${libdir}/ubx/*"

# docs
FILES:${PN}-doc += " \
	${datadir}/ubx/* \
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
