DESCRIPTION = "Example tool to enable RS485 mode"
HOMEPAGE = "http://www.mibtec.de"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://rs485-tool.c;md5=1f67dc045ad4332aae7cc8a70a4c01ad"
PR = "r1"

SRC_URI = "file://rs485-tool.c"
S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} += "${usrbindir}/*"

do_compile () {
	${CC} ${WORKDIR}/rs485-tool.c -o ${WORKDIR}/rs485-tool
}

do_install () {
	install -d ${D}/${bindir}
	install -m 0755 ${WORKDIR}/rs485-tool ${D}/${bindir}/rs485-tool
}

