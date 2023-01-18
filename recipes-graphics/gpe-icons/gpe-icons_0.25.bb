DESCRIPTION = "Common icons for GPE"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://README;md5=09ab7e5415ef6c4e1140ffa1af848a83"
PR = "${INC_PR}.0"

inherit gpe

FILES:${PN} = "${datadir}/gpe"

#Only SHR is using u-a for gpe-icons
do_configure:prepend_shr() {
        sed -i "s| \$(DESTDIR)\$(PREFIX)/share/gpe/pixmaps/| \$(DESTDIR)\$(PREFIX)/share/gpe/pixmaps.${PN}/|g" Makefile
}

require gpe-icons.inc

SRC_URI[md5sum] = "9845af06d8337fa41725c731ba3dab08"
SRC_URI[sha256sum] = "2914804f6dc63fd19247674cb6c8490f21ab66de9c267d0c55a9f891eebe0c72"
