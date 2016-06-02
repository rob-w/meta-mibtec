#!/bin/sh


case "$1" in
	start)
	echo "Starting startd"

	# fixup stuff
	if [ -e "/etc/.configured" ]
	then
		echo is configured already
	else
		/etc/init.d/fixup.sh
	fi

	M=`/etc/init.d/tpanel.sh`

	if [ "$M" -eq "3" ]
	then
		echo 5 >  /sys/bus/i2c/devices/1-0038/queue_size
		echo 35 > /sys/bus/i2c/devices/1-0038/invalidate_queue
		echo 40 > /sys/bus/i2c/devices/1-0038/threshold
		echo 10 > /sys/bus/i2c/devices/1-0038/gain
		echo 31 > /sys/bus/i2c/devices/1-0038/offset
	fi
	startd /etc/init.d/my-app.sh &
  ;;

  stop)
	echo "Stopping startd"
	killall startd
  ;;

  *)
	echo "usage: $0 { start | stop }"
  ;;
esac

exit 0
