DESCRIPTION = "libwebsockets library"
HOMEPAGE = "https://libwebsockets.org"
DEPENDS = "zlib openssl"
RDEPENDS_${PN} = "libcrypto libssl util-linux-libuuid"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=041a1dec49ec8a22e7f101350fd19550"

inherit autotools cmake

SRC_URI="http://git.libwebsockets.org/cgi-bin/cgit/libwebsockets/snapshot/libwebsockets-1.23-chrome32-firefox24.tar.gz"

SRC_URI[md5sum] = "b39c559c62192128bf4c3d8eedd992a8"
SRC_URI[sha256sum] = "8d94a75ed1b69571d251e79512a424de51a411bafd57a66ccbe690b560a41359"

S="${WORKDIR}/libwebsockets-1.23-chrome32-firefox24"

EXTRA_OECONF += "--enable-openssl --enable-libcrypto"

# add ${PN}-test-server package
PACKAGES =+ "${PN}-test-server"

FILES_${PN}-test-server += "${bindir}/libwebsockets-test-* \
							${datadir}/libwebsockets-test-server"

RDEPENDS_${PN}-test-server += "${PN}"


do_compile_prepend() {
	export LD_LIBRARY_PATH=${STAGING_LIBDIR_NATIVE} 
	cmake .
}
