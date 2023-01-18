FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS += "libtirpc"
export EXTRA_CFLAGS = "${CFLAGS} -I${STAGING_INCDIR}/tirpc"
export EXTRA_LDFLAGS = "${LDFLAGS} -ltirpc"

