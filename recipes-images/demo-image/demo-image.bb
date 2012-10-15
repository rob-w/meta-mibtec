#Angstrom minimalist image
#gives you a small images with ssh access

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

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
            "

GPE_STUFF = " matchbox-wm \
            sato-icon-theme \
            mplayer \
            xcursor-transparent-theme \
            rxvt-unicode \
            xhost \
            xrdb \
            gpe-icons \
            gpe-sketchbook \
            gpe-gallery \
            gpe-aerial \
            startup-monitor \
            libgtkstylus \
            libgpewidget-bin \
            xauth \
            gdk-pixbuf-loader-png \
            gdk-pixbuf-loader-xpm \
            gdk-pixbuf-loader-jpeg \
            pango-module-basic-x \
            pango-module-basic-fc \
            ttf-bitstream-vera\
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

IMAGE_INSTALL = "task-boot \
            util-linux-mount util-linux-umount \
            ${DISTRO_SSH_DAEMON} \
            ${KERNEL_MODS} \
            ${XORG_STUFF} \
            ${CLUTTER_TASK \
            e2fsprogs-mke2fs \
            nfs-utils-client \
            wireless-tools \
            bluez4 \
            wpa-supplicant \
            firmware-libertas \
	    psplash-mis \
            psplash-support \
            portmap \
	    alsa-utils-amixer \
	    alsa-utils-aplay \
	    alsa-utils-alsamixer \
            lsof \
            xset \
            xclock \
            xdpyinfo \
            xinput-calibrator \
            gtk-engine-clearlooks \
            gtk-theme-clearlooks \
            tslib-calibrate \
            tslib-tests \
            mtd-utils \
            strace \
            cronie \
            x11vnc \
            ethtool \
            devmem2 \
	    ncurses \
	    tcl \
	    tk \
	    xinetd \
	    boost \
	    boost-program-options \
	    bash \
	    procps \
	    dhcp-server \
	   "

export IMAGE_BASENAME = "demo-image"
IMAGE_LINGUAS = ""

inherit image

