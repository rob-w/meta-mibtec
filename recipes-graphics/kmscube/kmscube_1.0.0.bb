DESCRIPTION = "Demo application to showcase 3D graphics on SGX using kms and gbm"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=e760965096e52da8f3969dd53b6bf158"

DEPENDS = "libdrm libgbm omap5-sgx-ddk-um-linux"

COMPATIBLE_MACHINE = "ti43x|omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PR = "r4"
SRCREV = "1c8a0d26c5b1918432fd94d2ac9894b3dcdb2814"

SRC_URI = "git://git.ti.com/glsdk/kmscube.git;protocol=git"

SRC_URI:append_ti43x = " \
    file://0001-kmscube.c-init_drm-select-the-current-CRTC-display-m.patch \
"

S = "${WORKDIR}/git"

INSANE_SKIP:kmscube += "dev-deps"
