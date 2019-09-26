DESCRIPTION = "KMS driver for the TES CDC IP core. Currently, the driver is in a ver rudimentary state and contains some special IOCTL hacks for the MesseDemo."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PV = "1.0+gitr${SRCPV}"

SRCREV = "81cc1710bb50b8a00e6d5995166cf2b8d3129ff2"
SRC_URI = "\
	git://github.com/c-thaler/cdc-kms.git;protocol=https;branch=${KERNEL_VERSION}-cdc500 \
"

S = "${WORKDIR}/git"

KERNEL_MODULE_AUTOLOAD += "cdc"
