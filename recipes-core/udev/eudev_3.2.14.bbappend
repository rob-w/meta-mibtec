FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://udev-cache.default"

INITSCRIPT_PARAMS:eudev = "start 38 S ."
