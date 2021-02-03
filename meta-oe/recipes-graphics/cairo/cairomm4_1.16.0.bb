SUMMARY = "C++ bindings for Cairo graphics library"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c46bda00ffbb0ba1dac22f8d087f54d9"

inherit meson 

BPN = "cairomm"

DEPENDS = "cairo libsigc++-3"

SRC_URI = "https://www.cairographics.org/releases/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "7e881492c5f9f546688c31160deb742c166fc4c68b6b8eb9920c00a0f0f144f9"

FILES_${PN}-dev += "${libdir}/cairomm-*/"

