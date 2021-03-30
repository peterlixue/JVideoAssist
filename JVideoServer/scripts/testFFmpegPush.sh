#!/bin/bash
 for((;;)); do \
        /usr/bin/ffmpeg -re -i ./doc/source.200kbps.768x320.flv \
        -vcodec copy -acodec copy \
        -f flv -y rtmp://192.168.1.101:1936/live/livestream; \
        sleep 1; \
    done

