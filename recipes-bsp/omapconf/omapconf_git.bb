SUMMARY = "Diagnostic tool for TI OMAP processors"
HOMEPAGE = "https://github.com/omapconf/omapconf"

LICENSE = "GPLv2 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=205c83c4e2242a765acb923fc766e914"

PV = "1.74+git${SRCPV}"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|omap4"

BRANCH ?= "master"
SRCREV = "ff07b6992bacb1e1586c72b7d2be469caee4a347"

SRC_URI = "git://github.com/omapconf/omapconf.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake CC="${CC}" all
}

do_install () {
    oe_runmake DESTDIR=${D}${bindir} install
}

