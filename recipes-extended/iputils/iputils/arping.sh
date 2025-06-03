#!/bin/sh
arping -c 1 -A -I "$IFACE" "$IF_ADDRESS"

