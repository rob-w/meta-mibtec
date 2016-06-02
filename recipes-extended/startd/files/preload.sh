#!/bin/sh

## preload iio devices to gain a static path scheme
modprobe ti_am335x_adc
modprobe ltc2499
modprobe mcp4725
