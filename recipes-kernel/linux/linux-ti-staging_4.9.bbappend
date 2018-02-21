FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.4:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb \
			am437x-mispanel070f.dtb \
			am437x-mispanel070h.dtb \
			am437x-mismdis070a.dtb \
			am437x-mispanel120b.dtb"

SRCREV = "2c005e5c13ae0128778f309bb7f2597584bdaed3"
PV = "4.9.0"
BRANCH = "mis-4.9.y"

KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
#KERNEL_GIT_URI = "git://home.mibtec.de:32121/data/devel/git/linux/kernel/mibtec-kernel"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
