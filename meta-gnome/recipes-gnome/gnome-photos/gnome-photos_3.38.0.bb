SUMMARY = "Access, organize and share your photos on GNOME"
SECTION = "x11/gnome"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = " \
    glib-2.0-native \
    gdk-pixbuf-native \
    librsvg-native \
    gtk+3 \
    babl \
    gegl \
    geocode-glib \
    gnome-online-accounts \
    grilo \
    gsettings-desktop-schemas \
    libdazzle \
    libgdata \
    gfbgraph \
    tracker2 \
"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gettext upstream-version-is-even gnome-help features_check

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI[archive.sha256sum] = "667f39477579d577470740e01f37b05c62e461e6f6da6377724d8f3993e1c4c4"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/metainfo \
    ${datadir}/gnome-shell \
    ${datadir}/tracker \
"
