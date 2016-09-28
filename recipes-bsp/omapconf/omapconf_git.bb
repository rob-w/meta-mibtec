DESCRIPTION = "Diagnostic tool for TI OMAP processors"
HOMEPAGE = "https://github.com/omapconf/omapconf"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=205c83c4e2242a765acb923fc766e914"

PV = "1.71"
PR = "r0"

COMPATIBLE_MACHINE = "igep0020|ti33x|omap-a15|omap4|am437x-evm"

BRANCH ?= "next"
SRCREV = "4075c78d7611a41e0bd98797fba7223ff17af4fc"

SRC_URI = "git://github.com/omapconf/omapconf.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake CROSS_COMPILE=${TARGET_PREFIX} install
}

do_install () {
    oe_runmake DESTDIR=${D}${bindir} install
}

