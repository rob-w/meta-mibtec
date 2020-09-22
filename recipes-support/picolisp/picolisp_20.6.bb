DESCRIPTION =	"PicoLisp"
HOMEPAGE = "http://software-lab.de/down.html"
AUTHOR = "Alexander Burger"
MAINTAINER = "Robert Woerle <robert@linuxdevelopment.de>"
DEPENDS = "openssl"
#RDEPENDS_${PN} = "openssl"
PROVIDES = "picolisp"
RPROVIDES_${PN} = "picolisp /usr/bin/picolisp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=cb2b3bad6d806284b0ff73fe8b554b2e"

SRC_URI[md5sum] = "ef80b8f065f29cbcfa784dd36fe68822"
SRC_URI[sha256sum] = "8297b99669baaf6253dd92adee512cefdf043ab8af6940f6341006bb50eaa150"
SRC_URI = "http://software-lab.de/picoLisp-${PV}.tgz \
			file://Makefile.patch \
			file://Makefile64.patch "

inherit autotools pkgconfig
S = "${WORKDIR}/picoLisp"

PR = "r1"

FILES_${PN} = "/picolisp/bin/balance"
FILES_${PN} += "/picolisp/bin/httpGate"
FILES_${PN} += "/picolisp/bin/vip"
FILES_${PN} += "/picolisp/bin/utf2"
FILES_${PN} += "/picolisp/bin/pil"
FILES_${PN} += "/picolisp/bin/pilIndent"
FILES_${PN} += "/picolisp/bin/picolisp"
FILES_${PN} += "/picolisp/bin/ssl"
FILES_${PN} += "/picolisp/bin/pilPretty"
FILES_${PN} += "/picolisp/bin/watchdog"
FILES_${PN} += "/picolisp/bin/replica"
FILES_${PN} += "/picolisp/bin/psh"
FILES_${PN} += "/picolisp/bin/lat1"
FILES_${PN} += "/picolisp/dbg.l"
FILES_${PN} += "/picolisp/ext.l"
FILES_${PN} += "/picolisp/img/*"
FILES_${PN} += "/picolisp/lib/*"
FILES_${PN} += "/picolisp/lib.css"
FILES_${PN} += "/picolisp/lib.l"
FILES_${PN} += "/picolisp/loc/*"
FILES_${PN} += "/usr"
FILES_${PN} += "/etc"


FILES_${PN}-dbg = "/picolisp/bin/.debug/*"
FILES_${PN}-dbg += "/picolisp/lib/.debug/*"

do_compile () {
#	mv ${S}/bin/pil ${S}/
#	rm ${S}/bin/*
	cd ${S}/src
	oe_runmake all
#	mv ${S}/pil ${S}/bin/pil
}

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}/picolisp
	install -d ${D}/picolisp/bin
	install -d ${D}/picolisp/img
	install -d ${D}/picolisp/lib
	install -d ${D}/picolisp/loc

	install -m 0755 ${WORKDIR}/picoLisp/bin/*				${D}/picolisp/bin/
	install -m 0644 ${WORKDIR}/picoLisp/img/*				${D}/picolisp/img/
	cp -dr --no-preserve=ownership ${WORKDIR}/picoLisp/lib/*				${D}/picolisp/lib/
	install -m 0644 ${WORKDIR}/picoLisp/loc/*				${D}/picolisp/loc/

	install -m 0644 ${WORKDIR}/picoLisp/dbg.l				${D}/picolisp/
	install -m 0644 ${WORKDIR}/picoLisp/ext.l				${D}/picolisp/
	install -m 0644 ${WORKDIR}/picoLisp/lib.css				${D}/picolisp/
	install -m 0644 ${WORKDIR}/picoLisp/lib.l				${D}/picolisp/

	install -m 0644 ${S}/src/pico.h ${STAGING_INCDIR}
}

pkg_postinst_${PN} () {
	#!/bin/sh -e
	ln -sf /picolisp /usr/lib/picolisp
	ln -sf /usr/lib/picolisp/bin/picolisp /usr/bin/picolisp
	ln -sf /usr/lib/picolisp/bin/pil /usr/bin/pil
}

INSANE_SKIP_${PN} = "ldflags"
