#!/bin/bash

## This example shows how to invoke mjpg-streamer from the command line

export LD_LIBRARY_PATH="$(pwd)"

#gc2035
 mjpg_streamer -i "./input_uvc.so -d /dev/video0 -u -f 20 -r 640x480" -o "./output_http.so -p 8081 -w ./www" &
sub_pid=$!
echo $sub_pid


 mjpg_streamer -i "./input_uvc.so -d /dev/video2 -u -f 20 -r 640x480" -o "./output_http.so -p 8082 -w ./www" &

sub_pid=$!
echo $sub_pid

 mjpg_streamer -i "./input_uvc.so -d /dev/video4 -u -f 20 -r 640x480" -o "./output_http.so -p 8083 -w ./www" &

sub_pid=$!
echo $sub_pid

 mjpg_streamer -i "./input_uvc.so -d /dev/video6 -u -f 20 -r 640x480" -o "./output_http.so -p 8084 -w ./www" &

sub_pid=$!
echo $sub_pid



