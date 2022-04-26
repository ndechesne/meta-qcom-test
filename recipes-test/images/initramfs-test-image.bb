require recipes-test/images/initramfs-tiny-image.bb

DESCRIPTION = "Small ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    alsa-utils-alsaucm \
    alsa-utils-amixer \
    alsa-utils-aplay \
    alsa-utils-speakertest \
    bluez5 \
    dhcpcd \
    diag \
    dropbear \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    ethtool \
    fastrpc \
    gptfdisk \
    i2c-tools \
    iw \
    lava-test-shell \
    libdrm-tests \
    lrzsz \
    pciutils \
    pd-mapper \
    qrtr \
    rmtfs \
    strace \
    tqftpserv \
    usbutils \
    util-linux-lscpu \
    util-linux-taskset \
    wpa-supplicant \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'kmscube', '', d)} \
"

# We'd like to include extra packages provided by layers which we do not depend
# on. This can be handled by .bbappends, but then image recipes including this
# one would not get all these tools. So simulate dynamic bbappend here.

# ncurses-terminfo is provided by oe-core layer, but it's only needed for gps (cgps), so include it here
PACKAGE_INSTALL_openembedded-layer += " \
    cpufrequtils \
    cryptsetup \
    devmem2 \
    gpsd \
    gpsd-machine-conf \
    gps-utils \
    lmsensors-config-libsensors \
    lmsensors-sensors \
    ncurses-terminfo-base \
"

PACKAGE_INSTALL_networking-layer += " \
    iperf2 \
    iperf3 \
    phytool \
    tcpdump \
"
