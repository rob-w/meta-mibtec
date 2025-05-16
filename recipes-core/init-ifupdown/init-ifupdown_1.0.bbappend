FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://interfaces"
SRC_URI += "file://bridge-up"
SRC_URI += "file://bridge-down"

do_install:append () {
	install -m 0755 ${WORKDIR}/bridge-up ${D}${sysconfdir}/network/if-pre-up.d
	install -m 0755 ${WORKDIR}/bridge-down ${D}${sysconfdir}/network/if-down.d
}
