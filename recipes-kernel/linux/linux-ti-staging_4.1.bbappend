FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.1:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb am437x-mispanel070f.dtb am437x-mispanel070h.dtb"

SRCREV = "08d1737688fe11779153b25830f2cfbb2326941c"
PV = "4.1.10"
BRANCH = "mis-4.1.10"

KERNEL_GIT_URI = "git://git.ti.com/~robw/ti-linux-kernel/robw-ti-linux-kernel"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
