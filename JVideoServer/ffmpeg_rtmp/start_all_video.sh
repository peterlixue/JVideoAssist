#!/bin/bash

## This example shows how to invoke mjpg-streamer from the command line

export LD_LIBRARY_PATH="$(pwd)"
#set var
serverIp=192.168.1.101

#camera 1
ffmpeg \
-f v4l2 -r 25 -i /dev/video0 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1936/live/livestream &
sub_pid=$!
echo $sub_pid

#camera 2
ffmpeg \
-f v4l2 -r 25 -i /dev/video2 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1937/live/livestream &
sub_pid=$!
echo $sub_pid

#camera 3
ffmpeg \
-f v4l2 -r 25 -i /dev/video4 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1938/live/livestream &
sub_pid=$!
echo $sub_pid

#camera 4
ffmpeg \
-f v4l2 -r 25 -i /dev/video6 \
-c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
-threads 0 -bufsize 512k \
-f flv rtmp://$serverIp:1939/live/livestream &
sub_pid=$!
echo $sub_pid

