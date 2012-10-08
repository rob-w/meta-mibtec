require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "zImage"
COMPATIBLE_MACHINE = "igep00x0"
DEFAULT_PREFERENCE_igep00x0 = "1"

SRC_URI = "git://git.mibtec.de/linux/kernel/ti-psp-omap;protocol=git;branch=mis-2.6.37.y \
	   file://defconfig-mibtec "

S = "${WORKDIR}/ti-psp-omap"

do_configure_prepend () {
	cp  ${WORKDIR}/defconfig-mibtec ${WORKDIR}/defconfig
}

