FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb"

SRCREV = "c4b05ab50660432006adc8e91c798a68dd0141f1"
PV = "3.14.43"

#SRCREV = "7eee2f14f040c8c8c4761c3f4f79c148590294d4"
#PV = "3.14.35"
BRANCH = "mis-3.14.y"

KERNEL_GIT_URI = "git://git.mibtec.de/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
