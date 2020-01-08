# Debian (Linux) Combo Jack Microphone Not Detected
## The Issue
When plugging the external microphone into a combo 3.5 jack it is not detected. 
The device can be either microphone or a headset with microphone.

## The Solution
1. Open `alsa-base.conf` file
```
sudo vi /etc/modprobe.d/alsa-base.conf
```
2. Append following string
```
options snd-hda-intel model=,dell-headset-multi
```
3. Reboot machine

## Details
* Linux 5.3.0-3-amd64 #1 SMP Debian 5.3.15-1 (2019-12-07) x86_64 GNU/Linux
* KDE Plasma Ver: 5.14.5