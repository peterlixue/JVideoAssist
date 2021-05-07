#!/bin/bash
#set -x
#set -e
export LD_LIBRARY_PATH="$(pwd)/../runlib/:$LD_LIBRARY_PATH"
#echo $LD_LIBRARY_PATH

#camera 0, rtsp server run
./livecapture 
echo "start single server00"
