FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-6.6:"

KERNEL_DEVICETREE = "   ti/omap/am437x-misdimm-evm.dtb \
			ti/omap/am437x-mislabeler040.dtb \
			ti/omap/am437x-mispanel070f.dtb \
			ti/omap/am437x-mispanel070h.dtb \
			ti/omap/am437x-mismdis070a.dtb \
			ti/omap/am437x-d880tsm092.dtb \
			ti/omap/am437x-d880tsm093.dtb \
			ti/omap/am437x-d880tsm094.dtb \
			ti/omap/am437x-mispanel120b.dtb \
			ti/omap/am335x-d850e054.dtb \
			ti/omap/am335x-d850basis053.dtb \
			ti/omap/am335x-d850anpass060.dtb \
			ti/omap/am335x-d850anpass062.dtb \
			"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
SRCREV = "9a5bf6e53a0cd06d495b5798b02c96b00f9ed6ad"
BRANCH = "rt-mis-6.6.y"

#KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
KERNEL_GIT_URI = "git://home.mibtec.de:32125/data/devel/git/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "ssh"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
KERNEL_DTBDEST = "${KERNEL_IMAGEDEST}"
KERNEL_DTBVENDORED = "false"
