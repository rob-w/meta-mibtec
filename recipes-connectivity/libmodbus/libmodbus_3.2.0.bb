SUMMARY = "Modbus library"
DESCRIPT = "provides functions to drive a modbus RTU"
HOMEPAGE = "http://www.libmodbus.org/"
SECTION = "libs/network"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=4fbd65380cdd255951079008b364516c"
DEPENDS = ""
INC_PR = "r0"
SRC_URI = "https://github.com/stephane/libmodbus/releases/download/v${PV}/libmodbus-${PV}.tar.gz"
SRC_URI[md5sum] = "bbe431b92f85a70eb74f9e8f157b3f8c"
SRC_URI[sha256sum] = "72239f319b9b8483e3d393c5a60865d734fcff18a8abbb2486e389834a2f6ef1"

inherit autotools

