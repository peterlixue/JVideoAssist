#!/bin/bash

#停止所有相机的流媒体推流服务
#直接终止所有关联服务进程
ps aux | grep srs|grep -v grep|awk '{print $2}'|xargs kill -9
echo "kill all finished"



