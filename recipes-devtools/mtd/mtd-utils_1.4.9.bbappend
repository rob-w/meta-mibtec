### dont install the headers in staging as they will overwrite kernel headers and therefore break with older kernels
PR = "r2"

do_install () {
        oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} INCLUDEDIR=${includedir}
}

