SUMMARY = "Modbus library"
DESCRIPT = "provides functions to drive a modbus RTU"
HOMEPAGE = "http://www.libmodbus.org/"
SECTION = "libs/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = ""
INC_PR = "r0"
SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/libm/libmodbus/libmodbus_3.0.3.orig.tar.gz"
SRC_URI[md5sum] = "b5042d833c6c132e6fb2551af133a342"
SRC_URI[sha256sum] = "6fc7cf91f7293e522afde6ae5fc605c6cd7bdca4ee2ec953db5bb91158ab8677"

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


