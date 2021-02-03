SUMMARY = "C++ bindings for the pango library"
SECTION = "libs"
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d8045f3b8f929c1cb29a1e3fd737b499 \
                    file://COPYING.tools;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "mm-common cairomm3 glibmm3 pango"

BPN = "pangomm"

SHRT_VER = "${@d.getVar('PV').split('.')[0]}.${@d.getVar('PV').split('.')[1]}"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/pangomm/${SHRT_VER}/pangomm-${PV}.tar.xz"
SRC_URI[sha256sum] = "9e0ed474c33f8c2002ca9e2b61ca0d1f3d8e409e09e99f4d8c19eeafccf55b78"

inherit features_check meson pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

EXTRA_OECONF = " --disable-documentation "

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/*/include/ ${libdir}/pangomm-*/"

