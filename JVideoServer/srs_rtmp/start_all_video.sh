#!/bin/bash

## This example shows how to invoke mjpg-streamer from the command line

export LD_LIBRARY_PATH="$(pwd)"
#start srs server

#set ip 
serverIp=192.168.1.101

#server for camera 1
srs -c /etc/srs/myrtmp_1935.conf &

#server for camera 2
srs -c /etc/srs/myrtmp_1936.conf &

#server for camera 3
srs -c /etc/srs/myrtmp_1937.conf &

#server for camera 4
srs -c /etc/srs/myrtmp_1938.conf &




#camera 1
ffmpeg \
-f v4l2 -r 25 -i /dev/video0 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1935/live/livestream &
sub_pid=$!
echo $sub_pid

#camera 2
ffmpeg \
-f v4l2 -r 25 -i /dev/video2 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1936/live/livestream &
sub_pid=$!
echo $sub_pid

#camera 3
ffmpeg \
-f v4l2 -r 25 -i /dev/video4 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1937/live/livestream &
sub_pid=$!
echo $sub_pid

#camera 4
ffmpeg \
-f v4l2 -r 25 -i /dev/video6 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1938/live/livestream &
sub_pid=$!
echo $sub_pid

