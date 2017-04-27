PACKAGECONFIG ??= "udev ${XORG_CRYPTO} \
                    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "xwayland", "", d)} \
                    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd", "", d)} \
"
PACKAGECONFIG[glx] = "--disable-glx,--disable-glx,glproto virtual/libgl virtual/libx11"
