SUMMARY = "GNOME editor"
SECTION = "x11/gnome"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=75859989545e37968a99b631ef42722e"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    gdk-pixbuf-native \
    gtk+3 \
    gsettings-desktop-schemas \
    libpeas \
    libsoup-2.4 \
    gspell \
    gtksourceview4 \
    tepl \
"

inherit gnomebase gsettings itstool gnome-help gobject-introspection gtk-doc vala gettext features_check upstream-version-is-even mime-xdg python3targetconfig

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI[archive.sha256sum] = "0053853d2cd59cad8a1662f5b4fdcfab47b4c0940063bacd6790a9948642844d"

# gobject-introspection is mandatory (tested) and cannot be configured
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

GTKDOC_MESON_OPTION = "gtk_doc"

PACKAGES += "${PN}-python"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/metainfo \
"

FILES_${PN}-python += " \
    ${PYTHON_SITEPACKAGES_DIR} \
"

RDEPENDS_${PN} += "gsettings-desktop-schemas"
RRECOMMENDS_${PN} += "source-code-pro-fonts"
