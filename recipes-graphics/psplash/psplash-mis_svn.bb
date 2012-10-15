require psplash.inc
require psplash-ua.inc

ALTERNATIVE_PRIORITY = "10"
LIC_FILES_CHKSUM = "file://psplash.h;beginline=1;endline=16;md5=840fb2356b10a85bed78dd09dc7745c6"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=psplash;protocol=http \
          file://psplash-poky-img.h \
          file://psplash-bar-img.h \
          file://psplash-default \
          file://splashfuncs \
          file://psplash-init"
S = "${WORKDIR}/psplash"

# This really should be default, but due yo openmoko hack below, can't be easily
SRC_URI_append_angstrom = " file://logo-math.patch "

