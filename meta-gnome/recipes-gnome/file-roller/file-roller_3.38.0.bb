SUMMARY = "An archive manager utility for the  GNOME Environment"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    glib-2.0-native \
    gtk+3 \
    libarchive \
    libnotify \
"

inherit gnomebase gsettings itstool gnome-help gettext upstream-version-is-even mime-xdg

SRC_URI[archive.sha256sum] = "723d1c6e567d35dad5eeeaeb86b8d18705658ee73e0b3b97ea16adc7a4dc331a"

PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagekit', '', d)}"

PACKAGECONFIG[nautilus] = "-Dnautilus-actions=true,-Dnautilus-actions=false,nautilus"
PACKAGECONFIG[packagekit] = "-Dpackagekit=true,-Dpackagekit=false,"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/metainfo \
    ${libdir}/nautilus \
"
