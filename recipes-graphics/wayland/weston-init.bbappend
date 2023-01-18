PR:append = ".arago9"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://runWeston \
"

do_install:append() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/runWeston ${D}${bindir}
    rm -rf ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE:${PN} = ""
