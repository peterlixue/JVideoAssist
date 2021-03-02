#!/bin/bash
ffmpeg -r 30  -i /dev/video0 -vcodec h264 -max_delay 100 -f flv -g 5 -b 700000 rtmp://192.168.1.101:1935/live/livestream


