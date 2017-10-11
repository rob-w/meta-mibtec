DESCRIPTION =	"simple gtk draw test"
HOMEPAGE = "http://github.com/rob-w/gdraw"
AUTHOR = "Robert Woerle"
MAINTAINER = "Robert Woerle <rwoerle@mibtec.de>"
DEPENDS = "libgpewidget gtk+ glib-2.0"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SRCREV = "e6761bddcc296b0e5772683a2c2c5d5af86922a4"

S = "${WORKDIR}/git"

#Remove the dash below when 0.1 changes in PV
PV = "0.1"

inherit autotools pkgconfig
SRC_URI = "git://github.com/rob-w/gdraw.git;protocol=git"
