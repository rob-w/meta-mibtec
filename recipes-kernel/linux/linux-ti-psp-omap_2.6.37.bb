require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "zImage"
COMPATIBLE_MACHINE = "igep00x0"
DEFAULT_PREFERENCE_igep00x0 = "1"

SRCREV = "c5ff3c2ff0abd98087f933c8065fff4a5986d342"
SRC_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels;protocol=git;branch=mis-2.6.37.y \
	   file://defconfig-mibtec "

S = "${WORKDIR}/git"

do_configure_prepend () {
	cp  ${WORKDIR}/defconfig-mibtec ${WORKDIR}/defconfig
}

