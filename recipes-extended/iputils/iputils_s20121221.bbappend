FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://arpingupdate"

do_install_append () {
	install -d ${D}${sysconfdir}/network/if-up.d
	install -m 0755 ${WORKDIR}/arpingupdate ${D}${sysconfdir}/network/if-up.d/
}

FILES_${PN}-arping += "${sysconfdir}/network/if-up.d/arpingupdate"
