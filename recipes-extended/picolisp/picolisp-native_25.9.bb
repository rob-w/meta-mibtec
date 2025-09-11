DESCRIPTION =	"PicoLisp"
HOMEPAGE = "http://software-lab.de/down.html"
AUTHOR = "Alexander Burger"
MAINTAINER = "Robert Woerle <robert@linuxdevelopment.de>"
DEPENDS = "openssl-native readline-native libffi-native clang-native"
PROVIDES = "picolisp-native"
RPROVIDES:${PN} = "picolisp-native"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=034095b4fa32d26e4fcec43d09081f86"
SRCREV = "f2728157c6a2606dbb71f418626413ecba155273"
SRC_URI = "git://github.com/picolisp/pil21.git;protocol=https;branch=master \
	file://weaken_nosilent_native.patch \
	file://pil-native.patch \
	"

inherit autotools pkgconfig native
S = "${WORKDIR}/git"
PR = "2"

TOOLCHAIN = "clang"

do_configure:append() {
	touch ${S}/src/base.ll
	touch ${S}/src/ext.ll
	touch ${S}/src/ht.ll
}

do_compile() {
	oe_runmake -C ${S}/src \
	OS=${BUILD_OS} CPU=${BUILD_ARCH} \
	CC=${STAGING_BINDIR_NATIVE}/clang \
	CFLAGS="${BUILD_CFLAGS} -fno-integrated-as" \
	LLC="${STAGING_BINDIR_NATIVE}/llc"
}

INSANE_SKIP:${PN} += "already-stripped"
INSANE_SKIP:${PN} += "file-rdeps"
FILES:${PN}-staticdev = ""

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

	install -m 0755 ${S}/pil					${D}${bindir}
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
