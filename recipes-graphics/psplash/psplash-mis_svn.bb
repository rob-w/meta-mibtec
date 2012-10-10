require psplash.inc
require psplash-ua.inc

ALTERNATIVE_PRIORITY = "10"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=psplash;protocol=http \
          file://psplash-poky-img.h \
          file://psplash-bar-img.h \
          file://psplash-default \
          file://splashfuncs \
          file://psplash-init"
S = "${WORKDIR}/psplash"

# This really should be default, but due yo openmoko hack below, can't be easily
SRC_URI_append_angstrom = " file://logo-math.patch "

