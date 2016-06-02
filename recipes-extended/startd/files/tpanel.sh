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
fi

echo $M
