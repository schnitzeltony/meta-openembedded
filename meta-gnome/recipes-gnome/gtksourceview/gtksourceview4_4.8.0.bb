SUMMARY = "Portable C library for multiline text editing"
HOMEPAGE = "http://projects.gnome.org/gtksourceview/"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS = "gtk+3 libxml2 intltool-native gnome-common-native glib-2.0-native"

BPN = "gtksourceview"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase lib_package gettext features_check gtk-doc gobject-introspection vala

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI[archive.sha256sum] = "00a19121500cedf1bae97f35af865d839841fd785d9facf188498e13975b4e1a"

GIR_MESON_OPTION = 'gir'
GTKDOC_MESON_OPTION = "gtk_doc"

FILES_${PN} += "${datadir}/gtksourceview-4"
