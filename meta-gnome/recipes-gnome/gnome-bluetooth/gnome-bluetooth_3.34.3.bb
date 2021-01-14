SUMMARY = "GNOME bluetooth manager"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a \
                    file://COPYING.LIB;md5=a6f89e2100d9b6cdffcea4f398e37343 \
"

SECTION = "x11/gnome"

DEPENDS = "udev gtk+3 libnotify libcanberra bluez5"

GNOMEBASEBUILDCLASS = "meson"
GTKDOC_MESON_OPTION = "gtk_doc"

inherit features_check gnomebase gtk-icon-cache gtk-doc gobject-introspection upstream-version-is-even

REQUIRED_DISTRO_FEATURES = "x11"

# gtk-icon-cache bbclass will take care of this for us.
EXTRA_OEMESON = "-Dicon_update=false"

SRC_URI[archive.sha256sum] = "0a068e3bddbbdab46991521e6624098579abe80da242398bdd579c4ca6926422"

RDEPENDS_${PN} += "bluez5"
