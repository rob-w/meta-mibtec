SUMMARY = "Modbus library"
DESCRIPT = "provides functions to drive a modbus RTU"
HOMEPAGE = "http://www.libmodbus.org/"
SECTION = "libs/network"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=4fbd65380cdd255951079008b364516c"
DEPENDS = ""
INC_PR = "r0"
SRC_URI = "https://github.com/stephane/libmodbus/releases/download/v3.1.11/libmodbus-${PV}.tar.gz"
SRC_URI[md5sum] = "69f9cae0feeb53dc769413661044c92a"
SRC_URI[sha256sum] = "15b4b2e0f68122c2da9b195de5c330489a9c97d40b4a95d2822378dc14d780e7"

inherit autotools

