require picolisp.inc

DEPENDS = "openssl-native readline-native libffi-native clang-native"
PROVIDES = "picolisp-native"
RPROVIDES:${PN} = "picolisp-native"

inherit native

SRC_URI += "file://0001-pil-native.patch"

do_compile() {
	oe_runmake -C ${S}/src \
		OS=${BUILD_OS} CPU=${BUILD_ARCH} \
		CC=${STAGING_BINDIR_NATIVE}/clang \
		CFLAGS="${BUILD_CFLAGS} -fno-integrated-as" \
		LLC="${STAGING_BINDIR_NATIVE}/llc"
}

INSANE_SKIP:${PN} += "file-rdeps"
