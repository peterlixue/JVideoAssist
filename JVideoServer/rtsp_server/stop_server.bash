#!/bin/bash
#kill process by name
set -x
ps aux | grep livecapture | grep -v grep| awk '{print $2}' | xargs -r kill -9
echo 'stop all LiveRtspServer processes !'
