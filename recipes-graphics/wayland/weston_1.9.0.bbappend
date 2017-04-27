FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"

PR_append = "-arago4"

RDEPENDS_${PN} += "weston-conf"
EXTRA_OECONF += "--enable-rdp-compositor"

SRC_URI += "file://0001-Add-soc-performance-monitor-utilites.patch"
