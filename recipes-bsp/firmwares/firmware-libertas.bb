DESCRIPTION = "Firmware for Marvell sd8686 libertas wifi chipset"
LICENSE = "COMMERCIAL"

LIC_FILES_CHKSUM = "file://sd8686_v9.bin;md5=3025de2a1ed575fd691958d7da341d8b"
SRC_URI = "file://libertas-fw.tar.gz"

PR="r1"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -d ${D}${base_libdir}/firmware/libertas/
	install -m 0644 sd8686_v9_helper.bin sd8686_v9.bin ${D}${base_libdir}/firmware/libertas
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
