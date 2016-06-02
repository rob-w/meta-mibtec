DESCRIPTION = "scripts and stuff"
SECTION = "base"
PRIORITY = "required"
DEPENDS = "startd"
LICENSE = "GPLv2"

PR = "r100"
LIC_FILES_CHKSUM = "file://README;md5=8d4c77fe709bede159f0b3fe1b1be5e6"
S = "${WORKDIR}"

SRC_URI = "file://README \
	file://tpanel.sh \
	file://fstab-ro \
	file://startd.sh \
	file://preload.sh \
	file://fixup.sh \
	file://my-app.sh \
	file://fdisk.cfg "

do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${sysconfdir}/rc5.d

	install -m 0755    ${WORKDIR}/startd.sh				${D}${sysconfdir}/init.d/
	install -m 0755    ${WORKDIR}/tpanel.sh				${D}${sysconfdir}/init.d/
	install -m 0755    ${WORKDIR}/preload.sh			${D}${sysconfdir}/init.d/
	install -m 0755    ${WORKDIR}/my-app.sh				${D}${sysconfdir}/init.d/
	install -m 0755    ${WORKDIR}/fixup.sh				${D}${sysconfdir}/init.d/

	install -m 0755    ${WORKDIR}/fdisk.cfg				${D}${sysconfdir}/
	install -m 0755    ${WORKDIR}/fstab-ro				${D}${sysconfdir}/

#
# Create runlevel links
#
	ln -sf ../init.d/startd.sh			${D}${sysconfdir}/rcS.d/S97startd.sh
	ln -sf ../init.d/preload.sh			${D}${sysconfdir}/rcS.d/S35preload.sh
}

