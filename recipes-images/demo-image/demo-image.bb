#
DESCRIPTION = "Demo image for MIBTEC Boards"
IMAGE_INSTALL = "${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_LINGUAS = "de-de en-us es-es fr-fr"
IMAGE_FEATURES += "package-management ssh-server-openssh"

LICENSE = "MIT"

inherit core-image

KERNEL_STUFF = "kernel \
            kernel-devicetree \
            cryptodev-module \
            kernel-module-dwc3 \
            kernel-module-dwc3-omap \
            kernel-module-xhci-plat-hcd \
            kernel-module-ti-am335x-adc \
            kernel-module-ltc2499 \
            kernel-module-mcp4725 \
            kernel-module-edt-ft5x06 \
            kernel-module-sx8651 \
            kernel-module-spidev \
            module-init-tools-depmod \
            "

SYSTEM_STUFF = "udev \
            udev-extraconf \
            busybox \
            sysvinit \
            initscripts \
            omapconf \
            cpuburn-neon \
            openssl-engines \
            openssl \
            gnupg \
            "
DBG = "glibc-dbg \
            glib-2.0-dbg \
            gtk+3-dbg \
            sqlite3-dbg \
            libmodbus-dbg\
            strace \
            valgrind \
            gdb \
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
WAYLAND = "weston \
            weston-conf \
            weston-examples \
            librsvg \
            librsvg-gtk \
            "
XORG_STUFF = " xserver-xorg \
            xf86-video-fbdev \
            xf86-input-evdev \
            xf86-input-tslib \
            xf86-input-keyboard \
            xf86-input-mouse \
            xserver-xf86-config \
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
            xcursor-transparent-theme \
            rxvt-unicode \
            hicolor-icon-theme \
            "

3D_STUFF = "ti-sgx-ddk-um \
            ti-sgx-ddk-km \
            fbset \
            "

NETWORK_STUFF = "nfs-utils-client \
            init-ifupdown \
            openssh-sftp \
            openssh-sftp-server \
            openssh-sftp \
            ethtool \
            xinetd \
            net-snmp-client \
            iproute2 \
            iperf2 \
            ntpdate \
            wget \
            "
TZDATA = "tzdata \
            tzdata-africa \
            tzdata-americas \
            tzdata-asia \
            tzdata-atlantic \
            tzdata-australia \
            tzdata-europe \
            tzdata-misc \
            tzdata-pacific \
            "

TOOLS = "evtest \
            cpufrequtils \
            dosfstools \
            i2c-tools \
            rng-tools \
            pv \
            canutils \
            dimm-eeprom \
            "
IMAGE_INSTALL += "${KERNEL_STUFF} \
            ${SYSTEM_STUFF} \
            ${XORG_STUFF} \
            ${WAYLAND} \
            ${DBG} \
            ${TZDATA} \
            ${3D_STUFF} \
            ${UI_STUFF} \
            ${NETWORK_STUFF} \
            devmem2 \
            e2fsprogs \
            psplash-mis \
            lsof \
            cronie \
            watchdog \
            ncurses \
            bash \
            screen \
            procps \
            "
