DESCRIPTION =	"PicoLisp"
HOMEPAGE = "http://software-lab.de/down.html"
AUTHOR = "Alexander Burger"
MAINTAINER = "Robert Woerle <robert@linuxdevelopment.de>"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=034095b4fa32d26e4fcec43d09081f86"
SRCREV = "34a70382dca8b0df61df09e4c503c940df65410f"
SRC_URI = "git://github.com/picolisp/pil21.git;protocol=https;branch=master \
	file://0001-weaken-vars.patch \
	"

inherit autotools pkgconfig
S = "${WORKDIR}/git"
PR = "13"

TOOLCHAIN = "clang"
TOOLCHAIN:forcevariable = "clang"

do_configure:append() {
	touch ${S}/src/base.ll
	touch ${S}/src/ext.ll
	touch ${S}/src/ht.ll
}

INSANE_SKIP:${PN} += "already-stripped"
# file-rdeps"

FILES:${PN}-staticdev = ""
FILES:${PN} += "${libdir}/libpicolisp.so.${PV}"
FILES:${PN} += "${libdir}/libpicolisp.so.1"
FILES:${PN}-dev += "${libdir}/libpicolisp.so"
FILES:${PN}-dev += "${includedir}/pico*.h"
FILES:${PN}-dev += "${libdir}/pkgconfig/picolisp.pc"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${libdir}/picolisp
	install -d ${D}${libdir}/picolisp/loc
	install -d ${D}${libdir}/picolisp/img
	install -d ${D}${libdir}/picolisp/bin
	install -d ${D}${libdir}/picolisp/lib
	install -d ${D}${libdir}/picolisp/lib/vip
	install -d ${D}${libdir}/picolisp/lib/xhtml

	install -m 0755 ${S}/bin/pil				${D}${bindir}
	install -m 0755 ${S}/bin/picolisp			${D}${bindir}
	install -m 0755 ${S}/bin/httpGate			${D}${libdir}/picolisp/bin/
	install -m 0755 ${S}/bin/balance			${D}${libdir}/picolisp/bin/
	install -m 0755 ${S}/bin/psh				${D}${libdir}/picolisp/bin/
	install -m 0755 ${S}/bin/pty				${D}${libdir}/picolisp/bin/
	install -m 0755 ${S}/bin/ssl				${D}${libdir}/picolisp/bin/
	install -m 0755 ${S}/bin/vip				${D}${libdir}/picolisp/bin/
	install -m 0755 ${S}/bin/watchdog			${D}${libdir}/picolisp/bin/

	cp -dr --no-preserve=ownership ${S}/lib/*	${D}${libdir}/picolisp/lib/
	install -m 0644 ${S}/loc/*					${D}${libdir}/picolisp/loc/
	install -m 0644 ${S}/img/*					${D}${libdir}/picolisp/img/

	install -m 0644 ${S}/ext.l					${D}${libdir}/picolisp/
	install -m 0644 ${S}/lib.css				${D}${libdir}/picolisp/
	install -m 0644 ${S}/lib.l					${D}${libdir}/picolisp/
}

do_install:append() {
	install -d ${D}${libdir}/pkgconfig
	cat > ${D}${libdir}/pkgconfig/picolisp.pc <<EOF
prefix=${prefix}
exec_prefix=\${prefix}
libdir=\${exec_prefix}/lib
includedir=\${prefix}/include

Name: picolisp
Description: PicoLisp interpreter/library
Version: ${PV}
Libs: -L\${libdir} -lpicolisp
EOF
}
