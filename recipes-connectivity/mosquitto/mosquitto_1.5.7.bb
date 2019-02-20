DESCRIPTION = "An Open Source MQTT v3.1/v3.1.1 Broker"
HOMEPAGE = "http://www.mosquitto.org"
DEPENDS = "openssl libwebsockets"
RDEPENDS_${PN} = "libcrypto libssl util-linux-libuuid libwebsockets"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=62ddc846179e908dc0c8efec4a42ef20"

inherit autotools

SRC_URI = "http://mosquitto.org/files/source/mosquitto-${PV}.tar.gz"

SRC_URI[md5sum] = "cdb4d2776e498d7a83b37921f9877e08"
SRC_URI[sha256sum] = "d4024c3388502d50be4192991e90d66dfb344376104df3f63846c9f201779955"

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
