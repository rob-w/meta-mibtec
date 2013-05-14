require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "zImage"
COMPATIBLE_MACHINE = "igep00x0"
DEFAULT_PREFERENCE_igep00x0 = "1"

SRCREV = "45de47506f4eb94841ade37611779593c6c7c499"
SRC_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels;protocol=git;branch=mis-2.6.37.y \
	   file://defconfig-mibtec "

S = "${WORKDIR}/git"

do_configure_prepend () {
	cp  ${WORKDIR}/defconfig-mibtec ${WORKDIR}/defconfig
}

