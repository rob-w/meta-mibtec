#
# Copyright (C) 2007 OpenedHand Ltd.
# base on core-image-minimal
#
DESCRIPTION = "Demo image for MIBTEC Boards"

IMAGE_INSTALL = "${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_FEATURES += "package-management ssh-server-openssh"

inherit core-image

KERNEL_STUFF = "kernel \
            kernel-devicetree \
            kernel-module-dwc3 \
            kernel-module-dwc3-omap \
            kernel-module-xhci-plat-hcd \
            kernel-module-kfifo-buf \
            kernel-module-ti-am335x-adc \
            kernel-module-ltc2499 \
            kernel-module-mcp4725 \
            kernel-module-edt-ft5x06 \
            kernel-module-sx8651 \
            kernel-module-spidev \
            kernel-module-uio-pdrv-genirq \
            module-init-tools-depmod \
            "

SYSTEM_STUFF = "udev \
            udev-extraconf \
            busybox \
            sysvinit \
            initscripts \
            stat \
            omapconf \
            cpuburn-neon \
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
            xserver-xf86-config \
            xserver-startup \
            x11vnc \
            xinput \
            xhost \
            xrdb \
            xauth \
            xinput-calibrator \
            xdpyinfo \
            xset \
            xmessage \
            psplash \
            utouch-mtview \
            "

UI_STUFF = " matchbox-wm \
            sato-icon-theme \
            xcursor-transparent-theme \
            rxvt-unicode \
            hicolor-icon-theme \
            gdk-pixbuf-loader-png \
            gdk-pixbuf-loader-xpm \
            gdk-pixbuf-loader-jpeg \
            ttf-bitstream-vera\
            gtk-engine-clearlooks \
            gtk-theme-clearlooks \
            "

ALSA_STUFF = "alsa-utils-amixer \
            alsa-utils-aplay \
            alsa-utils-alsamixer \
            "

3D_STUFF = "omap5-sgx-ddk-um-linux \
            omapdrm-pvr \
            fbset \
            "

GST_STUFF = " \
            gstreamer1.0 \
            gstreamer1.0-plugins-base \
            gstreamer1.0-plugins-good \
           "

NETWORK_STUFF = "nfs-utils-client \
            wireless-tools \
            bluez4 \
            wpa-supplicant \
            init-ifupdown \
            openssh-sftp \
            ethtool \
            xinetd \
            net-snmp-client \
            iproute2 \
            iperf \
            "

IMAGE_INSTALL += "mtd-utils \
            ${KERNEL_STUFF} \
            ${SYSTEM_STUFF} \
            ${XORG_STUFF} \
            ${GST_STUFF} \
            ${3D_STUFF} \
            ${ALSA_STUFF} \
            ${UI_STUFF} \
            ${NETWORK_STUFF} \
            devmem2 \
            cpufrequtils \
            e2fsprogs \
            dosfstools \
            i2c-tools \
            psplash-mis \
            lsof \
            cronie \
            watchdog \
            strace \
            valgrind \
            gdb \
            ncurses \
            bash \
            screen \
            procps \
            tzdata \
            tzdata-europe \
            midori \
            "
