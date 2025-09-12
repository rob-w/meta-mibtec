FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SPLASH_IMAGES += "file://psplash-mis-img.h;outsuffix=mis"

INITSCRIPT_PARAMS = "start 4 S . stop 20 0 1 6 ."
