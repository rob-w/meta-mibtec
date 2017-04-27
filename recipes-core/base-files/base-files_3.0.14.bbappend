FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://fstab"
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

dirs755 += "/media/net /media/sda /media/sda1 /media/card /media/emmc-boot /media/ram"

volatiles += "run"
dirs1777 = "/tmp /run ${localstatedir}/volatile/tmp"
