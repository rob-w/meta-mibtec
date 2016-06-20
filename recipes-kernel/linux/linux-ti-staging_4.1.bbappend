FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.1:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb am437x-mispanel070f.dtb \
			am437x-mispanel070h.dtb am437x-mispanel070g.dtb \
			am437x-mispanel120b.dtb"

SRCREV = "0985fb5b2617f3b5a0730de44b7dbcb58b07bf8a"
PV = "4.1.18"
BRANCH = "mis-4.1.y"

KERNEL_GIT_URI = "git://git.ti.com/~robw/ti-linux-kernel/robw-ti-linux-kernel"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
