FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://volatiles"

do_install_append () {
	update-rc.d -f -r ${D} umountnfs.sh remove
	update-rc.d -r ${D} umountnfs.sh stop 19 0 1 6 .
}
