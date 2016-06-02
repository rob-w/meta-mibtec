#!/bin/sh

umount /dev/mmcblk0p?
sleep 1
fdisk /dev/mmcblk0 < /etc/fdisk.cfg
sync
sync
sleep 2
umount /dev/mmcblk0p?
mkfs.ext4 /dev/mmcblk0p1
sync

mount /dev/mmcblk1p1 /media/emmc-boot
cp /media/emmc-boot/uEnv.txt-ro /media/emmc-boot/uEnv.txt
sync
umount /media/emmc-boot

cp /etc/fstab-ro /etc/fstab

touch /etc/.configured
rm /etc/init.d/fixup.sh
mount -o ro,remount /
