SUMMARY = "GNOME Flashback (GNOME 2) session"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit gnomebase gsettings gtk-icon-cache gettext upstream-version-is-even features_check

REQUIRED_DISTRO_FEATURES = "x11 polkit systemd pam"

DEPENDS += " \
    upower \
    ibus \
    libxkbfile \
    polkit \
    metacity \
    gdm \
    gnome-desktop3 \
    gnome-bluetooth \
    gnome-panel \
"

SRC_URI[archive.sha256sum] = "953cdd14df11b60fe5cc9b564ff2b3d3c30e60c62a4e52b62417b2881bf6a1e4"

do_install_append() {
    # no oe-layer has compiz -> remove dead session
    rm -f ${D}${datadir}/xsessions/gnome-flashback-compiz.desktop
}

FILES_${PN} += " \
    ${datadir}/desktop-directories \
    ${datadir}/gnome-panel \
    ${datadir}/gnome-session \
    ${datadir}/xsessions \
    ${libdir}/gnome-panel \
    ${systemd_user_unitdir} \
"

RDEPENDS_${PN} += "metacity"
