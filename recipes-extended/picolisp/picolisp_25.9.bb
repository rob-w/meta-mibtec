DESCRIPTION =	"PicoLisp"
HOMEPAGE = "http://software-lab.de/down.html"
AUTHOR = "Alexander Burger"
MAINTAINER = "Robert Woerle <robert@linuxdevelopment.de>"
DEPENDS = "openssl readline libffi clang clang-cross-${TARGET_ARCH} picolisp-native"
PROVIDES = "picolisp"
RPROVIDES:${PN} = "picolisp"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=034095b4fa32d26e4fcec43d09081f86"
SRC_URI[md5sum] = "e0cc09cbcb32612e601ba86a04297e31"
SRC_URI[sha256sum] = "6af0741f9b00dfdbc7ea8b51c94ac1fb18022e278bf72ca8a4b5482b06e3dc08"
SRCREV = "f2728157c6a2606dbb71f418626413ecba155273"
SRC_URI = "git://github.com/picolisp/pil21.git;protocol=https;branch=master \
	file://weaken_nosilent.patch \
	"

inherit autotools pkgconfig
S = "${WORKDIR}/git"
PR = "1"

TOOLCHAIN = "clang"
TOOLCHAIN:forcevariable = "clang"
PREFERRED_PROVIDER_llvm = "llvm"
PREFERRED_PROVIDER_llvm-native = "llvm-native"
PREFERRED_PROVIDER_nativesdk-llvm = "nativesdk-llvm"

do_configure:append() {
	touch ${S}/src/base.ll
	touch ${S}/src/ext.ll
	touch ${S}/src/ht.ll
}

do_compile() {
	oe_runmake -C ${S}/src OS=${TARGET_OS} CPU=${TARGET_ARCH} CFLAGS="${TARGET_CFLAGS} -fno-integrated-as"  LLC="${STAGING_BINDIR_NATIVE}/llc -march="${TARGET_ARCH}""
	oe_runmake so -C ${S}/src PIL=${STAGING_BINDIR_NATIVE}/pil OS=${TARGET_OS} CPU=${TARGET_ARCH} CFLAGS="${TARGET_CFLAGS} -fno-integrated-as"  LLC="${STAGING_BINDIR_NATIVE}/llc -march="${TARGET_ARCH}""
}

#INSANE_SKIP:${PN} += "ldflags"
INSANE_SKIP:${PN} += "already-stripped"
INSANE_SKIP:${PN} += "file-rdeps"

FILES:${PN} += "/usr/bin/picolisp /usr/bin/pil"
FILES:${PN} += "/pil21/bin/*"
FILES:${PN} += "/pil21/loc/*"
FILES:${PN} += "/pil21/img/*"
FILES:${PN} += "/pil21/lib/*"
FILES:${PN} += "/pil21/ext.l"
FILES:${PN} += "/pil21/lib.css"
FILES:${PN} += "/pil21/lib.l"
FILES:${PN} += "/usr/bin"
FILES:${PN} += "/usr/lib"

FILES:${PN}-staticdev = ""

do_install:prepend() {
    # Remove static libraries
    rm -f ${D}/pil21/lib/*.a
    rm -f ${D}/pil21/lib/*.la
}

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}/pil21
	install -d ${D}/pil21/bin
	install -d ${D}/pil21/img
	install -d ${D}/pil21/lib
	install -d ${D}/pil21/lib/xhtml
	install -d ${D}/pil21/lib/wip
	install -d ${D}/pil21/loc
	install -d ${D}${libdir}

	install -m 0755 ${S}/bin/*			${D}/pil21/bin/
	install -m 0755 ${S}/src/sysdef			${D}/pil21/bin/
	cp -dr --no-preserve=ownership ${S}/lib/*	${D}/pil21/lib/
        install -m 0644 ${S}/lib/picolisp.so		${D}${libdir}/

	rm -f ${D}/pil21/lib/*.a
	rm -f ${D}/pil21/lib/*.la

	install -m 0644 ${S}/loc/*			${D}/pil21/loc/
	install -m 0644 ${S}/img/*			${D}/pil21/img/
        install -m 0644 ${S}/loc/*			${D}/pil21/loc/
	install -m 0644 ${S}/ext.l			${D}/pil21/
	install -m 0644 ${S}/lib.css			${D}/pil21/
	install -m 0644 ${S}/lib.l			${D}/pil21/

	install -m 0644 ${S}/src/pico.h ${STAGING_INCDIR}
}

pkg_postinst:${PN}() {
    # Check if $D is set → running at build-time
    if [ -n "$D" ]; then
        # Create symlinks in the sysroot
	echo not
    else
        # Running on target
	ln -sf /pil21			"${libdir}/picolisp"
        ln -sf "${libdir}/bin/picolisp" "${bindir}/picolisp"
        ln -sf "${libdir}/bin/vip"      "${bindir}/vip"
        ln -sf "${libdir}/bin/pil"      "${bindir}/pil"

	# create actual sysdefs on target
	/pil21/bin/sysdef > /pil21/lib/sysdefs
    fi
}
