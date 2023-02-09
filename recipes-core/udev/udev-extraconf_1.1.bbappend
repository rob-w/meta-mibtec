FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://mount.blacklist \
	file://mount.sh"
PR = "r1"
