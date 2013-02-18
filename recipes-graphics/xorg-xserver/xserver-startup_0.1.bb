DESCRIPTION = "X.Org X server start up script"
HOMEPAGE = "http://www.x.org"
SECTION = "x11/base"
LICENSE = "MIT-X"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r1"

SRC_URI = "file://xinit"

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} += "${usrbindir}/*"

do_install () {
	install -d ${D}/${bindir}
	install -m 0755 ${WORKDIR}/xinit ${D}/${bindir}/xinit
}

