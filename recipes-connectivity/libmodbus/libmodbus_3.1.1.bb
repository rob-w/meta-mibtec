SUMMARY = "Modbus library"
DESCRIPT = "provides functions to drive a modbus RTU"
HOMEPAGE = "http://www.libmodbus.org/"
SECTION = "libs/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = ""
INC_PR = "r0"
SRC_URI = "http://libmodbus.org/site_media/build/libmodbus-${PV}.tar.gz"
SRC_URI[md5sum] = "110f4f1f173d0b8dd1fb3ab0006d2a9f"
SRC_URI[sha256sum] = "76d93aff749d6029f81dcf1fb3fd6abe10c9b48d376f3a03a4f41c5197c95c99"

inherit autotools
#
# make install doesn't cover the shared lib
# make install-shared is just broken (no symlinks)
#
do_install_prepend () {
    install -d ${D}${libdir}
    install -d ${STAGING_INCDIR}/modbus
    oe_libinstall  -so libmodbus ${D}${libdir}
    install -m 0644 src/*.h ${STAGING_INCDIR}/modbus/
}


