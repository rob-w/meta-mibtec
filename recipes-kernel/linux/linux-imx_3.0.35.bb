require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for IMX processors"
KERNEL_IMAGETYPE = "zImage"
COMPATIBLE_MACHINE = "imx6qsabrelite"
DEFAULT_PREFERENCE_mx6qsabrelite = "1"

SRCREV = "d0bb7affa53e22846c88345110e5c5655208a92d"
SRC_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels;protocol=git;branch=karo-3.0.35 \
	   file://defconfig-mibtec "

S = "${WORKDIR}/git"

do_configure_prepend () {
	cp  ${WORKDIR}/defconfig-mibtec ${WORKDIR}/defconfig
}

