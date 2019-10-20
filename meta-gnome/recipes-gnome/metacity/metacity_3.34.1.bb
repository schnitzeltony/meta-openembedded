SECTION = "x11/wm"
SUMMARY = "Metacity is the boring window manager for the adult in you"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b4cce53560b8e619ffa7c830fb8761aa \
                    file://src/include/main.h;endline=24;md5=72148ede07a6dadd01de6a882d20a9ad"

PE = "1"

DEPENDS = " \
    gdk-pixbuf-native \
    gtk+3 \
    gsettings-desktop-schemas \
    startup-notification \
    libcanberra \
    libgtop \
"


# depends on startup-notification which depends on virtual/libx11
REQUIRED_DISTRO_FEATURES = "x11"

inherit gnomebase gettext upstream-version-is-even distro_features_check

SRC_URI[archive.md5sum] = "c0c10204e4d6d024cb413042c1de316b"
SRC_URI[archive.sha256sum] = "31c7d1045c390afb3bf405735b0b26c459197cbf43af37c469eb8918ce3a453d"
SRC_URI += "file://0001-drop-zenity-detection.patch"

PACKAGECONFIG[xinerama] = "--enable-xinerama,--disable-xinerama,libxinerama"
# enable as neccessary until new warnings are dealt with
PACKAGECONFIG[werror] = "--enable-Werror,--disable-Werror,,"

FILES_${PN} += " \
    ${datadir}/themes \
    ${datadir}/gnome-control-center \
    ${datadir}/gnome\
"

RDEPENDS_${PN} += "gsettings-desktop-schemas"
