#!/bin/bash
ffmpeg \
-f v4l2 -r 30 -i /dev/video0 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://192.168.1.101:1935/live/livestream


