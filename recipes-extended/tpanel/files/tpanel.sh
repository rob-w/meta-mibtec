#!/bin/sh

M=2

MODEL=`cat /proc/device-tree/model  | awk '{print $2}'`
if [ "$MODEL" == "P070H111" ]
then
	M=3
fi

if [ "$MODEL" == "P070F111" ]
then
	M=4
fi

if [ "$MODEL" == "P120B110" ]
then
		M=2
		dd if=/sys/bus/i2c/devices/0-0051/eeprom of=/media/ram/temp bs=1 count=13 skip=4 >& /dev/null
		VER=`cut -c 9-12 /media/ram/temp`
		if [ "$VER" == "111" ]
		then
				M=5
		else
				dd if=/sys/bus/i2c/devices/0-0051/eeprom of=/media/ram/temp bs=1 count=13 skip=68 >& /dev/null
				VER=`cut -c 0-4 /media/ram/temp`
				if [ "$VER" == "1306" ]
				then
					M=5
				fi
				if [ "$VER" == "1304" ]
				then
					M=5
				fi
				if [ "$VER" == "1204" ]
				then
					M=5
				fi
		fi
fi

echo $M
