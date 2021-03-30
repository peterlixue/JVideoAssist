#!/bin/bash
ffmpeg \
-f v4l2 -r 30 -i /dev/video0 \
-c:v libx264 -s 640X480 -preset ultrafast -g 30 -b:v 400k \
-threads 0 -bufsize 400k \
-f flv rtmp://192.168.1.101:1936/live/livestream


