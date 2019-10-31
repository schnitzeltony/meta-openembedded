SUMMARY = "Extended version of the C reference implementation of CommonMark"
HOMEPAGE = "https://github.com/github/cmark-gfm"
LICENSE = "BSD-2-Clause & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=81f9cae6293cc0345a9144b78152ab62"

SRC_URI = "git://github.com/github/cmark-gfm.git"
SRCREV = "b8eb2e00de094999f978e9cb02b1a78d810812d3"
S = "${WORKDIR}/git"

PV = "0.29.0.gfm.0"

inherit cmake lib_package

EXTRA_OECMAKE += " \
    -DCMARK_TESTS=OFF \
    -DCMARK_STATIC=OFF \
"
