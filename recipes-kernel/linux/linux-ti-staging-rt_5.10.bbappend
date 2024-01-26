FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-5.10:"

KERNEL_DEVICETREE = "am437x-misdimm-evm.dtb \
			am437x-mislabeler040.dtb \
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
SRCREV = "2dd939e40a96d3b2134bad696357cef9550de5f5"
BRANCH = "rt-mis-5.10.y"

PV = "5.10.100"
PR = "mis-01-2dd939e40a"

#KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
KERNEL_GIT_URI = "git://home.mibtec.de:32121/data/devel/git/linux/kernel/mibtec-kernels"
KERNEL_GIT_PROTOCOL = "ssh"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
