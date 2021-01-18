SUMMARY = "Tracker miners and metadata extractors"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING.GPL;md5=ee31012bf90e7b8c108c69f197f3e3a4 \
    file://COPYING.LGPL;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

DEPENDS = " \
    intltool-native \
    tracker \
    zlib \
"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gsettings gobject-introspection vala manpages bash-completion features_check

SRC_URI[archive.sha256sum] = "13cefbc71d52f7746f3d37d041d8c5bc1336a40ff5dd92b5370e8650c26a898e"
SRC_URI += "file://0001-meson.build-Just-warn-if-we-build-without-libseccomp.patch"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

PACKAGECONFIG ??= " \
    gexiv2 \
    gstreamer \
    icu \
    libexif \
    libgsf \
    jpeg \
    png \
    tiff \
    xml \
    pdf \
"

PACKAGECONFIG[gexiv2]     = ",,gexiv2"
PACKAGECONFIG[gstreamer]  = ",,gstreamer1.0 gstreamer1.0-plugins-base"
PACKAGECONFIG[gupnp]      = ",,gupnp-dlna"
PACKAGECONFIG[icu]        = ",,icu"
PACKAGECONFIG[libexif]    = "-Dexif=enabled,-Dexif=disabled,libexif"
PACKAGECONFIG[libgsf]     = "-Dgsf=enabled,-Dgsf=disabled,libgsf"
PACKAGECONFIG[jpeg]       = "-Djpeg=enabled,-Djpeg=disabled,jpeg"
PACKAGECONFIG[png]        = "-Dpng=enabled,-Dpng=disabled,libpng"
PACKAGECONFIG[tiff]       = "-Dtiff=enabled,-Dtiff=disabled,tiff"
PACKAGECONFIG[xml]        = "-Dxml=enabled,-Dxml=disabled,libxml2"
PACKAGECONFIG[pdf]        = "-Dpdf=enabled,-Dpdf=disabled,poppler"
PACKAGECONFIG[upower]     = ",,upower"

# For security reasons it is strongly recommended to set add meta-security in
# your layers and 'libseccomp' to PACKAGECONFIG".
PACKAGECONFIG[libseccomp] = ",,libseccomp"
# not yet in meta-gnome
PACKAGECONFIG[rss]        = "-Dminer_rss=true,-Dminer_rss=false,libgrss"

EXTRA_OEMESON += " \
    -Dman=false \
"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/tracker3-miners \
    ${libdir}/tracker-miners-3.0 \
    ${systemd_user_unitdir} \
"
