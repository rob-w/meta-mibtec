DESCRIPTION = "arp-scan"
HOMEPAGE = "https://github.com/royhills"
LICENSE = "GPLv3"
SECTION = "console/network"

LIC_FILES_CHKSUM = "file://AUTHORS;md5=d41b0689748321e328b30748f546862b"

DEPENDS = "libpcap"

SRC_URI = "git://github.com/royhills/arp-scan;protocol=https;branch=master"
SRCREV = "adac95f8794bc155d92cd84d798f4d9ce3d3274d"

S = "${WORKDIR}/git"

inherit autotools
