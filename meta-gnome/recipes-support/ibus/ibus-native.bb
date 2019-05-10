require ${BPN}.inc

inherit native

DEPENDS += " \
    glib-2.0-native \
    dbus-native \
    iso-codes \
"

PACKAGECONFIG = ""

# for allarch iso-codes
EXTRA_NATIVE_PKGCONFIG_PATH = ":${RECIPE_SYSROOT}${datadir_native}/pkgconfig"
# for allarch unicode-ucd - just to make configure happy
EXTRA_OECONF += "--with-ucd-dir=${RECIPE_SYSROOT}${datadir_native}/unicode/ucd"

do_compile() {
    cd src
    oe_runmake ibusenumtypes.h ibusenumtypes.c
    oe_runmake unicode-parser
}

do_install() {
    install -d ${D}/${libdir}
    install -m 755 ${S}/src/.libs/libibus-*.so* ${D}/${libdir}

    install -d ${D}/${bindir}
    install -m 755 ${S}/src/.libs/unicode-parser ${D}/${bindir}
}
