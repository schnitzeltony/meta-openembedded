SUMMARY = "GNOME terminal"
LICENSE = "GPLv3 & GFDL-1.3"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949 \
    file://COPYING.GFDL;md5=a22d0be1ce2284b67950a4d1673dd1b0 \
"

inherit gnomebase gnome-help gettext upstream-version-is-even

DEPENDS = " \
    glib-2.0-native \
    intltool-native \
    libxml2-native \
    yelp-tools-native \
    desktop-file-utils-native \
    gtk+3 \
    gsettings-desktop-schemas \
    vte \
    dconf \
    libpcre2 \
"

SRC_URI[archive.md5sum] = "6a7d7c958fcb2cbb36bec73cc7d78f32"
SRC_URI[archive.sha256sum] = "759a2b093ca606107eb8fb53e407cdf9adce76ccee33f9fa0cd76bf594bd106a"

EXTRA_OECONF += " \
    --disable-search-provider \
    --without-nautilus-extension \
"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${datadir}/dbus-1 \
    ${systemd_user_unitdir} \
"

RRECOMMENDS_${PN} += "vte-prompt gsettings-desktop-schemas"
