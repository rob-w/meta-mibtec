require linux-libc-headers.inc

PR = "r1"

SRC_URI += " file://connector-msg-size-fix.patch"
SRC_URI[md5sum] = "c8ee37b4fdccdb651e0603d35350b434"
SRC_URI[sha256sum] = "edbf091805414739cf57a3bbfeba9e87f5e74f97e38f04d12060e9e0c71e383a"
