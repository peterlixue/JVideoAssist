#!/bin/bash
#set -x
#set -e
export LD_LIBRARY_PATH="$(pwd)/runlib/:$LD_LIBRARY_PATH"
#echo $LD_LIBRARY_PATH

#camera 0, rtsp server run
cd LiveRtspServer00
./livecapture &
echo "start server00"

#camera 1, rtsp server run
cd ../LiveRtspServer01
./livecapture &
echo "start server01"

#camera 2, rtsp server run
cd ../LiveRtspServer02
./livecapture &
echo "start server02"

#camera 3, rtsp server run
cd ../LiveRtspServer03
./livecapture & 
echo "start server03"

echo "OK, four camera server has been running!"


