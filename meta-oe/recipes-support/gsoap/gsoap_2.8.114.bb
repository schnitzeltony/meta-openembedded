DESCRIPTION = "The gSOAP toolkit provides a unique SOAP-to-C/C++ language binding \
for the development of SOAP Web Services and clients."
SECTION = "devel"
LICENSE = "GPL-2.0-with-OpenSSL-exception"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4f40a941379143186f9602242c3fb729 \
                    file://GPLv2_license.txt;md5=a33672dbe491b6517750a0389063508b"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}2/${BPN}_${PV}.zip"
SRC_URI[sha256sum] = "aa70a999258100c170a3f8750c1f91318a477d440f6a28117f68bc1ded32327f"

inherit autotools

BBCLASSEXTEND = "native"

S = "${WORKDIR}/${BPN}-2.8"

EXTRA_OEMAKE_class-target = "SOAP=${STAGING_BINDIR_NATIVE}/soapcpp2"

DEPENDS = "openssl zlib flex bison bison-native"
DEPENDS_append_class-target = " gsoap-native"

do_install_append() {
    install -d ${D}${libdir}
    for lib in libgsoapssl libgsoapssl++ libgsoap libgsoapck++ libgsoap++ libgsoapck
    do
        oe_libinstall -C gsoap $lib ${D}${libdir}
    done
}

do_install_class-native() {
    oe_runmake DESTDIR=${D} BINDIR=${D}${bindir} install
}

RRECOMMENDS_${PN}-dev = "${PN}-staticdev"
