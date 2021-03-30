#!/bin/bash
ffmpeg \
 -r 25 -i /dev/video0 \
-vcodec h264 -acodec copy  \
  \
-f flv  rtmp://192.168.1.101:1936/live/livestream


