SUMMARY = "Modbus library"
DESCRIPT = "provides functions to drive a modbus RTU"
HOMEPAGE = "http://www.libmodbus.org/"
SECTION = "libs/network"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=4fbd65380cdd255951079008b364516c"
DEPENDS = ""
PR = "r1"
SRC_URI = "http://libmodbus.org/site_media/build/libmodbus-${PV}.tar.gz \
	file://0001-Fix-modbus_reply-for-TCP-when-unit-id-0-fixes-376.patch \
	file://timeout.patch"

SRC_URI[md5sum] = "b1a8fd3a40d2db4de51fb0cbcb201806"
SRC_URI[sha256sum] = "c8c862b0e9a7ba699a49bc98f62bdffdfafd53a5716c0e162696b4bf108d3637"

inherit autotools

