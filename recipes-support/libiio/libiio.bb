SUMMARY = "Analog Devices Industrial IO library"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"
DEPENDS = "avahi bison flex libxml2 ncurses"

SRCREV = "c0012d04b2f885d930fc69e5658d1825bff1ff4a"

SRC_URI = "git://github.com/analogdevicesinc/libiio.git"

S = "${WORKDIR}/git"

inherit cmake gitpkgv

PV = "0.${SRCPV}"
PKGV = "0.${GITPKGV}"

PACKAGES =+ "iiod-dbg iiod iio-utils-dbg iio-utils"

FILES_iiod = "${sbindir}/iiod"
FILES_iio-utils = "${bindir}"
FILES_iio-utils-dbg = "${bindir}/.debug"
