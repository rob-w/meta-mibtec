FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f882d431dc0f32f1f44c0707aa41128"

SRC_URI += "file://disable-blacklist-as-we-got-the.patch"
