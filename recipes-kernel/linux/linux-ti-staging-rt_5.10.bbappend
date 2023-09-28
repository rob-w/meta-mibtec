FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-5.10:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb \
			am437x-labeler040.dtb \
			am437x-mispanel070f.dtb \
			am437x-mispanel070h.dtb \
			am437x-mismdis070a.dtb \
			am437x-d880tsm092.dtb \
			am437x-mispanel120b.dtb \
			am335x-d850e054.dtb \
			am335x-d850basis053.dtb \
			am335x-d850anpass060.dtb \
			am335x-d850anpass062.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
SRCREV = "63c08b8786baea3cc63477ad260cae21258f0d30"
PV = "5.10.100"
BRANCH = "rt-mis-5.10.y"

#KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
KERNEL_GIT_URI = "git://home.mibtec.de:32121/data/devel/git/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "ssh"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
