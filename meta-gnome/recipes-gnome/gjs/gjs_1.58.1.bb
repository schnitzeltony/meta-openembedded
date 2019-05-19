SUMMARY = "Javascript bindings for GNOME"
LICENSE = "MIT & LGPLv2+"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=beb29cf17fabe736f0639b09ee6e76fa \
    file://COPYING.LGPL;md5=3bf50002aefd002f49e7bb854063f7e7 \
"

GNOMEBASEBUILDCLASS = "autotools"

DEPENDS = "mozjs gtk+3"

inherit gnomebase gobject-introspection vala gettext distro_features_check upstream-version-is-even

SRC_URI[archive.md5sum] = "49ae54cccbf212e2f80fa1726d5f974c"
SRC_URI[archive.sha256sum] = "b4df16ea87dc78c0df5412f9134efb14f7c510773aee117d5ad4cda75646c6f5"
SRC_URI += "file://0001-Disable-tests-on-host.patch"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " --enable-introspection --disable-introspection"

EXTRA_OECONF = " \
    --without-dbus-tests \
    --disable-installed-tests \
"

do_configure_prepend() {
    # make configure find gobject-introspection test code. Although we set
    # --disable-installed-tests gjs builds them
    sed -i 's|:$GI_DATADIR|:${STAGING_DIR_NATIVE}$GI_DATADIR|g' ${S}/configure.ac
}

FILES_${PN} += "${datadir}/gjs-1.0/lsan"

PACKAGES =+ "${PN}-valgrind"
FILES_${PN}-valgrind = "${datadir}/gjs-1.0/valgrind"
RSEPENDS_${PN}-valgrind += "valgrind"
