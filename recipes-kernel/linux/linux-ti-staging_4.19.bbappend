FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.19:"

KERNEL_DEVICETREE_ti43x = "am437x-misdimm-evm.dtb \
			am437x-mispanel070f.dtb \
			am437x-mispanel070h.dtb \
			am437x-mismdis070a.dtb \
                        am437x-labeler040.dtb \
			am437x-mispanel120b.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
SRCREV = "591f7c0626ddd767f95a4e01ee4ff26aeb46affc"
PV = "4.19.38"
BRANCH = "mis-4.19.y"

KERNEL_GIT_URI = "git://github.com/rob-w/mibtec-kernel"
KERNEL_GIT_PROTOCOL = "ssh"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
            file://configs/empty \
           "
