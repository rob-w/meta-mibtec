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
            ${3D_STUFF} \
            ${ALSA_STUFF} \
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
            "
