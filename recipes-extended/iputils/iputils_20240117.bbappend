FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://arpingupdate"
RDEPENDS:${PN}-arping = "bash"

do_install:append () {
	install -d ${D}${sysconfdir}/network/if-up.d
	install -m 0755 ${WORKDIR}/arpingupdate ${D}${sysconfdir}/network/if-up.d/
}

FILES:${PN}-arping += "${sysconfdir}/network/if-up.d/arpingupdate"
