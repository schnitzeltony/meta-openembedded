SUMMARY = "GNOME calendar"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SECTION = "x11/gnome"

DEPENDS = " \
    gtk+3 \
    libical \
    gsettings-desktop-schemas \
    evolution-data-server \
    libsoup-2.4 \
    libdazzle \
    libhandy \
    libgweather \
    geoclue \
"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gsettings gtk-icon-cache gettext features_check upstream-version-is-even

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI += "file://0001-project-Switch-to-libhandy-1.patch"
SRC_URI[archive.sha256sum] = "d121bb34b08b6ea601f5dbba43a4b1613a6e5493fc0b1e2ecc90c666711a912d"

FILES_${PN} += " \
    ${datadir}/gnome-shell \
    ${datadir}/metainfo \
    ${datadir}/dbus-1 \
"

