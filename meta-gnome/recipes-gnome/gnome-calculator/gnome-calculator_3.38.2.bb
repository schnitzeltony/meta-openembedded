SUMMARY = "GNOME calculator"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SECTION = "x11/gnome"

DEPENDS = " \
    yelp-tools-native \
    gtk+3 \
    libsoup-2.4 \
    libgee \
    libmpc \
    gtksourceview4 \
"

GIR_MESON_OPTION = 'disable-introspection'
GIR_MESON_ENABLE_FLAG = 'false'
GIR_MESON_DISABLE_FLAG = 'true'

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gobject-introspection gnome-help vala gtk-icon-cache gettext features_check upstream-version-is-even

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI[archive.sha256sum] = "8c83cc6433e015d15aa2a0cf3d0b187f7adb92830d39dd2e66076c73192a316b"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/metainfo \
    ${datadir}/gnome-shell \
"
