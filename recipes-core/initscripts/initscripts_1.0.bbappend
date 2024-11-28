FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://volatiles"

PR = "r1"

do_install:append () {
	update-rc.d -f -r ${D} umountnfs.sh remove
	update-rc.d -r ${D} umountnfs.sh stop 19 0 1 6 .
}
