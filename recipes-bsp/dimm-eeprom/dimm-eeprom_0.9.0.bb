DESCRIPTION = "MIS EEPROM Tool"
HOMEPAGE = "http://www.mibtec.de"
DEPENDS = ""
RDEPENDS_${PN} = ""
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://AUTHORS;md5=eb283c878e1f03a069eb4f33c83d47a6"

SRC_URI[md5sum] = "adce3921189d3d8c3c4cd6d6c91b29ca"
SRC_URI[sha256sum] = "0034315837ddaa55306ab145895fa63b0690233e1282ae2121b02eaca9ec6108"
SRC_URI = "file://dimm-eeprom.tar.bz2"

S = "${WORKDIR}/${PN}"

TARGET_CC_ARCH += "${LDFLAGS}" 
inherit autotools pkgconfig


def get_cflags_hostname():
 import socket
 myextracflags = socket.gethostname()
 return myextracflags

def get_cflags_minute():
 import time
 myextracflags = time.strftime("%-M", time.gmtime())
 return myextracflags

def get_cflags_hour():
 import time
 myextracflags = time.strftime("%-H", time.gmtime())
 return myextracflags

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

CFLAGS:append = "-DBHOST=${@get_cflags_hostname()}"
CFLAGS:append = "-DBHOUR=${@get_cflags_hour()}"
CFLAGS:append = "-DBMINUTE=${@get_cflags_minute()}"
CFLAGS:append = "-DBDAY=${@get_cflags_day()}"
CFLAGS:append = "-DBMONTH=${@get_cflags_month()}"
CFLAGS:append = "-DBYEAR=${@get_cflags_year()}"

