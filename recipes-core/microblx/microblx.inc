
S = "${WORKDIR}/git"

inherit autotools pkgconfig

# libs, headers and lua modules
FILES_${PN} += " \
	${libdir}/libubx.so.* \
	${libdir}/librtlog_client.so.* \
	${includedir}/ubx/* \
	${datadir}/lua/* \
	${bindir}/* \
	"

# blocks
FILES_${PN} += "${libdir}/ubx/*"

# docs
FILES_${PN}-doc += " \
	${datadir}/ubx/* \
	"

# dev files
FILES_${PN}-dev = " \
	${libdir}/libubx.so \
	${libdir}/librtlog_client.so \
	${libdir}/*.la \
	${libdir}/pkgconfig/ubx0.pc \
	${libdir}/pkgconfig/ubxrtl0.pc \
	"
