FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://udev-cache.default"

INITSCRIPT_PARAMS_udev = "start 38 S ."
