SUMMARY = "Analog Devices Industrial IO library"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"
DEPENDS = "avahi bison flex libxml2 ncurses"

SRCREV = "565bf68eccfdbbf22cf5cb6d792e23de564665c7"

SRC_URI = "git://github.com/analogdevicesinc/libiio.git"

S = "${WORKDIR}/git"

inherit cmake gitpkgv

PV = "0.21+git${SRCPV}"
PKGV = "0.21+git${GITPKGV}"

PACKAGES =+ "iiod-dbg iiod iio-utils-dbg iio-utils"

FILES_iiod = "${sbindir}/iiod"
FILES_iio-utils = "${bindir}"
FILES_iio-utils-dbg = "${bindir}/.debug"
