DESCRIPTION =	"simple gtk draw test"
HOMEPAGE = "http://github.com/rob-w/gdraw"
AUTHOR = "Robert Woerle"
MAINTAINER = "Robert Woerle <rwoerle@mibtec.de>"
DEPENDS = "libgpewidget gtk+ glib-2.0"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SRCREV = "ea759114e9796834bb2e45a43fa01cf1846b2c7a"

S = "${WORKDIR}/git"

#Remove the dash below when 0.1 changes in PV
PV = "0.1"

inherit autotools pkgconfig
SRC_URI = "git://github.com/rob-w/gdraw.git;protocol=git"
CFLAGS_append += " -DBUILDDATE=${DATE}"
