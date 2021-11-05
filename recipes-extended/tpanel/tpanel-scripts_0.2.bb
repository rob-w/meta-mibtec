DESCRIPTION = "tpanel scripts and stuff"
SECTION = "base"
PRIORITY = "required"
DEPENDS = "startd"
LICENSE = "GPLv2"

PR = "r101"
LIC_FILES_CHKSUM = "file://README;md5=de528607e16bea67502b135244e2ec27"
S = "${WORKDIR}"

SRC_URI = "file://README \
	file://tpanel.sh "

do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${bindir}

	install -m 0755    ${WORKDIR}/tpanel.sh		${D}${bindir}/
}

