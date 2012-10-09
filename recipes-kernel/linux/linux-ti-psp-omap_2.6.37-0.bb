require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "zImage"
COMPATIBLE_MACHINE = "igep00x0"
DEFAULT_PREFERENCE_igep00x0 = "1"

SRCREV = "d0bb7affa53e22846c88345110e5c5655208a92d"
SRC_URI = "git://git.mibtec.de/ti-psp-omap;protocol=git;branch=mis-2.6.37.y \
	   file://defconfig-mibtec "

S = "${WORKDIR}/git"

do_configure_prepend () {
	cp  ${WORKDIR}/defconfig-mibtec ${S}/igep00x0_config
}

