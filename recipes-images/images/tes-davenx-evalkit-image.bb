DESCRIPTION = "An image for easy evaluation of the TES DaveNX IP Core and the TES OpenGL ES 2.0 implementation, including a full command line, Qt5 (Debug) and handy development tools."


include tes-davenx-evalkit-base.inc
inherit populate_sdk_base populate_slimsdk_base


#
# Qt dependencies
# Packages that enable simple and easy development of Qt
# applications: automatic download to target, debugging on
# target, ...
#
IMAGE_INSTALL += " pkgconfig gdbserver openssh-sftp-server gdb tes-flash-mmc"


#
# Add very handy development tools
#
IMAGE_INSTALL += " \
	valgrind \
	devmem2 \
	i2c-tools \
	e2fsprogs-resize2fs \
	sshfs-fuse \
	rsync \
"


#
# Add the TES tutorials and tests
#
IMAGE_INSTALL += " \
	dnx-integration-test \
	hellogl \
	egles-test \
	tes-autorun \
"


#
# Add KMS library test to image (modetest, ...)
#
CORE_IMAGE_EXTRA_INSTALL += " \
	libdrm-tests \
"


#
# Add debugging and developer utilities
#
EXTRA_IMAGE_FEATURES += "debug-tweaks"
EXTRA_IMAGE_FEATURES_tesdebug += "tools-profile dbg-pkgs"
PACKAGE_DEBUG_SPLIT_STYLE_tesdebug = "debug-file-directory"


#
# Inhibit striping (to enable readable profiling tool outputs)
#
INHIBIT_PACKAGE_STRIP_tesdebug = "1"


#
# Add smart package manager
#
IMAGE_FEATURES += "package-management"

#
# Set EXT3 partition to 2GB == 2097152kB
#
IMAGE_ROOTFS_SIZE = "2097152"

export IMAGE_BASENAME="tes-davenx-evalkit-image"


###############################################################################
# SDK section
#


#
# Add Linux Kernel sources to SDK
#
TOOLCHAIN_TARGET_TASK += "kernel-devsrc libdrm-dev"
TOOLCHAIN_HOST_TASK += "nativesdk-kernel-devsrc-env"

#
# Add TES sources to SDK
#
TOOLCHAIN_TARGET_TASK += " \
        exhibdemo-src \
        dnx-integration-test-src \
        hellogl-src \
        egles-test-src \
"


#
# Contents of slim SDK (SDK for OpenGL only development)
#
SLIMSDK_INSTALL = "\
	hellogl \
"
