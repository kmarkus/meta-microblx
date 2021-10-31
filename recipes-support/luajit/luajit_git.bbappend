FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-make-create-target-for-adding-symlink.patch"

S = "${WORKDIR}/git"

do_install_append () {
    oe_runmake ${EXTRA_OEMAKEINST} symlink
}
