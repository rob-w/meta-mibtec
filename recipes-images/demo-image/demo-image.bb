#
# Copyright (C) 2007 OpenedHand Ltd.
# base on core-image-minimal
#
DESCRIPTION = "Demo image for MIBTEC Boards"

IMAGE_INSTALL = "task-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_FEATURES += "package-management"

inherit core-image

KERNEL_MODS = "kernel-module-libertas-sdio \
            kernel-module-libertas \
            kernel-module-cfg80211 \
            kernel-module-btmrvl \
            firmware-libertas \
            kernel-module-cfg80211 \
            kernel-module-mbcache \
            kernel-module-nls-iso8859-1 \
            kernel-module-usb-storage \
            kernel-module-mousedev \
            kernel-module-twl4030-wdt \
            kernel-module-smsc911x \
            kernel-module-edt-ft5x06 \
            kernel-module-ext2 \
            kernel-module-ext3 \
            kernel-module-ext4 \
            kernel-module-ntfs \
            "

XORG_STUFF = " xserver-xorg \
            xserver-xorg-extension-glx \
            xf86-video-omapfb \
            xf86-video-fbdev \
            xf86-input-evdev \
            xf86-input-tslib \
            xf86-input-keyboard \
            xf86-input-mouse \
            xserver-xorg-extension-dri2 \
            xserver-xorg-extension-dri2 \
            xserver-xorg-extension-glx \
            xinput-calibrator \
            "

UI_STUFF = " matchbox-wm \
            sato-icon-theme \
            xcursor-transparent-theme \
            rxvt-unicode \
            xhost \
            xrdb \
            xauth \
            hicolor-icon-theme \
            gdk-pixbuf-loader-png \
            gdk-pixbuf-loader-xpm \
            gdk-pixbuf-loader-jpeg \
            pango-module-basic-x \
            pango-module-basic-fc \
            ttf-bitstream-vera\
            gtk-engine-clearlooks \
            gtk-theme-clearlooks \
            x11vnc \
            xdpyinfo \
            xset \
            task-core-gtk-directfb \
            fbida \
            "

ALSA_STUFF = "alsa-utils-amixer \
            alsa-utils-aplay \
            alsa-utils-alsamixer \
            "

3D_STUFF = "omap3-sgx-modules \
            libgles-omap3 \
            libgles-omap3-x11wsegl \
            libgles-omap3-x11demos \
            fbset \
            "

GST_STUFF = "gst-meta-base\
            gstreamer \
            gst-plugin-mad \
            gst-plugin-audioconvert \
            gst-plugin-audioresample \
            gst-plugins-good \
            gst-plugins-bad \
            gst-plugins-ugly \
           "

CLUTTER_TASK = "task-core-clutter-core \
            task-core-clutter-tests \
            task-core-clutter-apps \
            "

NETWORK_STUFF = "openssh \
            nfs-utils \
            nfs-utils-client \
            wireless-tools \
            bluez4 \
            wpa-supplicant \
            ethtool \
            xinetd \
            "

IMAGE_INSTALL += "mtd-utils \
            ${KERNEL_MODS} \
            ${XORG_STUFF} \
            ${CLUTTER_TASK} \
            ${ALSA_STUFF} \
            ${UI_STUFF} \
            ${NETWORK_STUFF} \
            ${3D_STUFF} \
            devmem2 \
            psplash-mis \
            psplash-support \
            lsof \
            systemd \
            strace \
            cronie \
            ncurses \
            tcl \
            tk \
            boost \
            boost-program-options \
            bash \
            procps \
            qt4-embedded \
            "
