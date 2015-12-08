DESCRIPTION = "startd deamon"
HOMEPAGE = "http://www.mibtec.de"
AUTHOR = "Robert Woerle"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;md5=ccd3062fe1687565d52706e88ee6f2f9"
PR = "r1"

SRC_URI = "file://startd.c \
           file://Makefile "

S = "${WORKDIR}/"

def get_cflags_day():
 import time
 myextracflags = time.strftime("%-d", time.gmtime())
 return myextracflags

def get_cflags_month():
 import time
 myextracflags = time.strftime("%-m", time.gmtime())
 return myextracflags

def get_cflags_year():
 import time
 myextracflags = time.strftime("%y", time.gmtime())
 return myextracflags

CFLAGS_append += "-DBDAY=${@get_cflags_day()} -DBMONTH=${@get_cflags_month()} -DBYEAR=${@get_cflags_year()}"

TARGET_CC_ARCH += "${LDFLAGS}" 

do_compile() {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/startd  ${D}${bindir}/startd
}
