DEPENDS = "luajit luajit-native liblfds uthash cproto-native"
RDEPENDS:${PN} += "luajit uutils"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

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
	${libdir}/librtlog_client.so \
	${libdir}/*.la \
	${libdir}/pkgconfig/ubx0.pc \
	${libdir}/pkgconfig/ubxrtl0.pc \
	"
