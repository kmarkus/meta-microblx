
LJPV = "${@'${PV}'.replace('~', '-')}"

# create luajit symlink to versioned binary
do_install_append() {
    ln -s -r ${D}${bindir}/luajit-${LJPV} ${D}${bindir}/luajit
}
