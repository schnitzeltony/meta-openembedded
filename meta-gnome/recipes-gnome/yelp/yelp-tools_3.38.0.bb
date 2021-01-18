SUMMARY = "Collection of scripts and build utilities for documentation"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=d67c6f9f1515506abfea4f0d920c0774 \
    file://COPYING.GPL;md5=eb723b61539feef013de476e68b5c50a \
"

inherit gnomebase itstool

DEPENDS += " \
    libxslt-native \
    libxml2-native \
    yelp-xsl \
"

SRC_URI[archive.sha256sum] = "607ce4b3ee8517c42db924a01a78660a03317595c75825731ea86a920e2b04b0"

RDEPENDS_${PN} += "yelp-xsl"

BBCLASSEXTEND = "native"
