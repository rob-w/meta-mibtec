FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.1:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb am437x-mispanel070f.dtb am437x-mispanel070h.dtb"

SRCREV = "48b184cc51dca1f5a039526523016bcaa1ddff62"
PV = "4.1.10"
BRANCH = "mis-4.1.y"

KERNEL_GIT_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
