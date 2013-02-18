DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.27."

LICENSE = "GPLv2+ & LGPLv2.1+"
LICENSE_${PN} = "GPLv2+"
LICENSE_libudev = "LGPLv2.1+"
LICENSE_libgudev = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://src/COPYING;md5=17c4e5fb495e6707ac92a3864926f979 \
                    file://src/gudev/COPYING;md5=fb494485a7d0505308cb68e4997cc266"

# Needed for udev-extras
DEPENDS = "gperf-native usbutils acl glib-2.0 kmod"

PR = "r4"

# version specific SRC_URI
SRC_URI = "${KERNELORG_MIRROR}/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
           file://gtk-doc.make"

# generic SRC_URI
SRC_URI += " \
       file://touchscreen.rules \
       file://run.rules \
       file://modprobe.rules \
       file://links.conf \
       file://mount.sh \
       file://network.sh \
       file://local.rules \
       file://default \
       file://bootlogd \
       file://init \
       file://mount.blacklist \
"
SRC_URI[md5sum] = "2afd20ee1c790eac6d7abe0498ebb414"
SRC_URI[sha256sum] = "0f753ad9c3022a074d1c052bcee9139581db825283771ac78c0be0d1de109d0c"

inherit update-rc.d autotools
EXTRA_OECONF += " \
                  --disable-introspection \
                  --with-pci-ids-path=/usr/share/misc \
                  ac_cv_file__usr_share_pci_ids=no \
                  ac_cv_file__usr_share_hwdata_pci_ids=no \
                  ac_cv_file__usr_share_misc_pci_ids=yes \
                  --sbindir=${base_sbindir} \
                  --libexecdir=${base_libdir}/udev \
                  --with-rootlibdir=${base_libdir} \
                  --disable-gtk-doc-html \
                  --with-systemdsystemunitdir=${base_libdir}/systemd/system/ \
"

do_configure_prepend() {
	cp ${WORKDIR}/gtk-doc.make ${S}
}

INITSCRIPT_NAME = "udev"
INITSCRIPT_PARAMS = "start 03 S ."

PACKAGES =+ "${PN}-systemd libudev libgudev udev-utils udev-consolekit"

FILES_${PN}-systemd = "${base_libdir}/systemd"
RDEPENDS_${PN}-systemd += "udev"

FILES_libudev = "${base_libdir}/libudev.so.*"
FILES_libgudev = "${base_libdir}/libgudev*.so.*"

FILES_udev-utils = "${bindir}/udevadm"

RPROVIDES_${PN} = "hotplug"
FILES_${PN} += "${usrbindir}/* ${usrsbindir}/udevd"
FILES_${PN}-dbg += "${usrbindir}/.debug ${usrsbindir}/.debug"
RDEPENDS_${PN} += "module-init-tools-depmod udev-utils"
RRECOMMENDS_${PN} += "util-linux-blkid"

# udev installs binaries under $(udev_prefix)/lib/udev, even if ${libdir}
# is ${prefix}/lib64
FILES_${PN} += "/lib/udev*"
FILES_${PN}-dbg += "/lib/udev/.debug"
FILES_${PN}-dbg += "/lib/udev/udev/.debug"
 
FILES_${PN}-consolekit += "${libdir}/ConsoleKit"
RDEPENDS_${PN}-consolekit += "${@base_contains('DISTRO_FEATURES', 'x11', 'consolekit', '', d)}"

do_install () {
	install -d ${D}${usrsbindir} ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	ln -sf ${base_libdir}/udev/udev/udevd ${D}/${sbindir}/udevd

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev

	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default ${D}${sysconfdir}/default/udev

	# hack to disable bootlogd
	install -m 0755 ${WORKDIR}/bootlogd ${D}${sysconfdir}/default/bootlogd

	cp ${S}/rules/* ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/*.rules             ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/
	install -m 0644 ${WORKDIR}/links.conf          ${D}${sysconfdir}/udev/links.conf

	install -d ${D}${sysconfdir}/udev/scripts/
	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts

	touch ${D}${sysconfdir}/udev/saved.uname
	touch ${D}${sysconfdir}/udev/saved.cmdline
	touch ${D}${sysconfdir}/udev/saved.devices
	touch ${D}${sysconfdir}/udev/saved.atags

	# disable udev-cache sysv script on systemd installs
	ln -sf /dev/null ${D}/${base_libdir}/systemd/system/udev-cache.service
}
