#
DESCRIPTION = "Demo image for MIBTEC Boards"

IMAGE_INSTALL = "${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = "de-de en-us"

LICENSE = "MIT"

IMAGE_FEATURES += "package-management ssh-server-openssh"

inherit core-image

KERNEL_STUFF = "kernel \
            cryptodev-module \
            kernel-devicetree \
            kernel-module-dwc3 \
            kernel-module-dwc3-omap \
            kernel-module-xhci-plat-hcd \
            kernel-module-kfifo-buf \
            kernel-module-ti-am335x-adc \
            kernel-module-ltc2499 \
            kernel-module-mcp4725 \
            kernel-module-edt-ft5x06 \
            kernel-module-ap4a \
            kernel-module-ads1018 \
            kernel-module-leds-tlc591xx \
            module-init-tools-depmod \
            "

SYSTEM_STUFF = "udev \
            udev-extraconf \
            busybox \
            sysvinit \
            initscripts \
            cpuburn-neon \
            "
WAYLAND = "weston \
            weston-conf \
            weston-examples \
            librsvg \
            librsvg-gtk \
            "
GTK = "gdk-pixbuf-loader-png \
            gdk-pixbuf-loader-xpm \
            gdk-pixbuf-loader-jpeg \
            gdk-pixbuf-loader-gif \
            gdk-pixbuf-loader-ani \
            gdk-pixbuf-loader-bmp \
            gdk-pixbuf-loader-ico \
            gdk-pixbuf-loader-icns \
            gdk-pixbuf-loader-bmp \
            "

3D_STUFF = "ti-sgx-ddk-um \
            fbset \
            "

NETWORK_STUFF = "nfs-utils-client \
            init-ifupdown \
            openssh-sftp \
            ethtool \
            xinetd \
            net-snmp-client \
            iproute2 \
            iperf3 \
            "

IMAGE_INSTALL += "mtd-utils \
            ${KERNEL_STUFF} \
            ${SYSTEM_STUFF} \
            ${3D_STUFF} \
            ${WAYLAND} \
            ${GTK} \
            ${NETWORK_STUFF} \
            devmem2 \
            cpufrequtils \
            e2fsprogs \
            dosfstools \
            i2c-tools \
            lsof \
            cronie \
            watchdog \
            strace \
            gdb \
            ncurses \
            bash \
            screen \
            procps \
            tzdata \
            tzdata-europe \
            perl \
            perl-module-socket \
            gnuplot \
            startd \
            psplash-mis \
            "
