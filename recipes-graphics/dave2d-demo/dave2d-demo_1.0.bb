DESCRIPTION = "D/AVE 2D Demo"
HOMEPAGE = "http://www.tes-dst.com"
LICENSE = "CLOSED"
DEPENDS = "libdave2d libdrm"

inherit pkgconfig

FILESEXTRAPATHS_prepend := "${TES_D2D_SRC_PATH}/software:"

PV = "1.0"
SRC_URI = " \
	file://demo \
"

PV_tesintern = "1.0+svnr${SRCPV}"
SRCREV = "${AUTOREV}"
SRC_URI_tesintern = "\
	${TES_D2D_SVN_PATH}/software/demo;module=dave2d-demo;protocol=https;user=${TES_SVN_USER};pswd=${TES_SVN_PASSWORD}; \
"

S = "${WORKDIR}/demo/build/linux/"

do_install () {
        install -d ${D}${datadir}/${PN}
        install -m 0755 demo ${D}${datadir}/${PN}/
}
