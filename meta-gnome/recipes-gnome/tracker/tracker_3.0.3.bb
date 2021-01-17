SUMMARY = "Tracker is a file search engine"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING.GPL;md5=ee31012bf90e7b8c108c69f197f3e3a4 \
    file://COPYING.LGPL;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

DEPENDS = " \
    libxml2-native \
    dbus-native \
    glib-2.0 \
    sqlite3 \
    libarchive \
    dbus \
    icu \
    json-glib \
    libsoup-2.4 \
    libstemmer \
"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase upstream-version-is-even gsettings gobject-introspection vala gtk-doc manpages bash-completion features_check

SRC_URI[archive.sha256sum] = "6f5c84ab3be1eda520501b2aed7221616a0cf152910c537757b538bc05effca3"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST_append = " introspection"

do_write_config_append() {
    # Important note: do not remove fts5 from sqlite3's PACKAGECONFIG!!!
    # otherwise you'll get configure fail with
    # "FTS support was enabled but SQLite doesn't have the FTS module built in"
    echo "[properties]" > ${WORKDIR}/meson-tracker.cross
    echo "sqlite3_has_fts5 = 'true'" >> ${WORKDIR}/meson-tracker.cross
}

# background on disable man: with asciidoc-native in DEPENDS we still see
# | cannot parse /etc/asciidoc/docbook-xsl/manpage.xsl
EXTRA_OEMESON = " \
    --cross-file ${WORKDIR}/meson-tracker.cross \
    -Dman=false \
"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/tracker3 \
    ${libdir}/tracker-3.0 \
    ${systemd_user_unitdir} \
"
