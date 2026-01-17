require picolisp.inc

DEPENDS = "openssl readline libffi clang clang-cross-${TARGET_ARCH} picolisp-native"
PROVIDES = "picolisp"
RPROVIDES:${PN} = "picolisp"

SRC_URI += " \
	file://0001-sysdef_target_arch.patch \
	file://0001-add-sonames.patch \
	"

TARGET_LDFLAGS += "-nostartfiles -Wl,-e,_start"

EXTRA_OEMAKE = "\
    OS=${TARGET_OS} \
    CPU=${TARGET_ARCH} \
    CFLAGS='${TARGET_CFLAGS} -fno-integrated-as' \
    LLC='${STAGING_BINDIR_NATIVE}/llc -march=${TARGET_ARCH}' \
	LDFLAGS='${TARGET_LDFLAGS}' \
"

do_compile() {
	oe_runmake -C ${S}/src
    oe_runmake -C ${S}/src so

#	oe_runmake -C ${S}/src \
#		OS=${TARGET_OS} CPU=${TARGET_ARCH} \
#		CFLAGS="${TARGET_CFLAGS} -fno-integrated-as" \
#		LLC="${STAGING_BINDIR_NATIVE}/llc -march="${TARGET_ARCH}""

#	oe_runmake so -C ${S}/src \
#		OS=${TARGET_OS} CPU=${TARGET_ARCH} \
#		PIL=${STAGING_BINDIR_NATIVE}/pil \
#		CFLAGS="${TARGET_CFLAGS} -fno-integrated-as" \
#		LLC="${STAGING_BINDIR_NATIVE}/llc -march="${TARGET_ARCH}""
}

FILES:${PN} += "${libdir}/libpicolisp.so.${PV}"
FILES:${PN} += "${libdir}/libpicolisp.so.1"

FILES:${PN} += "${libdir}/libht.so.${PV}"
FILES:${PN} += "${libdir}/libht.so.1"

FILES:${PN} += "${libdir}/libext.so.${PV}"
FILES:${PN} += "${libdir}/libext.so.1"

FILES:${PN}-dev += "${libdir}/libpicolisp.so"
FILES:${PN}-dev += "${libdir}/libht.so"
FILES:${PN}-dev += "${libdir}/libext.so"

do_install:append () {
	install -d ${D}${libdir}
	install -m 0755 ${S}/src/sysdef			${D}${libdir}/picolisp/bin/

	install -m 0644 ${S}/lib/picolisp.so	${D}${libdir}/libpicolisp.so.${PV}
	ln -sf  libpicolisp.so.${PV}			${D}${libdir}/libpicolisp.so.1
	ln -sf  libpicolisp.so.1				${D}${libdir}/libpicolisp.so

	install -m 0644 ${S}/lib/ht.so			${D}${libdir}/libht.so.${PV}
	ln -sf  libht.so.${PV}					${D}${libdir}/libht.so.1
	ln -sf  libht.so.1						${D}${libdir}/libht.so

	install -m 0644 ${S}/lib/ext.so			${D}${libdir}/libext.so.${PV}
	ln -sf  libext.so.${PV}					${D}${libdir}/libext.so.1
	ln -sf  libext.so.1						${D}${libdir}/libext.so

}
