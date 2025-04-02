# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"

PR_append = ".mibtec5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0002-Weston1.9.0-Allow-visual_id-to-be-0.patch \
	file://0003-Weston1.9.0-Fix-virtual-keyboard-display-issue-for-Q.patch \
	file://0004-Weston1.9.0-Fix-touch-screen-crash-issue.patch \
	file://0001-udev-seat-restrict-udev-enumeration-to-card0.patch \
	file://0001-Add-soc-performance-monitor-utilites.patch \
	file://0001-compositor-drm-support-RGB565-with-pixman-renderer.patch \
	file://0001-compositor-drm-fix-hotplug-weston-termination-proble.patch \
	file://0001-disable-WL_BUFFER-warning.patch \
	file://change-screenshot-path.patch \
	file://weston-image-fullscreen.patch \
"
