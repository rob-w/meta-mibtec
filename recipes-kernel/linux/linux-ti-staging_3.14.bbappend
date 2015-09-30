FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb am437x-mispanel070f.dtb am437x-mispanel070h.dtb"

SRCREV = "afd029b86c646d13b3eb3e5bfa1715856587766a"
PV = "3.14.43"
BRANCH = "mis-3.14.y"

KERNEL_GIT_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
