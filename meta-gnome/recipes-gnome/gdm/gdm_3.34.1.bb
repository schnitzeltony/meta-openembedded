SUMMARY = "GNOME Display Manager"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = " \
    dconf-native \
    gtk+3 \
    accountsservice \
    libcanberra \
    libpam \
"

REQUIRED_DISTRO_FEATURES = "x11 systemd pam"

inherit gnomebase gobject-introspection gettext systemd useradd upstream-version-is-even distro_features_check

SRC_URI[archive.md5sum] = "65d1fd4bb85e8b133d1cbffb80ecf62e"
SRC_URI[archive.sha256sum] = "e85df657aa8d9361af4fb122014d8f123a93bfe45a7662fba2b373d839dbd8d3"

EXTRA_OECONF = " \
    --without-plymouth \
    --with-default-pam-config=openembedded \
    --with-pam-mod-dir=${base_libdir}/security \
"

do_install_append() {
    rm -rf ${D}/run ${D}${localstatedir}/run
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --no-create-home --home ${localstatedir}/lib/gdm --user-group gdm"

# Some gnome components - as gnome-panel and gnome-shell (!!) - require gdm
# libraries. To allow gnome-images using different display-manager, split them
# out into a seperate package.
PACKAGE_BEFORE_PN = "${PN}-lib"
FILES_${PN}-lib = " \
    ${libdir}/lib*${SOLIBS} \
    ${libdir}/girepository-1.0 \
"

CONFFILES_${PN} += "${sysconfdir}/gdm/custom.conf"
FILES_${PN} += " \
    ${datadir}/dconf \
    ${datadir}/gnome-session \
    ${base_libdir}/security/pam_gdm.so \
    ${localstatedir} \
    ${systemd_unitdir} \
"

