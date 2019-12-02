SUMMARY = "GNOME Shell is the graphical shell of the GNOME desktop environment"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gsettings gettext gobject-introspection features_check upstream-version-is-even bash-completion

REQUIRED_DISTRO_FEATURES = "x11 polkit"

DEPENDS = " \
    libxml2-native \
    sassc-native \
    gtk+3 \
    mutter \
    evolution-data-server \
    gcr \
    gjs \
    gnome-autoar \
    polkit \
    libcroco \
    startup-notification \
    ibus \
    gsettings-desktop-schemas \
"

GTKDOC_MESON_OPTION = "gtk_doc"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "x11 gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

SRC_URI[archive.md5sum] = "2e00c22673d069d6b919b2ca1b225d89"
SRC_URI[archive.sha256sum] = "ccd86559b9c897c219d2d2ebfdb8413efa4c1bee846427c750cb8a301b3f6d1e"

PACKAGECONFIG ??= "bluetooth nm ${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"
PACKAGECONFIG[bluetooth] = ",,gnome-bluetooth"
PACKAGECONFIG[nm] = "-Dnetworkmanager=true, -Dnetworkmanager=false, networkmanager"
PACKAGECONFIG[systemd] = "-Dsystemd=true, -Dsystemd=false, systemd"

EXTRA_OEMESON = " \
    -Dman=false \
"

do_install_append() {
    # fix shebangs
    for tool in `find ${D}${bindir} -name '*-tool'`; do
        sed -i 's:#!${PYTHON}:#!${bindir}/${PYTHON_PN}:' $tool
    done
}

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/gnome-control-center \
    ${datadir}/xdg-desktop-portal \
    ${systemd_user_unitdir} \
"

RDEPENDS_${PN} += "gsettings-desktop-schemas gdm-lib"

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${bindir}/*-tool"
RDEPENDS_${PN}-tools = "python3-core"

