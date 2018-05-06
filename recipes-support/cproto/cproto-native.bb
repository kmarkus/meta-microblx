SUMMARY = "cproto - generate C function prototypes and convert function definitions"

LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://package/debian/copyright;md5=f7a35a56db6d00a39d07c50992d90e77"

SRC_URI = "https://invisible-island.net/datafiles/release/cproto.tar.gz \
           file://0001-Fix-autotools-build-to-work-with-Yocto.patch \
           "
SRC_URI[md5sum] = "bfd5f1cbd8614176a9c46e466f93bbc6"
SRC_URI[sha256sum] = "4b482e80f1b492e94f8dcda74d25a7bd0381c870eb500c18e7970ceacdc07c89"

S = "${WORKDIR}/${BPN}-4.7m"

DEPENDS = "flex-native bison-native"

inherit autotools-brokensep native

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""
