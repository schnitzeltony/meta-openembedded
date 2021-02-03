SUMMARY = "C++ bindings for the glib library"
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=42dfffebc56fec7527aac53b7a89d1d8 \
                    file://COPYING.tools;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "mm-common glib-2.0 libsigc++-3 glib-2.0-native"

GNOMEBASEBUILDCLASS = "meson"

BPN = "glibmm"

inherit gnomebase

SHRT_VER = "${@d.getVar('PV').split('.')[0]}.${@d.getVar('PV').split('.')[1]}"

SRC_URI += "file://remove-examples.patch"
SRC_URI[archive.sha256sum] = "c1f38573191dceed85a05600888cf4cf4695941f339715bd67d51c2416f4f375"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${datadir}/glibmm-* ${libdir}/glibmm-2.68/include/ ${libdir}/glibmm-2.68/proc/ ${libdir}/giomm-2.68/include/"

RDEPENDS_${PN}-dev = "perl"
