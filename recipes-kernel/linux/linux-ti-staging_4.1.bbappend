FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.1:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb am437x-mispanel070f.dtb am437x-mispanel070h.dtb am437x-mispanel070g.dtb"

SRCREV = "41b978354d81ee894f3ce8285feced0774855784"
PV = "4.1.15"
BRANCH = "mis-4.1.y"

KERNEL_GIT_URI = "git://git.ti.com/~robw/ti-linux-kernel/robw-ti-linux-kernel"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
