FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://fstab"
SRC_URI += "file://profile"
SRC_URI += "file://motd"

dirs755 = "/bin /boot /dev ${sysconfdir} ${sysconfdir}/default \
           ${sysconfdir}/skel /lib /mnt /proc ${ROOT_HOME} /sbin \
           ${prefix} ${bindir} ${docdir} /usr/games ${includedir} \
           ${libdir} ${sbindir} ${datadir} \
           ${datadir}/common-licenses ${datadir}/dict ${infodir} \
           ${mandir} ${datadir}/misc ${localstatedir} \
           ${localstatedir}/backups ${localstatedir}/lib \
           /sys ${localstatedir}/lib/misc ${localstatedir}/spool \
           ${localstatedir}/volatile \
           ${localstatedir}/volatile/log \
           /home ${prefix}/src ${localstatedir}/local \
           /media"

dirs755 += "/data /target /media/net /media/sda /media/sda1 /media/card /media/emmc-boot /media/ram"

volatiles += "run"
dirs1777 = "/tmp /run ${localstatedir}/volatile/tmp"

BASEFILESISSUEINSTALL = "do_install_mibtec"

do_install_mibtec () {

	echo "misdimm" > ${D}${sysconfdir}/hostname

	install -m 644 ${WORKDIR}/issue*  ${D}${sysconfdir}

	printf "MIBTEC core ${DISTRO_VERSION} " >> ${D}${sysconfdir}/issue
	printf "MIBTEC core ${DISTRO_VERSION} " >> ${D}${sysconfdir}/issue.net

	printf "\\\n \\\l\n" >> ${D}${sysconfdir}/issue
	echo >> ${D}${sysconfdir}/issue

	printf "\\\n \\\l\n" >> ${D}${sysconfdir}/issue.net
	echo >> ${D}${sysconfdir}/issue.net
}

