FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-5.10:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb \
			am437x-labeler040.dtb \
			am437x-mispanel070f.dtb \
			am437x-mispanel070h.dtb \
			am437x-mismdis070a.dtb \
			am437x-mispanel120b.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
SRCREV = "bbca1e393ab4a3ceb47f5c847f6055cb37a661b8"
PV = "5.10.100"
BRANCH = "rt-mis-5.10.y"

#KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
KERNEL_GIT_URI = "git://home.mibtec.de:32121/data/devel/git/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "ssh"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
