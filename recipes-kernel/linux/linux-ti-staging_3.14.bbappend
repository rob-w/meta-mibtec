FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb am437x-mispanel070f.dtb am437x-mispanel070h.dtb"

SRCREV = "f33bb52883ff1d4f503e7a273e8a5d24e6cd00d9"
PV = "3.14.43"
BRANCH = "mis-3.14.y"

KERNEL_GIT_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
