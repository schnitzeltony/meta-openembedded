SUMMARY = "C++ bindings for the atk"
SECTION = "libs"

LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1 \
                    file://COPYING.tools;md5=751419260aa954499f7abaabaa882bbe"

BPN = "atkmm"

DEPENDS = "atk glibmm3"

GNOMEBASEBUILDCLASS = "meson"

inherit features_check gnomebase

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI[archive.sha256sum] = "c93fa9f3876536391b54c307a923b7788e79796ace69a5e9141d67398c019973"

FILES_${PN}-dev += "${libdir}/*/include ${libdir}/*/proc/m4"
