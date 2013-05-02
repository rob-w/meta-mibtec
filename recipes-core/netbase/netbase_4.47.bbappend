FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://interfaces"
PRINC := "${@int(PRINC) + 5}"

