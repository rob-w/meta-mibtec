FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://arping.sh"

do_install:append () {
	install -d ${D}${sysconfdir}/network/if-up.d
	install -m 0755 ${WORKDIR}/arping.sh ${D}${sysconfdir}/network/if-up.d/
}

FILES:${PN}-arping += "${sysconfdir}/network/if-up.d/arping.sh"
