DESCRIPTION = "An Open Source MQTT v3.1/v3.1.1 Broker"
HOMEPAGE = "http://www.mosquitto.org"
DEPENDS = "openssl"
RDEPENDS_${PN} = "libcrypto libssl util-linux-libuuid libwebsockets"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=62ddc846179e908dc0c8efec4a42ef20"

inherit autotools

SRC_URI = "http://mosquitto.org/files/source/mosquitto-${PV}.tar.gz \
			file://config-mk.patch "

SRC_URI[md5sum] = "89a57f11cdfec140fa21fe3d4493b2ca"
SRC_URI[sha256sum] = "c643c7123708aadcd29287dda7b5ce7c910f75b02956a8fc4fe65ad2ea767a5f"

S = "${WORKDIR}/${PN}-${PV}"

do_compile() {
	cd ${S}
	oe_runmake
}

do_install() {
	cd ${S}
	mkdir -p ${D}${bindir}
	mkdir -p ${D}${sbindir}
	mkdir -p ${D}${libdir}
	mkdir -p ${D}${sysconfdir}
	oe_runmake install DESTDIR=${D}
}

FILES_${PN} = "${bindir} ${sbindir} ${libdir}  ${sysconfdir}"

INSANE_SKIP_${PN} = "already-stripped"
