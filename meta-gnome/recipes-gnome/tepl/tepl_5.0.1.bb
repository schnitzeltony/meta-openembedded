SUMMARY = "Tepl library eases the development of GtkSourceView-based projects"
LICENSE = "LGPL-3.0+"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-3.0-or-later.txt;md5=c51d3eef3be114124d11349ca0d7e117"

DEPENDS = " \
    glib-2.0-native \
    gtk+3 \
    gtksourceview4 \
    amtk \
    libxml2 \
    uchardet \
"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gobject-introspection gettext features_check

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

GTKDOC_MESON_OPTION = "gtk_doc"

SRC_URI[archive.sha256sum] = "b1274967609f524484b38775fa9ecb296c6d6616aabd052f286339a289912804"
