FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.1:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb \
			am437x-mispanel070f.dtb \
			am437x-mispanel070h.dtb \
			am437x-mispanel120b.dtb"

SRCREV = "fea25f672bcd131a4a31f73e87b5dccbcf0b1a0b"
PV = "4.1.18"
BRANCH = "mis-4.1.y"
KERNEL_GIT_URI = "git://home.mibtec.de:32121/data/devel/git/linux/kernel/mibtec-kernels/"
#KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
KERNEL_GIT_PROTOCOL = "ssh"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
