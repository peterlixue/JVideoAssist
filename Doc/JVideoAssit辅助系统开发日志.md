2021年01月20日 HRI系统 安装辅助系统

---

- 科技宅」教你用超声波实现毫米级测距，附送程序源码
  - https://baijiahao.baidu.com/s?id=1658521479319138302&wfr=spider&for=pc
  - 超声波测距模块其实有很多种，其中HC-SR04是我们较为常见的一种型号，在这里我们使用HC-SR04超声波测距模块来实现我们的测距功能。HC-SR04支持2cm-400cm之间的非接触式距离测量功能，测量精度可以到达3mm！该模块集成了超声波发射器、接收器和其他控制电路等。
  - **HC-SR04的驱动程序**
  - GPIO 引脚驱动库

- 开发板推荐,基于android系统

  - rockchip 的坑很多，粗有外表
    建議從 Hisilicon 入手
    而純 Linux 建議還是便宜的 Exynos
  - rk3399pro
  - 便宜的板大概 300 左右，树莓派也就 200 左右，搭配 androidthings 很爽的哟，运行单个 APP 稳定性更好
  - 全志A40i开发板Android应用开发指导
    - https://blog.csdn.net/linlinzia/article/details/111905443
  - 采用瑞芯微RK3288处理器（四核Cortex-A17 Mali-T764 GPU），标配2GB内存8GB存储，搭载Android5.1系统。板载WiFi，蓝牙4.0，HDMI2.0 等实用功能。
  - Android开发板可以考虑选择Firefly开发板，支持Android、Linux双系统的，瑞芯微芯片，性能强，板子接口多，参考资料也多.。
    如果只做软件开发的话，建议用Android手机毕竟很多东西都集成了
  - 2）最好选购比较热门的开发板
    孤军奋战，遇到问题没人交流是最痛苦的事儿了，因此，我会比较看重那些社区比较完善和活跃、关注度和开发者比较多的开发板，这里比较推荐一些开源硬件，如树莓派，Beaglebone等等，国内国外都很火，不仅有很多大牛分享开发经验，而且遇到问题也很容易在社区搜到解决方案。
  - 最好选择比较新的,支持新版本的Android系统或者框架
  - 海思3559
  - A40i是全志在智能工控领域的一款高性能、超高效处理器。A40i采用ARM Cortex-A7内核，运行频率高达1.2GHz，配备Mali400 MP2图形处理器及多种显示接口，并具有丰富的行业应用接口，主要应用于各种具有视频输出的工控行业。A40i配套使用的PMIC支持外部电源、USB、锂电池三种供电方式，并集成了供电路径选择和锂电池充放电管理功能，极大简化了终端产品的设计难度。

  ---

  - 监控摄像头

    - 海康威视莹石无线监控摄像头家用监控 手机远程监控器家用 C6系列云台球机 200万像素C6CN标准版 官方标配(不含内存卡)  245 16G卡

    - https://open.ys7.com/cn **萤石开放平台 PC SDK接口使用说明** http://open.ys7.com/doc/zh/book/pc/pc-sdk.html

    - 参数说明 https://www.ys7.com/item/2766.html?from=&position=tab

    - https://open.ys7.com/jssdk/product.html

      - 3行代码，即可支持播放实时视频、**回放历史录像**（SD卡/录像机/云存储）

        纯JavaScript组件，支持**H.265**\H.264，**无需插件**可兼容Chrome、Fire
    
      - 萤石摄像头
        价格：200-600
        能力：设备清晰度越高，需要的码率越大，为了保障视频质量，建议使用萤石摄像头。价格亲民不浪费资源。
      
    - 官网产品  https://www.ys7.com/cn/products-category.html#security#0
    
    -  小白入门之海康威视摄像机的二次开发
    
      -  https://blog.csdn.net/gjw_java/article/details/108547516
    
    - 海康萤石摄像头二次开发，怎么实现取流呢？
    
      - https://www.zhihu.com/question/325391869/answer/702464649
    
    - 萤石云视频SDK二次开发要点
    
      - https://zhuanlan.zhihu.com/p/46216416





---

2021年01月25日

- 在Ubuntu18.04中Android Studio开发环境搭建

- 在Ubuntu下搭建Android开发环境(AndroidStudio)

  - https://www.cnblogs.com/Eric-jx/p/10601154.html  参照这个来安装,这个比较全

  - https://www.jb51.cc/ubuntu/353905.html  有路径参考,

  - https://baijiahao.baidu.com/s?id=1604117887374452787&wfr=spider&for=pc  Android studio 等安装使用

  - jdk 路径 http://www.oracle.com/technetwork/java/javase/downloads/

  - Android studio 下载路径  http://www.android-studio.org

  - 解压到指定目录的命令  

    ```
    sudo tar zxvf ./jdk-8u20-linux-x64.gz  -C /opt
    ```

- Linux中启动模拟器出现grant current user access to /dev/kvm错误

  解决方法：打开terminal 输入代码 sudo chown username -R /dev/kvm 注意username是你用的用户名
  重新启动模拟器就可以了
  
- Ubuntu18.04下用真机调试AndroidStudio程序,怎么使得自己开发的程序在购买的华为M6的平板电脑上运行.

  - 参考https://www.pianshen.com/article/32541007724/
  - 关于平板电脑开发人员选项, USB调试模式开启的问题
    - 打开USB调试模式https://www.cnblogs.com/jpfss/p/9871005.html
    - 或者Android studio的提示
  - 关于华为平板M6,开发者模式打开,以及开发者人员选项的显示,设置操作解决
    - 用平板电脑配套的usb-typeC的连接线,接入Ubuntu 18系统的笔记本电脑的USB口
    - 然后点击设置, 点击 关于平板电脑 选项,  根据官方说明,连续点击Android的版本号,没什么用,
    - 点击EMUI版本号几次也没有提示, 后面发现连续点击 版本号(GPU Turbo)这个, 平板底部提示,你已处于开发者模式
    - 退出这个关于平板电脑设置, 点击系统和更新设置, 进入开发人员选项, 发现底部有一个调试的选项设置
    - 根据开发要求, 选择USB调试开启,其他默认选项,
    - 配置Android Studio, 根据前面的教程,建立文件,重启adb-server,列出设备,adb devices.
    - 然后回到Android studio,重新扫描设备,发现设备列表中出现了设备HuaWei Tec.
    - 点击绿色小箭头,运行app程序,发现程序以及成功在平板电脑上面运行了,可以看到AS 下面的运行信息.

- Android Studio 使用起来很卡，你们是如何解决的？

  - **Android Studio 2.0 以下：**
        每次升级/安装 Android Studio 之后最好都修改一下这个参数：到 Android Studio 安装目录，找到 bin/studio(64?).vmoptions（文件名可能因操作系统而不同，但大同小异），然后把 -xmx 后面的数字改大一点，比如 2048m 或4096m。
  - 修改android-studio/bin/studio.vmoptions   studio64.vmoptions  两个文件的以下属性就可以了-Xms2048m-Xmx2048m-XX:MaxPermSize=2048m-XX:ReservedCodeCacheSize=1024mmac下目录~/.{FOLDER_NAME}/studio.vmoptions

  - https://www.zhihu.com/question/32282404/answer/629426059
  - 

- 教程选择

  - Android平板电脑开发实战详解和典型案例 2014 过时
  - 音视频篇 - Android 图像处理技术简介 https://zhuanlan.zhihu.com/p/145119148?utm_source=wechat_session
  - Android 零基础学相机,音视频开发  实战和总结,再加上github上面的项目开源代码code
    - https://zhuanlan.zhihu.com/p/87455074
  - 一个浅封装、快速开发的 Android MVVM 开发框架
    - https://blog.csdn.net/u014608640/article/details/105576814

- git 撤销修改

  - 没有add 修改, 直接checkout 

  - add 修改了,先reset HEAD, 再checkout

  - HEAD代表当前版本，上一个版本就是HEAD^， 再上一个版本就是HEAD^^依次类推

  - push 提交到服务器了, 撤销的话,必须回退到指定的版本. git reset  --hard `HEAD`

  - 回退到指定提交版本, git reset --hard 1234567

  - 后悔进行的这个操作,怎么办, git记录了每一条的操作记录. 键入 git reflog

---

2021年01月28日10:26:21

- Android 语音交互,智能语言识别sdk

  - 解决: 1 听得清楚 2 听得明白 3 控制精准 4 体验感好 5 落地产品效果

- 阿里巴巴 智能语音交互 https://help.aliyun.com/product/30413.html?spm=a2c4g.11186623.6.540.502b3d1cYJWrgW

- 科大讯飞 平台的语音识别  https://www.xfyun.cn/doc/asr/voicedictation/Android-SDK.html#_1%E3%80%81%E7%AE%80%E4%BB%8B

  - AIUI是科大讯飞2015年推出的自然语言理解为核心的全链路人机交互语音解决方案，可快速让你的应用和设备能听会说，能理解会思考。AIUI语义信息透明开放，可云端接入，支持业务自由定制；接入了 AIUI 的应用和设备，可轻松实现查询天气、播放音视频资源、设置闹钟以及控制智能家居等语音交互能力。AIUI包含了语音唤醒、语音识别、自然语言理解、语音合成、全双工交互、翻译等多个功能，并且可以接入多个技能。创建AIUI应用

    在我的应用 https://aiui.iflyos.cn/apps  ，创建一个应用，根据输入自己的应用名称，以及应用类型，选择的平台类型是Android。

- 语音助手是一种语音控制程序，通过智能设备上的收音硬件，它能听见你的话，进行语义判断，然后在前台迅速做出回应：通过麦克风和你语音聊天，或者听令帮你操控智能设备

- 微软的 小娜 cortana 小米的小爱 阿里的天猫精灵  百度的小度 亚马逊的alxa 苹果的siri 谷歌的语音助手Google now

- 基于百度语音交互sdk开发的Android app
  
  - https://github.com/AmazingUU/Android-BaiDuVoice
- 滴滴开源的识别引擎库       
  
  - athena https://github.com/athena-team/athena   600
- 谷歌开源语音识别引擎 google live-transcribe-speech-engine  
  
  - https://github.com/google/live-transcribe-speech-engine  1k
- 研究机构 kaldi-asr/kaldi 
  - https://github.com/kaldi-asr/kaldi   10k
  - Kaldi is a toolkit for speech recognition, intended for use by speech recognition researchers and professionals
- 中文 **ASRT语音识别项目**
  - https://github.com/nl8590687/ASRT_SpeechRecognition
  - ASRT是一个基于深度学习的中文语音识别系统 资料比较全,有写数据集
- android布局设计
  -  总结就是:**尽量使用RelativeLayout + LinearLayout的weight属性搭配使用**吧
  - appbarlayout+ CoordinatyLayout+FlativeBar+ScrollView啥的,新的互动设计
- 用安卓手机实现视频监控，
  
  - https://blog.csdn.net/wxson/article/details/91987709
  
  - 发了邮件，问了作者要了开源的代码，github开源网址，项目是https://github.com/wxson7282/HomeMonitor
  
  - 作为监控摄像机的手机称为服务器端，观看监控视频的手机称为客户端。
  
    对于使用环境的要求是服务器端通过无线路由器WIFI接入互联网，客户端通过互联网远程访问服务器端
- 视频监控app开发记录技术问题
  1. Android多个视频监控在通一个Activity显示的问题
     - 我需要做一个监控视频的app,我一个界面想同时播放四个视频,于是我创建了四个surfaceview来播放,但是我同时去设置四个去播放时,最终只能显示一个。求各位大师解决
     - 你可以试试使用VideoView来播放来尝试一下，serfaceView的特性是相对于整个手机屏幕来的
  2. Android_MjpgStreamer_Raspberry
     - https://gitee.com/zwsunny/Android_MjpgStreamer_Raspberry
     - https://github.com/tancolin/App4Mjpg-streamer
     - 视频监控安卓App客户端--Mjpg-streamer推流的播放
     - mjpgStreamer库作为服务端推流，Android app客户端接受，实时显示
  3. car-eye开源平台 / Car-eye-pusher-android

---

2021年02月01日14:12:59

- 华为的M6平板有时候连接上去,开发者模式,不稳定,usb调试选项功能无法正常保持开启.

- 出现这个情况的时候 , 点击AS的扫描,或者连续开启USB调试功能,等待AS自动扫描到硬件,自动识别出来.

- 设置了 当平板"仅充电的时候提供adb功能"

- 多次点击run app后,输出

  ```
  02/01 14:15:22: Launching 'app' on HUAWEI VRD-W09.
  $ adb shell am start -n "com.example.myapplication/com.example.myapplication.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
  Waiting for process to come online...
  Connected to process 10155 on device 'huawei-vrd_w09-NVK6R21104000636'.
  Capturing and displaying logcat messages from application. This behavior can be disabled in the "Logcat output" section of the "Debugger" settings page.
  I/AwareBitmapCacher: init lrucache size: 2097152 pid=1015502/01 14:15:22: Launching 'app' on HUAWEI VRD-W09.
  $ adb shell am start -n "com.example.myapplication/com.example.myapplication.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
  Waiting for process to come online...
  Connected to process 10155 on device 'huawei-vrd_w09-NVK6R21104000636'.
  Capturing and displaying logcat messages from application. This behavior can be disabled in the "Logcat output" section of the "Debugger" settings page.
  I/AwareBitmapCacher: init lrucache size: 2097152 pid=10155
  ```

  - 
  - 【ubuntu】如何使用qt creator打开一个已有的ros工程
  - https://blog.csdn.net/ipfpm/article/details/88571925
  - 使用Cmake来打开加载工程,在qtcreator里面调试分析.  可以,解决编译,调试的问题
  - (Ubuntu)使用Qt进行ROS的图形化编程---工程环境的搭建以及调用ROS下的librviz进行地图显示（二）
    - https://www.it610.com/article/1291670658824085504.htm
    - 改CMakeLists.txt和package.xml文件, Cmake+QT来开发ros的上位机,可视化软件.

- Android SurfaceView+MediaPlayer实现几个不同的视频轮流播放

  - https://blog.csdn.net/dr_abandon/article/details/80742058

- android下实现4分屏播放4路高清h264格式的rtsp流

  - https://bbs.csdn.net/topics/390530455?page=4

- ### android recycleView 原来还可以这么用,,,,,,`显示四路视频` 

  - https://blog.csdn.net/qq_35893839/article/details/79125952  这个是我需要的
  - https://www.cnblogs.com/zhujiabin/p/9046461.html 
  - Android 使用RecyclerView实现多行水平分页的GridView效果和ViewPager效果

- 好工具 hierarchyviewer

  - 究竟怎样控制好各个控件之间的排布，如何确定各种布局的嵌套呢？既然是优秀的UI界面，我们来完全模仿，那就可以直接照搬QQ的设计排版，这里我用到了android中自带的

    层级观察器hierarchyviewer工具来分析UI的布局，hierarchyviewer是非常之实用的工具，即可以用来优化自己的布局，也可以用来参考别人优秀的布局，在\android-sdk-windows\tools目录下双击即可以使用:

  - sudo apt install hierarchyviewer

  - Ubuntu报错,gtk,swt环境问题

- xingda920813/SimpleRecyclerView

  - About Android RecyclerView 简化使用: 下拉刷新, 加载更多, 加载中/空数据/错误页面, 固定Header, 分割线, 点击监听, Item 动画, 分组显示 
  - https://github.com/xingda920813/SimpleRecyclerView

- 高仿Android QQ2012登陆界面和注册界面

- 视频播放 https://blog.csdn.net/kingroc/category_6335546.html

- # Android 播放视频(四)VideoView全屏视频播放

  - https://blog.csdn.net/kingroc/article/details/51108587

  - Android开发实践七：一个界面显示多个layout或view

- https://blog.csdn.net/zcc9618/article/details/80632320

- 播放多个视频的问题,解码器不支持
  - http://www.voidcn.com/article/p-mchkoqyc-byn.html
  - Android SurfaceView+MediaPlayer实现几个不同的视频轮流播放
  - https://blog.csdn.net/dr_abandon/article/details/80742058
  
- 路线知识图, https://zhuanlan.zhihu.com/p/104878641?utm_source=qq

- https://www.wanandroid.com/  玩Android的链接,学习指导,项目指导

- Android 咋样学？致我的2020   他讲了学习计划,提供了一些学习资源的网站和大牛链接,
  -  https://www.jianshu.com/p/4744edb2d96b
  - https://blog.csdn.net/lmj623565791
- 页面设计规范
  - 初识Material Design设计规范（精简版）https://www.shejidaren.com/material-design-thinking.html
  - Material Design 设计规范入门 https://zhuanlan.zhihu.com/p/250259688
  - 设计规范官网汇总：iOS、Material Design、IBM、Fluent……（持续更新）https://www.uisdc.com/design-specification-website

---

- 本节对Android事件处理机制中的基于回调的事件处理机制进行了讲解！核心就是事件传播的顺序 监听器优先，然后到View组件自身，最后再到Activity；返回值false继续传播，true终止传播~！
- 本节给大家介绍了Android中的事件处理机制，例子中的是onClickListener点击事件，当然除了这个以外还有其他的事件，比如onItemClickListener，凡是需要通过setXxxListener这些，基本上都是基于事件监听的！ 另外这五种方式用的比较多的是：1，2，3，5几种，看具体情况而定
- AsyncTask显得更加简单，快捷~当然，这只适合 简单的异步操作，另外，实际异步用的最多的地方就是网络操作，图片加载，数据传输等，AsyncTask 暂时可以满足初学者的需求，谢谢小应用，但是到了公司真正做项目以后，我们更多的使用第三发的 框架，比如Volley,OkHttp,android-async-http,XUtils等很多，后面进阶教程我们会选1-2个框架进行 学习，当然你可以自己找资料学习学习，但是掌握AsyncTask还是很有必要的
- 继承Activity和AppCompatActivity，只不过后者提供了一些新的东西而已！ 另外，切记，Android中的四大组件，只要你定义了，无论你用没用，都要在AndroidManifest.xml对 这个组件进行声明，不然运行时程序会直接退出，报ClassNotFindException...
- Service与Thread线程的区别
  - 其实他们两者并没有太大的关系，不过有很多朋友经常把这两个混淆了！ Thread是线程，程序执行的最小单元，分配CPU的基本单位！ 而Service则是Android提供一个允许长时间留驻后台的一个组件，最常见的 用法就是做轮询操作！或者想在后台做一些事情，比如后台下载更新！ 记得别把这两个概念混淆！
- 进程通信机制的探讨,效率,稳定性,内存数据拷贝次数
  - 为何Android使用Binder机制来实现进程间的通信？
  - **可靠性**：在移动设备上，通常采用基于Client-Server的通信方式来实现互联网与设备间的内部通信。目前linux支持IPC包括传统的管道，System V IPC，即消息队列/共享内存/信号量，以及socket中只有socket支持Client-Server的通信方式。Android系统为开发者提供了丰富进程间通信的功能接口，媒体播放，传感器，无线传输。这些功能都由不同的server来管理。开发都只关心将自己应用程序的client与server的通信建立起来便可以使用这个服务。毫无疑问，如若在底层架设一套协议来实现Client-Server通信，增加了系统的复杂性。在资源有限的手机 上来实现这种复杂的环境，可靠性难以保证。
  - **传输性能**：socket主要用于跨网络的进程间通信和本机上进程间的通信，`但传输效率低，开销大`。消息队列和管道采用存储-转发方式，即数据先从发送方缓存区拷贝到内核开辟的一块缓存区中，然后从内核缓存区拷贝到接收方缓存区，其过程至少有两次拷贝。虽然`共享内存无需拷贝，但控制复杂。`比较各种IPC方式的数据拷贝次数。共享内存：0次。Binder：1次。Socket/管道/消息队列：2次。
  - **安全性**：Android是一个开放式的平台，所以确保应用程序安全是很重要的。Android对每一个安装应用都分配了UID/PID,其中进程的UID是可用来鉴别进程身份。传统的只能由用户在数据包里填写UID/PID，这样不可靠，容易被恶意程序利用。而我们要求由内核来添加可靠的UID。 所以，出于可靠性、传输性、安全性。android建立了一套新的进程间通信方式。 ——摘自:[Android中的Binder机制的简要理解](http://www.linuxidc.com/Linux/2012-07/66195.htm)

---

2021年02月04日09:37:08

- 约束布局ConstraintLayout看这一篇就够了

  - https://www.jianshu.com/p/17ec9bd6ca8a

- Android dp px sp in dpi ppi 之间的区别和联系

  -  https://www.imooc.com/article/68262

- Android 图片资源怎么放置, drawable or mimap

- 最强 Android Studio 使用小技巧和快捷键总结

  - https://www.cnblogs.com/tsingke/p/9007833.html

- Android studio用真机调试时logcat一直输出日志?

  - https://www.zhihu.com/question/38514564

- AS 一直在Gradle syn,停止不了,如何解决

  - https://services.gradle.org/distributions/

  - 最靠谱的国内镜像方法, 解决gradle syn同步问题

  - Android Studio的Gradle一直在sync的解决办法!!!

  - https://www.pianshen.com/article/1364917595/

  - 阿里云maven镜像的地址是 http://maven.aliyun.com/nexus/content/groups/public/，我们需要在项目的根gradle文件中找到

  - 如下:

    ```
    buildscript {
        repositories {
            jcenter()
             maven { url 'http://maven.aliyun.com/nexus/content/groups/public/'}
             maven { url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
             maven { url 'http://maven.aliyun.com/nexus/content/repositories/google'}
             maven { url 'http://maven.aliyun.com/nexus/content/repositories/gradle-plugin'}
        }
    }
     
    allprojects {
        repositories {
            jcenter()
    //        maven { url "https://maven.google.com"}
             maven { url 'http://maven.aliyun.com/nexus/content/groups/public/'}
             maven { url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
             maven { url 'http://maven.aliyun.com/nexus/content/repositories/google'}
             maven { url 'http://maven.aliyun.com/nexus/content/repositories/gradle-plugin'}
        }
    }
    ```

    设置以后,选择File->Sys gradle with project files, 再次更新gradle构建文件.- 
    
    

- Android实现视频播放的几种方式

  - https://www.jianshu.com/p/a790b80f68b2
  - MediaController+VideoView实现方式
  - MediaPlayer+SurfaceView+自定义控制器
  - MediaPlayer+SurfaceView+MediaController

- [Android] Android 去掉界面标题栏的方法 https://www.cnblogs.com/wukong1688/p/10662084.html

- https://github.com/android/views-widgets-samples/tree/main/RecyclerView/ android 官方使用recycleview的例子

- 练习 ViewPager和ViewPager+Fragment联合使用方法精炼详解

  - https://blog.csdn.net/weixin_41101173/article/details/80019287?utm_medium=distribute.pc_relevant_download.none-task-blog-baidujs-1.nonecase&depth_1-utm_source=distribute.pc_relevant_download.none-task-blog-baidujs-1.nonecase

- Android 分别使用 SurfaceView 和 TextureView 来预览 Camera，获取NV21数据 https://blog.csdn.net/DevelopAndroid/article/details/104584998/

  - surfaceView优缺点
    优点：

    可以在一个独立的线程中进行绘制，不会影响主线程
    使用双缓冲机制，播放视频时画面更流畅

    缺点：

    Surface不在View hierachy中，它的显示也不受View的属性控制，所以不能进行平移，缩放等变换，也不能放在其它ViewGroup中。SurfaceView
    不能嵌套使用。

    TextureView作用
    TextureView可用于显示内容流，内容流可以是视频或者OpenGL的场景。内容流可来自应用进程或是远程其它进程。

    Textureview必须在硬件加速开启的窗口中使用。

    注意：若是软解，TextureView不会显示东西。

    TextureView优点及缺点
    优点：

    支持移动、旋转、缩放等动画，支持截图

    缺点：

    必须在硬件加速的窗口中使用，占用内存比SurfaceView高，在5.0以前在主线程渲染，5.0以后有单独的渲染线程。

- 视频画面帧的展示控件SurfaceView及TextureView对比 

  - https://hejunlin.blog.csdn.net/article/details/58582919?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control
  - 有对比的表格

- 相机视频播放 参考 https://github.com/aserbao/AserbaosAndroid 有源码和博客说明

  - https://blog.csdn.net/qq_32175491/article/details/79755424?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.control	
  - https://blog.csdn.net/DevelopAndroid/article/details/104584998/

- 解决卡顿的问题

  - viewpager+Fragment(含有recyclerview+viewpager)低端的机子切换页面滑动的时候明显的卡顿

  - https://segmentfault.com/q/1010000006654249?sort=created#

  - 你好，我做过比这个更稍微复杂的效果，不过也是ViewPager+Fragment的组合，里面也是头部轮播图+列表，不过我们是动态的，针对ViewPager+Fragment这个组合效果的话，一般网上好多建议是
    1. `Fragment采用懒加载方式`
    2.尽量使用`FragmentStateAdapter`（具体原因，你可以百度）
    3.使用缓存机制避免重复的网络请求
    4.延迟进行网络请求
    5.使用一些比较出色的开源框架，比如图片框架可以使用性能出色的Fresco。
    6.就是一些基础的知识点，比如尽量避免UI线程中过多耗时操作，
    7.就是Fragment的一些基础知识，比如生命周期控制（避免出现内存泄露或者是空指针），然后可以进行状态保存
    这些是暂时能想到的，我当时采用了这些方式，效果在低端机上还可以，

    问题搜寻解决方式；

    - Androidx 下 Fragment 懒加载的新实现 https://www.jianshu.com/p/2201a107d5b5?utm_campaign=hugo
    - 

- Android SurfaceView播放RTMP流

  - https://www.jianshu.com/p/c8db451ba4b0
  - https://gitee.com/xiachenhui/NDK_PLAY_CODE  开发代码，gitee
  - https://gitee.com/ChillingVan/AndroidInstantVideo
  - Android使用MediaPlayer和TextureView实现视频无缝切

- Android几种视频播放方式，VideoView、SurfaceView+MediaPlayer、TextureView+MediaPlayer,以及主流视频播放器开源项目 https://my.oschina.net/u/4331678/blog/3629191   2019

  - 开源的视频播放项目 
    - https://github.com/bilibili/ijkplayer
    - ExoPlayer项目地址：https://github.com/google/ExoPlayer
    - 饺子饺子播放器开源地址：https://github.com/lipangit/JiaoZiVideoPlayer

- 使用RecyclerView和SurfaceView实现视频播放

  - https://blog.csdn.net/wang927893/article/details/78860735?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-2&spm=1001.2101.3001.4242
  - 这个我参考原理，recycleview的用法, 实现了本地视频的播放, 播放的相关视频信息显示,预览界面

- Android利用SurfaceView显示Camera图像爬坑记（一）

  - https://mp.weixin.qq.com/s?__biz=MzA4Nzk0NTU0Nw%3D%3D&chksm=9030f488a7477d9ede4cae7f4f6c1589c10110ff7ec88d33d8e61771ddaa4bbad53c1ba55276&idx=1&mid=2247486636&scene=21&sn=b10e9437d145f1b338902bfa9e0cba67#wechat_redirect

- Android Studio之通过AndroidManifes.xml添加权限 以及当前主要的权限设置项目

  - https://blog.csdn.net/don_sandman/article/details/76651083
  - 安卓之权限的问题  https://blog.csdn.net/jzdcuccess/article/details/106169961  2020
  -  Android6.0,及api23以上，Android系统有些权限需要运行时动态申请。
    android把权限分为两类：一类是正常权限，另一类是危险权限。
  - 在API23（含23）以上，正常权限只需要在清单文件（Androidmanifest）中声明就好了，就像Android5.1或更低版本那样在清单文件中声明。
      在Android 6.0（API 级别 23）或以上版本由于Google对android系统安全机制的优化，使用危险系统权限不仅需要在清单文件中声明，还要在运行时申请权限。

- Android Studio在Fragment中添加Recycleview  参考这个的设计，怎么添加的RecycleView

  - https://blog.csdn.net/someone66_/article/details/109491865
  - good ,参考了这个实现，实现方法，已经在程序测试效果，OK
  
- android 使用MediaCodec硬解码H264裸流并使用SurfaceView进行展示

  - https://blog.csdn.net/qaz4300321/article/details/106646028/?utm_medium=distribute.pc_relevant_download.none-task-blog-baidujs-2.nonecase&depth_1-utm_source=distribute.pc_relevant_download.none-task-blog-baidujs-2.nonecase
  - 2020

- Socket接收的视频流怎样保存和播放

  - 一开始查到的是SocketCamera的一个开源项目，看了下源代码，发现其实现原理是利用Android 的camera图像的预采集，通过实现PreviewCallback类的回调函数onPreviewFrame，获得camera采集的原始图像数据之后，压成jpeg格式传到pc端。pc端对接收到的jpeg图像序列进行实时解压和显示，就达到了预想的效果。

  -  然这种方式稍微显得比较笨拙，这个方式还可以接受。但是不可接受的是jpeg只是帧内压缩，320x280的图片序列，`FPS大概是10上下，网络流量就到达了100kb/s以上`。这个几乎是无法实际应用的。

    于是必须直接传视频流，MPEG4或者H.264格式。貌似我的开发机上(HTC G8)只支持到MPEG4，所以还是选取MPEG4。但是如何实时采集视频流是一个大问题，毕竟在video方面，Android并没有提供一个类似于OnPreviewFrame的回调函数

- GridView+Fragment+ViewPager最佳实践

  - https://blog.csdn.net/jxq1994/article/details/52984062
  - `参考 一个典型的使用场景，在**Fragment**里面**内置GridView**，其中GridView的子视图是ImageView。`

- (android开发)Json文件的读写

  - https://www.jianshu.com/p/96f7853d9ad5?utm_source=oschina-app
  
- Json格式是常见的读写形式。读写Json文件也是常用的操作。
    这次来实践一下Json文件的读写。
    首先在SD卡上的读写权限是一定要申请的。那么还是老办法，在 AndroidManifest.xml 文件中添加 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    这在android 6.0 以下的系统就足够了。6.0及以上的更新的系统，在代码中需要申请SD卡的读写权限。
  
- Android读写properties配置文件

  - https://blog.csdn.net/weixin_30838873/article/details/98256075?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-3&spm=1001.2101.3001.4242 设计合理
  - https://www.cnblogs.com/yjpjy/p/5407251.html 两个实现

- Android常见设计模式三：单例模式 还有其他各种模式

  - https://www.jianshu.com/p/baaf6281e0e2

  - Android单例模式 https://www.cnblogs.com/lixiansheng/p/11382462.html  这个讲得很详细和安全

  - 一般来说，单例模式有五种写法：懒汉、饿汉、双重检验锁、`静态内部类`、枚举。上述所说都是线程安全的实现，上文中第一种方式线程不安全，排除。

    一般情况下直接使用饿汉式就好了，如果明确要求要懒加载（lazy initialization）倾向于使用静态内部类。如果涉及到反序列化创建对象时会试着使用枚举的方式来实现单例。

- Android视频裁剪适配，类似于ImageView的scaleType="centerCrop"

  - 我们经常会遇到播放视频的需求，最近几年全面屏、刘海屏的出现使得屏幕的比例各种各样，下面是视频适配各种屏幕比例，类似于ImageView的scaleType=“centerCrop”。
  - https://blog.csdn.net/mengks1987/article/details/102383410

- 辨析Java方法参数中的值传递和引用传递

  - https://www.cnblogs.com/lingyejun/p/11028808.html
  - 基本类型，包装类型，复合类型（引用传值，有效），多元组返回，利用泛型

- 利用recyleview显示多个画面，其实就是这个，用GridLayoutManger包装

  - RecyclerView显示多个图像(RecyclerView display multiple images)
  - https://www.it1352.com/1917503.html
  - good ok

- Android视频播放器实现小窗口和全屏状态切换

  - https://blog.csdn.net/u010072711/article/details/51517170?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-3&spm=1001.2101.3001.4242
  - RecyclerView的方法也讲解了，开源了，讨论下面有地址，start还挺多的。

- 禁止RecyclerView上下滚动/滑动解决办法，补充系统8.0禁止RecyclerView上下滚动/滑动失效问题

  - https://blog.csdn.net/sinat_15411661/article/details/78970891

- Android RecyclerView之添加Item分割线

  - https://danfeng.blog.csdn.net/article/details/49475015?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control
  - https://blog.csdn.net/weixin_42112064/article/details/89763136
  - RecyclerView设置分割线（自定义宽度与颜色）
    - DividerItemDecoration它适用于LinearLayoutManager，对于GridLayoutManager就无能为力了。
    - https://blog.csdn.net/Heijinbaitu/article/details/81170314
    - 显示的颜色刚好与item的颜色一样，误以为没有显示。这是因为分割线默认使用的是系统listDivider
  - ItemDecoration相关 RecycleView Item间距的设置（保持GridLayoutManager时列间距的相等) 继承重新实现
    - https://blog.csdn.net/futianyi1994/article/details/79057173?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
  - https://blog.csdn.net/hasayaqimomo/article/details/89226710?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control  这个设置分割线逻辑清晰 ，设置样式，边框，背景分割线条。
  
  ---
  
  2021年02月06日09:05:22
  
  - 最终我的程序的分割线设置，最简单的方法，直接调用原来系统支持的DividerItemDecoration,设置RecycleView.Vetical 和 RecycleView.Horizonal，就可以直接出来水平和垂直分割线，不需要其他继承重定义和自定义样式加载
  
    - https://www.jianshu.com/p/4c2c5308ee05
  
    - RecyclerView设置分割线---GridLayoutManager DividerItemDecoration
  
    - 测试通过，可以，OK
  
    - 代码如下： RecyclerView.HORIZONTAL
  
      ```
       DividerItemDecoration dividerVertical = new DividerItemDecoration(context, RecyclerView.VERTICAL);
              dividerVertical.setDrawable(context.getResources().getDrawable(R.drawable.shape_item_decoration));
              recyclerView.addItemDecoration(dividerVertical);
      
              DividerItemDecoration dividerHorizontal = new DividerItemDecoration(context, RecyclerView.HORIZONTAL);
              dividerHorizontal.setDrawable(context.getResources().getDrawable(R.drawable.shape_item_decoration));
              recyclerView.addItemDecoration(dividerHorizontal);
      ```
  
      

- Android 动态权限适配方案总结

  - https://blog.csdn.net/yuguqinglei/article/details/80375702
  - 国内定制ROM严重，有外加一套自己的授权逻辑

- Android studio自动删除没有用到的包

  - 1.方式一：自动清除单个java文件

       先打开要整理的java文件，点击Code→Optimize Imports，即可自动自动删除该java文件中没有用的包（使用快捷键Ctrl+Alt+O可实现同样的效果）

- 快捷键：Shift+F6 android studio中如何重命名文件

- Android – onCreate()和onStart()之间的差异？ http://www.voidcn.com/article/p-hjyqumhv-bsk.html

  ```
  三种调用的场景：
  一个Activity启动另一个Activity: onPause()->onStop(),再返回：onRestart()->onStart()->onResume()
  程序按back 退出： onPause()->onStop()->onDestory(),再进入：onCreate()->onStart()->onResume();
  程序按home 退出： onPause()->onStop(),再进入：onRestart()->onStart()->onResume();
  ```

- Thread.currentThread().getStackTrace()[2].getMethodName()

- 自定义Log工具类打印类名、方法名、行号实现精准定位 

  - https://blog.csdn.net/mei_jia12/article/details/84346319?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control



- 解决SurfaceView渲染的各种疑难杂症
  - https://blog.csdn.net/gfg156196/article/details/72899287?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
  - 问题讲解，还有各种开源小项目，直播项目推荐学习，github.
  
- I've read that [post](https://stackoverflow.com/questions/7037630/how-to-create-a-video-preview-in-android) but it no longer works as `createVideoThumbnail` is deprecated. The doc says to use `ContentResolver.loadThumbnail(Uri, Size, CancellationSignal)` but I can't use it because the object `Size` is 21+ and my min Sdk is 19.

- Android开发：getContentResolver的使用
  - https://blog.csdn.net/daniel80110_1020/article/details/55260510
  - 在四大组件中，直接调用
  - 在其他组件中，必须getcontext()获取上下文对象，再调用
  
- Android之MediaStore使用 (查找 音乐/视频/文档/自定义类型文件.apk .zip 等) 
  - 我程序按照别的例子编写，没有搜寻到视频文件，所以继续找原因
  - https://blog.csdn.net/Jonly_W/article/details/106440072
  
- 解决安卓10获取外部存储权限问题，导致播放本地视频文件错误。

  - https://blog.csdn.net/qin_peng123/article/details/109218665

  - https://blog.csdn.net/coolarmy/article/details/103600000?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control

  - 项目 targetSdkVersion >28  的时候，以前的获取 /storage/emulated/0/DCIM/Camera/xxx.mp4 的路径会访问不到，因为安卓10

    文件存储机制修改成了沙盒模式。

    应用只能访问自己沙盒下的文件和公共媒体文件。坑的一匹，天天改。还是要多看更新文档啊。 

    解决办法：1.把自己项目的版本降低到28  

    2.在项目AndroidManifest.xml 中的 application 标签中加入  

    android:requestLegacyExternalStorage="true"
    即可访问。

    3.如果以上两种方法都不想，就头铁，要适配。

- Android学习之请求外部存储sd卡读写权限（适配Android8.0以上包含Android10.0）少花时间少踩坑！

  - https://blog.csdn.net/c529283955/article/details/104266083?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-2&spm=1001.2101.3001.4242
  - https://www.cnblogs.com/demodashi/p/8512746.html 6.0 后权限申请成功的封装库
  - https://www.jianshu.com/p/9fbbef5f51af Android6.0动态申请权限(流程图及demo)
  - GitHub下载地址:[https://github.com/SpikeKing/wcl-permission-demo](https://link.jianshu.com/?t=https%3A%2F%2Fgithub.com%2FSpikeKing%2Fwcl-permission-demo)

- Android 动态权限申请及回调

  - Android Studio4.0 + android 10 + jdk1.8
  - https://blog.csdn.net/qq9746/article/details/109989590

- android activity与fragment 的区别

  - https://blog.csdn.net/sinat_28864443/article/details/97148265
  - Fragment有`11个生命周期`， Activity有7个生命周期
  - Fragment有11个生命周期：onAttach() --->onCreate() --->onCreateView() --->onActivityCreate() --->onStart() --->onResume() --->onPause() --->onStop() --->onDestroyView() --->onDestroy() --->onDetach();

- 我的手机开发后，动态检测授予权限后，终于可以在Android 10的分区存储，利用MediaStore访问到对应目录的视频文件进行播放了， 但是有一个视频播放报错，很短7秒钟

- MediaPlayer.isPlaying() IllegalStateException的一种情况

  - https://blog.csdn.net/qq_29389373/article/details/103902997?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control

  ```
  没有设置资源mediaPlayer.setDataSource(url);
  
  没有mediaPlayer.prepare();
  
  只是new了一个对象的话，调用isPlaying(),就会IllegalStateException ，所以还是要try catch一下即可
  ```

- getEmbeddedPicture: Call to getEmbeddedPicture failed when i put more than one mp3-file

  - Try something like loading each inside an AsyncTask:  异步加载图片和视频

    ```
    private class LoadImageTask extends AsyncTask<String, Void, Bitmap>{
    
        private ImageView artImage;
    
        public LoadImageTask(ImageView image){
            artImage = image;
        }
    
        @Override
        protected void onPreExecute() {
            retriever = new MediaMetadataRetriever();
        }
    
        @Override
        protected Bitmap doInBackground(String... params) {
            retriever.setDataSource(params[0]);
            byte[] art = retriever.getEmbeddedPicture();
            Bitmap bitmap = null;
            if( art != null ){
                bitmap = BitmapFactory.decodeByteArray(art, 0, art.length);
            }
            return bitmap;
        }
    
        @Override
        protected void onPostExecute(Bitmap bm) {
            if( bm != null ){
                artImage.setImageBitmap(bm);
            }
            else{
                artImage.setImageResource(R.drawable.no_image);
            }
        }
    
    }private class LoadImageTask extends AsyncTask<String, Void, Bitmap>{
    
        private ImageView artImage;
    
        public LoadImageTask(ImageView image){
            artImage = image;
        }
    
        @Override
        protected void onPreExecute() {
            retriever = new MediaMetadataRetriever();
        }
    
        @Override
        protected Bitmap doInBackground(String... params) {
            retriever.setDataSource(params[0]);
            byte[] art = retriever.getEmbeddedPicture();
            Bitmap bitmap = null;
            if( art != null ){
                bitmap = BitmapFactory.decodeByteArray(art, 0, art.length);
            }
            return bitmap;
        }
    
        @Override
        protected void onPostExecute(Bitmap bm) {
            if( bm != null ){
                artImage.setImageBitmap(bm);
            }
            else{
                artImage.setImageResource(R.drawable.no_image);
            }
        }
    
    }
    ```

- 问题程序：

  - app 切换frangment时候，会重新调用onCreateView, 这里的数据就会重新加载，影响了第二次数据的顺序，显示的视频就乱了，播放的索引position乱了。 利用
  - setOffscreenPageLimit，设置多少个页面常驻内存。
  
- android之针对fragment多次调用onCreateView的问题

  - https://q.cnblogs.com/q/78341/   这个最靠谱，讲了各种方法，viewPager容器里面设置选项，禁止销毁fragment，自动缓存fragment界面。

  - 可以切换的时候，自己实现hide或者show; 可以设置缓存，可以自己实现缓存

  - 通过FragmentManager开启事务，然后调用hide方法隐藏Fragment，再次切换到之前的Fragment时再调用show方法显示出来，这样可以避免Fragment的往复创建和销毁

  - ```
    mViewPager.setOffscreenPageLimit(5);  这个是有效的，4个页面全部缓存成功。
    ```

  - https://blog.csdn.net/weixin_33787529/article/details/94472152

  - ViewPager之setOffscreenPageLimit()解析

    - https://blog.csdn.net/maxiaowen_2017/article/details/81280297

    - ```
       @Override
          public void onActivityCreated(@Nullable Bundle savedInstanceState) {
              super.onActivityCreated(savedInstanceState);
       
              isViewInitFinished = true;
          }
        
      ```

      

- 获取android的实时网速

  - https://blog.csdn.net/LuckChouDog/article/details/48319091?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
  - https://blog.csdn.net/android_zhengyongbo/article/details/71158554

- 本机无线网络带宽测试

  - iftop -i eth0  
  - 结果， 一路视频实时播放，最大测速可以达到 20Mbs,  接收速率 20Mb/s， 发送800Kb/s

- 图片格式中CIF和D1是什么意思？如何定义？它们何区别？

  - 不是图片，应该是视频。这两种分别是两种画质的视频分辨率，即VCD(CIF=352x*288)，DVD(D1=720*x576 )。现在监控的普遍分辨率是标清及高清，现在以高清为主。

- Android WebView net::ERR_CLEARTEXT_NOT_PERMITTED 解决办法

- 使用mjpeg-stream作为开发电脑的图片流媒体服务器，Android手机端，基于webview去显示url的stream流，实现成功。 本机无线局域网测试实时性较高，偶尔画面跳转刷新。

- ubuntu 安装使用 mjpg-streamer

  - https://blog.csdn.net/yytyu2017/article/details/108937708

  ```
  ./mjpg_streamer -i "./input_uvc.so -d /dev/video0 -u -f 30" -o "./output_http.so -w ./www"
  ```

  - https://www.cnblogs.com/sirius-swu/p/6815840.html
  - 树莓派 之 USB摄像头 局域网内视频流实时传输（ MJPG-Streamer）
    - https://blog.csdn.net/weixin_40639095/article/details/112603303

- 树莓派下mjpg-streamer 挂载多个USB摄像头

  - https://blog.csdn.net/jacka654321/article/details/80724132?utm_medium=distribute.pc_relevant_bbs_down.none-task--2~all~first_rank_v2~rank_v29-2.nonecase&depth_1-utm_source=distribute.pc_relevant_bbs_down.none-task--2~all~first_rank_v2~rank_v29-2.nonecase

    ```
    nohup ./mjpg_streamer -i "input_uvc.so -d /dev/video2 " -o "output_http.so -w ./www -p 8003" &
    nohup ./mjpg_streamer -i "input_uvc.so -d /dev/video1 " -o "output_http.so -w ./www -p 8002"&
    ```

    后台执行,启用不同端口,进行服务就可以了.

  - 作者我想问以下为什么在每次把usb摄像头拔了又重新插上，再使用ls -al /dev/ | grep video 显示的video的名字会有些变动啊
    一方世界回复VITTO7777: 因为usb port 是`按插入的顺序来编号的`，所以我们可以根据设备的插入顺序来控制我们代码中使用哪个usb

- 树莓派采用MJPG-Streamer双摄推流至上位机,实测延时低至200ms[CSI摄像头+USB摄像头]

  - https://blog.csdn.net/qq_39492932/article/details/84671345

- mjpg-streamer安卓APP 参考这个来实现我的程序

  - https://blog.csdn.net/mm13420109325/article/details/88325148

  - 无线网卡测速，本机 sudo iftop -i wlp7s0

  - 单个摄像头平均流量是260Kb/s, 流量位数是4.5Mb/

  - 中间的<= =>这两个左右箭头，表示的是流量的方向。

    TX：发送流量
    RX：接收流量
    TOTAL：总流量
    Cumm：运行iftop到目前时间的总流量
    peak：流量峰值
    rates：分别表示过去 2s 10s 40s 的平均流量
    
    https://my.oschina.net/u/3367404/blog/1803360
    
    ```
     sudo iftop -i wlp7s0 -B -P
    ```
    
  
- 720p, 1080p的常规分辨率大小

  - 640*480
  - 1280x720
  - 1920×1080

- linux shell启动多个进程的注意事项

  - ```
    启动多进程时，一定注意在长时间运行进程后添加 &或者nohup，将进程托管给后台，但是这两个命令是有区别的。
    
    nohup在当前shell进程被终止后，可以继续在后台运行，而&在shell退出后也会退出。这是网上的说法，我测试使用nohup会阻塞后边程序，需要加&才能顺序启动进程，nohup只有将输出存储到nohup.out的功能而已当我结束shell之后，进程会退出，并不会保留在后台。
    
    例如编写一个test.sh程序：
    unset DISPLAY
    export DISPLAY=:0
    mkfifo $(pwd)/cmd_fifo
    mplayer ( p w d ) / s a n d s t a r . m p 4 − l o o p 0 − f s − q u i e t − s l a v e − i n p u t f i l e = (pwd)/sandstar.mp4 -loop 0 -fs -quiet -slave -input file= (pwd)/sandstar.mp4−loop0−fs−quiet−slave−inputfile=(pwd)/cmd_fifo &
    #mplayer ./sandstar.mp4 -loop 0 -fs -slave -quiet # -input file=/home/nx3/Downloads/mplayer_setup/cmd_fifo
    $(pwd)/playerctrl
    
    这是一个启动mplayer播放的后台程序后，再启动一个控制进程，当退出playerctrl后，由于此shell进程退出，mplayer也会终止，添加nohup并不会在后台保留mplayer进程。
    ————————————————
    版权声明：本文为CSDN博主「u012441962」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/u012441962/article/details/113121435
    ```

    shell多个后台进程,启动和退出,是否同时结束,还是会在后台继续执行. 

    https://blog.csdn.net/u012441962/article/details/113121435

  - jobs  

  - Linux shell执行一次执行多个命令

    - https://blog.csdn.net/qq_27870421/article/details/94598266?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control   **第一种是以分号（；）进行划分：** **命令之间&&隔开**   **每个命令之间用||隔开**

  - Linux系统把程序放后台运行，后台执行不退出，退出终端仍运行进程，继续运行（centos & nohup jobs）

    - https://blog.csdn.net/envon123/article/details/82144401

    - 程序在后台运行了，但退出当前会话，发现程序还是停止了，此时要用nohup命令，如：nohup php test.php >/dev/null 2>&1 

      6、使用nohup后，应确保用exit命令退出当前账户，非常正常退出或结束当前会话，在后台运行的作业也会终止

    - 是终命令可能是：nohup php test.php >/dev/null 2>&1 &

  - https://www.jianshu.com/p/747e0d5021a2?from=timeline

  - 原因是testshell0.sh是以后台任务的方式由testshell1.sh提交，当testshell1.sh已经退出后，testshell0.sh变成了孤儿进程，操作系统自动收集这些孤儿进程，此时我们看到testshell0.sh的父进程已经变成进程号1了，这样testshell0.sh和当前终端已经没有了关系，他们失去了联系，从而当当前终端结束的时候，testshell0.sh不会也不需要得到什么消息，那么也就不会收到SIGHUP信号了。

    作者：CodingCode
    链接：https://www.jianshu.com/p/747e0d5021a2
    来源：简书
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

- Shell echo命令：输出字符串

  - http://c.biancheng.net/view/1142.html
  - echo "读者，你好！"  #直接输出字符串
    echo $url  #输出变量
    echo "${name}的网址是：${url}"  #双引号包围的字符串中可以解析变量
    echo '${name}的网址是：${url}'  #单引号包围的字符串中不能解析变量

- 测试结论, nohup可以在停止当前主shell进程后, 自动停止所有对应启动的后台子进程. 但是输出在屏幕看不到了

- linux nohup和&后台运行，进程查看及终止

  - ​	https://blog.csdn.net/ninisui/article/details/77989938

  - 这个挺好的,用起来监控进程的运行情况

  - 包括网络端口,名称,pid

  - jobs命令只看当前终端生效的，关闭终端后，在另一个终端jobs已经无法看到后台跑得程序了，此时利用ps（进程查看命令

  - 用ps -def | grep查找进程很方便，最后一行总是会grep自己

    　　用grep -v参数可以将grep命令排除掉

    

    ```
    ps -aux|grep chat.js| grep -v grep
    ps -aux|grep chat.js| grep -v grep | awk  '{print $2}'
    ```

    强制终止进程
    使用kill命令强制重启进程

    [root@localhost ~]# ps -ef|grep mongo|grep -v grep|awk '{print $2}'|xargs kill -9 

---

2021年02月19日08:54:17

- android fragment配合viewpager或者底部导航栏使用 onResume不生效的解决办法

  - Fragment+ViewPager 滑动时 onResume和onPause

    -  https://blog.csdn.net/zheng0203/article/details/48318223

  - 产生的原因
    Fragment依托于Activity，其内部的OnResume和OnPause方法真正归属于其依托的Activity，在Activity可见性变化的时候，才会调用这两个方法；如果在Activity中包含一个ViewPager + 多个Fragment的结构，在Fragment的切换过程中，因为Activity一直显示，所以Fragment切换是不会调用OnResume和OnPause方法的，当然第一次创建Fragment的时候是会调用的。

    那么问题来了，我们想要在子Fragment对用户可见性变化时处理一些逻辑，该怎么办呢？

    解决办法
    在fragment中使用onHiddenChanged，代码如下

    https://blog.csdn.net/wy313622821/article/details/108347150
    
  - Android Fragment＋ViewPager 组合使用
  
    - https://blog.csdn.net/paladinzh/article/details/88078989?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
    - 详解分析原理和解决办法的优缺点，提出综合解决的方法，加强版本
    - 优秀的总结
  
- webview网络视频流数据切换界面的时候，一直在加载

  - WebView退出时停止视频播放
    网上比较流行的方法:

    在activity的onPause函数中调用webview的onPause函数。

    弊端:视频虽然停止播放但是还是在从网上加载数据(观察流量统计);

    比较好的方法:

    在activity的onPause函数中调用webview的onPause函数。

    在activity的onDestroy函数中webview.loadUrl("file:///android_asset/nonexistent.html"); 

    原文:http://stackoverflow.com/questions/5946698/how-to-stop-youtube-video-playing-in-android-webview

  - 怎么暂停WebView中视频,停止加载网络数据或者网络页面

- 4个视频画面的测试结果

  - 相机数据信息 30fps        640x480        MJPG        http 8080
  - 主显示相机画面，600kb/s, 其他200Kb/s, 一共能得到2MB/S. 甚至4 Mb/s的峰值流量
  - 4幅画面同时接收视频流的话，延时还是比较严重的。2-5秒延时
  - 订阅同一个相机，4个 画面依次延时显示相机画面。

- 问题：

  - 如果是单画面显示，需要解决画面在recycleview里面切换的话的，数据加载和停止加载。避免卡顿，网络流量拥堵。
  - 使用其他的activity的生命周期来控制。
  - 网上解决的实现： 监听listview以及Recyclerview滚动时候 item显示与不显示
  - https://github.com/xuhuawei131/RecyclerViewItemVisible

- 看到流式编程，java的流式编程，Rxjava 

  - 总的来说，流式编程是一种声明式编程（Declarative programming），即声明要做什么，而非怎么做的编程风格。

    ```css
    new Random(47).ints(5, 20)
                    .distinct().limit(7).sorted().forEach(System.out::println);
    ```

---

- realsense相机视频的采集
  - vlc测试realsense视频的播放通道，发现接入电脑后，设备挂载在/dev/video5,/dev/video6后面，
  - 其中彩色图像是在/dev/video6, 可以提供给uvc驱动采集,提供给mjpg-stream流媒体服务器采集
  - /dev/video4和/dev/video6有图像，4是带点的灰度图。6是原始RGB图。

---

2021年02月20日09:56:35

###### 1. Android 的视频播放方式和性能研究

- android 播放rtsp流的三种方式, 直接放入rtsp的url流地址
-  https://huangxiaoguo.blog.csdn.net/article/details/109628952#commentBox
  - videoview
  - surfaceview+mediaplayer
  - 使用开源库NodeMediaClient-Android
- Intel Realsense D435 python multiprocessing 摄像头多进程流传输
  - https://blog.csdn.net/Dontla/article/details/104944982?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-6&spm=1001.2101.3001.4242

###### 2. Linux查看网卡带宽的两个命令

- 1、ethtool
  ethtool 网络接口名
- 2、lspci  
  当前是博通BCM5709千兆网卡Gigabit（万兆网卡显示为10-Gigabit）
  #lspci -vvv | grep Ethernet
  01:00.0 Ethernet controller: Broadcom Corporation NetXtreme II BCM5709 GigabitEthernet (rev 20)
- https://www.cnblogs.com/jeray/p/8761188.html

###### 3. Python使用UDP实现720p视频传输 

- 这个分片传输,分片对应的区域刷新图片显示,感觉有点野路子
- jpg压缩原始图像到10-20倍
- https://blog.csdn.net/u013033845/article/details/86765598

###### 4. 搭建USB摄像头转RTSP服务器的多种方法

- https://www.cnblogs.com/chay/p/10553787.html
- 多个相机的视频播放问题

###### 5. 各个相机厂家提供的原生RTSP码流,可能不一样, 用videoView控件播放视频流的问题

- videoview是android原生控件，是基于android硬件的硬解码方案，不同硬件配置的手机的硬解码方案也是有区别的； 而vlc是软解码方案，不和硬件耦合，所以vlc只要能编译出能用的so，是不挑手机的.
- 所以可以采用第三方rtsp服务器库,生成标准一致的rtsp流,再提供给自己的库解码显示,或者视频显示控件显示
- 需要测试三种播放rtsp三种方式的支持情况.
- Android使用VideoView播放网络、rtsp码流视频  https://blog.csdn.net/huanzhongying/article/details/53032909 问题讨论,硬件和软件适配的问题
- 

###### 6. 网上讲解的rtsp流创建和播放的技术讲解方案

- 基于NDK开发Android平台RTSP播放器

  -  https://www.cnblogs.com/haibindev/p/12081565.html
  - 可以商务合作
  - 有原理图,分析,讲解

- Android Vitamio的使用解析

  - https://blog.csdn.net/huaxun66/article/details/53367079
  - github开源,支持广泛.
  - https://github.com/yixia/VitamioBundle

- Android ijkplayer的使用解析

  - https://blog.csdn.net/huaxun66/article/details/53401231
  - https://github.com/Bilibili/ijkplayer 

- 原生的VideoView

  - 说是支持格式有限,性能不如别的.我没有测试,不好下结论
  - 安卓原生 VideoView实现rtsp流媒体的播放
  - https://blog.csdn.net/xundh/article/details/85218844

- vlc+ffmpeg+ffplayer

- surfaceview+mediaplayer

- 开源库NodeMediaClient-Android

- 其他开源客户端

  - rtmp-rtsp-stream-client-java

  - FFmpegAndroid

  - SmarterStreaming https://github.com/daniulive/SmarterStreaming 这个有讲解直播系统的框架图,系统流程图,部署原理图. 理解直播系统很好

  - RTSP/RTMP推拉流SDK概览图

    ![RTSP/RTMPæ¨ææµSDKæ¦è§å¾](https://camo.githubusercontent.com/56b6acb1975b1ab70d43ad3f5a59fbdbddc6bf20a121f7c48ffcb03d3fec3a86/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f323032303032303631323137343331372e706e673f782d6f73732d70726f636573733d696d6167652f77617465726d61726b2c747970655f5a6d46755a33706f5a57356e6147567064476b2c736861646f775f31302c746578745f6148523063484d364c7939696247396e4c6d4e7a5a473475626d56304c334a6c626d6831615445784d54493d2c73697a655f31362c636f6c6f725f4646464646462c745f3730)

  - **多路RTSP/RTMP转RTMP推送SDK概览图**

    - ![å¤è·¯RTSP/RTMPè½¬RTMPæ¨éSDKæ¦è§å¾](https://camo.githubusercontent.com/41b5955f60084708a7a221382b5818d35b4255f075ff3949dc6ac5bc8cad9a11/687474703a2f2f64616e697573646b2e636f6d2f77702d636f6e74656e742f75706c6f6164732f323032302f30312f64616e69756c6976655f72656c617973646b5f32303230303133302e706e67)
    - 图片来源

###### 7. RTMP流媒体服务器的技术实现或者流媒体推流分发的实现

- srs
- nginx+rtsp/rtmp-module/http-module
- CDN
- ffserver   以前是和ffmpeg一起安装的服务, 后面被2018版本移除了,选型时候考虑 
  - https://blog.csdn.net/cug_heshun2013/article/details/79518632?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_baidulandingword-0&spm=1001.2101.3001.4242
- EasyDarWin  开源国产RTSP/RTMP流媒体服务和其他播放编解码控件
  - http://www.easydarwin.org/
- Wowza
  - wowza也是商用级收费产品，参考价在3-4万。
- android 原生的MediaCodeC编码解码
- VideoLAN的VLC
- Live555流媒体



开源流媒体服务器：为何一定得再撸个新的

​	https://cloud.tencent.com/developer/article/1638383



###### 8. 播放案例

- 是否支持 多路直播流同时播放

- android 两个播放器同时播放视频
- https://blog.csdn.net/u010648159/article/details/89386097



---

- 布局优化
- RecyclerView双列显示属性配置
  StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
  recyclerView.setLayoutManager(layoutManager);
- RecyclerView GridLayoutManager 行数 列数
  - 设置行数 7行
    GridLayoutManager layoutManager = new GridLayoutManager(this,7); layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
    recyclerViewSelect.setLayoutManager(layoutManager);
  - 测试有效,直接使用GridLayoutManager, 然后调用方向,setOrientation()来区分行还是列
  - 链接：https://www.jianshu.com/p/267d3f1e047d
- recyleview 采用gridlayout布局后,设置了2行2列, 但是它是根据Item的内容,自适应内容的宽度和高度
  - 每一个item自适应视频的宽度和高度, 造成内部有滚动条
  
  - 一个屏幕只能显示2行,1列,我想显示2行2列,在一个屏幕
  
  - 关于RecyclerView的宽高调整
    - https://blog.csdn.net/crazyman2010/article/details/54315109?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-7.control&dist_request_id=4a3e3065-3f90-4c67-9ee0-d8fdfc44b04e&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-7.control
    - 设置ItemView的间隔高宽
    - ItemView适应RecyclerView, 固定RecycleView,设置内部itemview的大小宽高
    - RecyclerView适应ItemView, 固定itemview内容, recycleview根据内容变化宽和高.
    
  - Android RecyclerView中动态设置Item的宽高
    - https://blog.csdn.net/yu540135101/article/details/113701746?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-3&spm=1001.2101.3001.4242
    - 2021 两种方式
    
  - 横向RecyclerView item修改宽度，均分Android手机屏幕的方法
    
    - https://blog.csdn.net/qq_43983650/article/details/105076507
    
  - 待续
  
  - RecyclerView的item宽度不能全屏显示
  
  - ```
    @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_complain_list, parent, false);
            view.setOnClickListener(this);
            return new ViewHolder(view);
        }
        此处传入的parent即为item的根布局 
    ```
  
    
  
  - 

---

开发

- 计划使用开源的NodeMediaClient-Android,来同步播放4个rtsp流
  - 后续再解决item的高度和宽度的限制问题
  - 后续解决,界面切换,自动断流,停止播放的问题
- 2020最新RTMP+HTTP+RTSP直播地址汇总（亲测可用）
  - https://willarun365.blog.csdn.net/article/details/109180771
  - 用VLC打开,网络流,可以看到视频,自己测试过CCTV1的RTSP流
- 设计NodePlayerAdapter,使用播放开源NodePlayer插件,可以同时播放4路RTMP, 画面不卡顿
- 4副图片直接有1-2秒内的不同步

---

2021年02月22日09:26:39

#### 一. 问题1

- 今天解决4画面情况,均分在平板的屏幕上面显示的问题,也就是recycleView里面的Item自适应固定宽度和高度

  - Android RecyclerView的item大小保持四个半  https://www.cnblogs.com/xgjblog/p/10485152.html
  - 横向滚动的RecycleView一屏显示五个半，低于五个平均分布
  - 先计算出RecyclerView的宽高，然后在Adapter的onCreateViewHolder中设置view的高度

- 还是继续参考以前的网上的实现方案,现在看代码是明白它的原理了

  - https://blog.csdn.net/qq_35893839/article/details/79125952
  - 4路视频显示,自适应屏幕的宽度和高度进行播放,限制了recycleview中的宽度和高度
  - 

- GridLayoutManager.SpanSizeLookup 白话文描述使用

  - https://blog.csdn.net/mylike_45/article/details/106160078
  - 今天就讲它的两个方法getSpanIndex和getSpanSize 所占份数和份数所在的索引

- Android11踩坑日记 getWindowManager().getDefaultDisplay().getWidth() 已被废弃

  - https://blog.csdn.net/yhroppo/article/details/109112272

  - https://www.it1352.com/2043546.html

  - ```
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) ((getResources().getDisplayMetrics().widthPixels - CommonUtil.dip2px(mContext, 5)) / 4.5f),
     
    ViewGroup.LayoutParams.MATCH_PARENT);
    ```

    

-  墨玉  / 老罗的Android之旅（总结）

  - https://www.kancloud.cn/alex_wsc/androids#/catalog

- #### 总结, 在视图适配器里面,计算得到屏幕的宽高(不包含边界区域), 然后根据设定的画面个数,几行几列,得到view里面每一个item的播放控件的宽高,在界面适配器中,createviewholder()里面设定item的布局参数的宽高就可以了.

  ```
   public NodePlayAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view = LayoutInflater.from(mContext).inflate(R.layout.item_nodeview, parent, false);
          view.getLayoutParams().width = mItemWidth;
          view.getLayoutParams().height = mItemHeight;
  
          RecycleViewHolder myViewHolder = new RecycleViewHolder(view);
          return myViewHolder;
      }
  ```

#### 二. 问题2

- 解决点击画面, 或者长按全屏播放画面的功能

- NodePlayerView开源组件,是可以基于SurfaceView和TextureView实现的播放界面, 我程序里面是设置的渲染类型setRenderType()为Surface的方式.

- surfaceview是靠surfaceholder(), getHolder()来设置视图窗口的大小来显示的.

  - Android SurfaceView实现全屏播放例子 https://blog.csdn.net/weixin_34192732/article/details/85695361

  - https://blog.csdn.net/m0_37824232/article/details/109587022 SurfaceView全屏铺满的方法 2020

  - SurfaceView全屏播放问题解决方案 mSurfaceView.setOnTouchListener(new View.OnTouchListener() {

  - https://blog.csdn.net/qq_35293703/article/details/103369428

  - https://www.cnblogs.com/CharlesGrant/p/4605198.html

  - **JieCaoVideoPlayer**

    　　实现Android的全屏视频播放，支持完全自定义UI、手势修改进度和音量、hls、rtsp，设置http头信息，也能在ListView、ViewPager和ListView、ViewPager和Fragment等多重嵌套模式下全屏工作，占用空间非常小，不到60k。

    本次是通过 SurfaceView + MediaPlayer 实现 横屏 全屏 播放. 

- 在自定义的NodeAdapter的creatoviewholder()里面设置触摸事件,里面设置item的布局参数大小,但是其他的item无法控制状态,所以进入全屏播放,再退出全屏,感觉布局就乱了.

- 网上搜寻了一下一般的解决方法:

  - 当出现需求时，我一般不会去直接写，我会上网搜了一下其他博客，发现大多数写的很麻烦，有人用弹出Dialog实现，有人在Imageview上面盖了一层视图方法实现，而且代码也很多，上百行，当他们都有一些问题，例如

    - 没有放大缩小的动画

    - Dialog扩展性不是太高

    - 上面盖一层视图，实现RecyclerView太麻烦

    - 代码量大，等等

- 自己想着还是得在父窗口中,来实现触摸接口,然后控制全屏状态下的布局参数, 变成显示1个,退出全屏显示4个. 自动切换默认布局和全屏布局. 

  - 可以参考这个: https://www.cnblogs.com/oreox/p/10818515.html
  - 为RecyclerView的item设置点击事件 , 子view控件事件的向上处理.外部处理.
  - https://blog.csdn.net/weixin_42630638/article/details/107174609 这个添加事件处理的接口流程才是对的,详细的
  - Android小记：RecyclerView添加Item点击事件监听  三种方式实现

- 网上只是讲了Activity进入全屏和退出全屏的代码实现,

- 测试使用新建一个secondActivity的主窗口,一个新的player来播放, 效果是可以的,就是中间会重新加载网络流,再播放, 然后中间的全屏和正常模式的切换,管理.

  - 解决在非Activity中使用startActivity
  - https://blog.csdn.net/weixin_33672400/article/details/87973017?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=997f4b3f-ab89-4a0b-8f21-6a2b419b1efa&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
  - Android学习笔记之Android Studio添加新的Activity
  - https://www.cnblogs.com/edensyd/p/8621670.html
  - 启动另外一个 Activity 并结束当前 Activity
  - https://blog.csdn.net/qq_37129266/article/details/110950598
  - android(多个Activity之间切换)
  - https://blog.csdn.net/weixin_38420342/article/details/84344496
  - 加一个SecondActivity后,来回切换MainActivity和SecondActivity,声明周期的运行感觉有点乱,需要梳理. 按home键,有时候MainActivity在后台运行.
  - 所以放弃采用增加一个新的Activity的做法, 还是管控好一个Activity里面显示.

---

2021年02月23日11:54:34

- 继续解决全屏的问题
  - 这么用GridLayoutManager，你可能还真没尝试过 https://www.jianshu.com/p/60aa2fc17870
  - 有源码阅读分析,
  
- 安卓自定义长按事件(延长响应时间)
  - https://blog.csdn.net/lili625/article/details/78467180?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=b00eef0c-33b5-4678-933d-b2d2746f8f5a&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
  - https://my.oschina.net/zhangqingcai/blog/29468 事件区别
  - 长按OnLongClickListener无法修改长按时间的解决办法
  - https://blog.csdn.net/mirkowug/article/details/54030612
  
- android 双击事件的处理

  - 单击 -- 使用Android系统提供的OnClickListener接口即可实现
    双击 -- Android系统中并未定义这类事件，所以需要我们自己定义。

  - https://www.jianshu.com/p/e55286d9e5f3

  - Android之按钮点击事件（单击、双击、长按等）

    - 系统默认的延时*时间是*500ms,当按下500ms后才触发LongClick事件

  - https://blog.csdn.net/zbw1185/article/details/94412673

  - Android实现双击事件的两种方式 https://www.136.la/tech/show-93893.html

  - android中的DoubleTap 单击和双击的代码实现, 抽象类和接口的设计

    - https://www.imooc.com/wenda/detail/604604

    - ```
      
      ```

      

- recyclerView三种布局管理器
  - 线性布局管理器
  - 网格布局管理器
  - 瀑布布局管理器
  
- Android视频直播全屏实现
  - https://www.cnblogs.com/baiyi168/p/11344319.html
  - https://github.com/DickyQie/android-video
  - android webview中视频播放及全屏
  - https://www.jianshu.com/p/54ac34790db0
  - RecyclerView详解（四）：LayoutManager布局管理器
    - https://www.jianshu.com/p/501e10bc31f1
  

---

2021年02月25日11:50:38

- 发现用NodePlayer开源组件播放rtmp流媒体,同一个CCTV地址,有时候播放不稳定,容易不显示画面
- recycleview切换不同的adapter,然后通知数据变化,会重新creatviewholder, bindview, 重新绘制加载子元素Item.
- 策略想法,至少可可行.通过在主窗口内容recycleview父布局FrameLayout中,底部放置同样的一个RecycleView, 然后判断进入全屏和退出全屏时候的状态,让原来多画面的recycleview显示隐藏, 全屏的新的recycleview隐藏和显示. 达到进入全屏和退出全屏的目的
- 然后考虑,进入全屏继续播放原来的视频源,和退出全屏, 响应不同的画面视频源的进入全屏播放和退出播放

---

2021年02月26日11:18:25

- Handler用法及解析 handlerThread

  - https://blog.csdn.net/qq_37321098/article/details/81535449

  - 1.handler作用: 

    1）传递消息Message

    2）子线程通知主线程更新ui

- Butterknife

  - ButterKnife是一个专注于Android系统的View注入框架,以前总是要写很多findViewById来找到View对象，有了ButterKnife可以很轻松的省去这些步骤。是大神JakeWharton的力作，目前使用很广。最重要的一点，使用ButterKnife对性能基本没有损失，因为ButterKnife用到的注解并不是在运行时反射的，而是在编译的时候生成新的class。项目集成起来也是特别方便，使用起来也是特别简单。

    ButterKnife项目地址：[https://github.com/JakeWharton/butterknife](https://links.jianshu.com/go?to=https%3A%2F%2Fgithub.com%2FJakeWharton%2Fbutterknife)

---

2021年03月01日09:37:23

- 用vlc搭建rtsp流媒体服务器
  - https://blog.csdn.net/byxdaz/article/details/108024357 本机 成功实现利用vlc作为RTSP流媒体服务的和播放客户端测试
  - 本机测试,刚开始有10s缓冲时间,做了转码分发. 本机服务端cpu使用率很高,200%左右了,转码的负载
  - vlc能搭建简单的RTSP流媒体服务器, 然后用客户端播放测试
  - https://www.cnblogs.com/mq0036/p/12037667.html
    - 各种搭建形式,UDP, RTSP, RTP(MJPG),HTTP
  
- VLC的bug,导致播放死机

  - 用vlc打开自己认为的RTSP流媒体服务地址例如, rtsp://192.168.1.101/mytest.sdp  本机电脑直接死机,cpu奇高, 只有鼠标能响应了.

- RTMP/HTTP/HLS流媒体开源服务器 SRS 说明文档

  - https://www.wenjiangs.com/doc/srs-docs
  - https://github.com/ossrs/srs
  - https://www.cnblogs.com/yjmyzz/p/srs_study_1_install_push_and_pull_stream.html 博客说明
  - https://blog.csdn.net/qq_40265247/article/details/106506690
  - https://www.cnblogs.com/innershare/p/11045363.html
  - https://blog.csdn.net/qq_34317255/article/details/90019528 其他指令说明

- 应用案例说明 01

  ```
  某工厂监控系统
  2014.4 by 斗破苍穷(154554381)
  
  某工厂的监控系统主要组成：
  
  采集端：采集端采用IPC摄像头安装在工厂重要监控位置，通过网线或者wifi连接到监控中心交换机。
  监控中心：中心控制服务器，负责管理采集端和流媒体服务器，提供PC/Android/IOS观看平台。
  流媒体服务器：负责接收采集端的流，提供观看端RTMP/HLS的流。
  观看端：PC/Android/IOS。要求PC端的延迟在3秒内。Android/IOS延迟在20秒之内。
  主要流程包括：
  
  采集端启动：IPC摄像头像监控中心注册，获得发布地址，并告知监控中心采集端的信息，譬如摄像头设备名，ip地址，位置信息之类。
  采集端开始推流：IPC摄像头使用librtmp发布到地址，即将音频视频数据推送到RTMP流媒体服务器。
  流媒体服务器接收流：流媒体服务器使用SRS，接收采集端的RTMP流。FMS-3/3.5/4.5都有问题，估计是和librtmp对接问题。
  观看端观看：用户使用PC/Android/IOS登录监控中心后，监控中心返回所有的摄像头信息和流地址。PC端使用flash，延迟在3秒之内；Android/IOS使用HLS，延迟在20秒之内。
  时移：监控中心会开启录制计划，将RTMP流录制为FLV文件。用户可以在监控中心观看录制的历史视频。
  ```

  

- 实践记录

  - 今天下载开源的流媒体库SRS, 作为国人开发的优秀的流媒体服务平台.决定尝试下效果,应到自己的研究项目中

  - 参考 https://github.com/ossrs/srs/wiki/v3_CN_SampleRTMP RTMP部署实例

  - 根据github教程,下载3.0版本,然后配置./configure && make. 一定记得make, 我开始忘了自己是否make, 然后发现找不到./objs/srs

  - make过程大概5分钟左右

  - 然后配置自己的RTMP服务器设置myrtmp.conf, 默认设置,加一个log输出指定

  - 运行服务  ./objs/srs -c ./conf/myrtmp.conf

  - 任何利用去年学习的ffmpeg进行推流,发现没有找到直接可靠的记录,自己平时记录的信息太过杂散,没有直接记录具体成功的过程.

  - 采用教程上面的命令,播放自带的flv视频,进行推流测试.

  - 在trunk目录下建立一个shell脚本,testFFmpegPush.sh

    ```
    #!/bin/bash
     for((;;)); do \
            /usr/bin/ffmpeg -re -i ./doc/source.200kbps.768x320.flv \
            -vcodec copy -acodec copy \
            -f flv -y rtmp://192.168.1.101/live/livestream; \
            sleep 1; \
        done
    # -re这个选项会将输入的读取速度降低到输入的本地帧速率。它对于实时输出(例如直播流)很有用
    ```

    chmod +x testFFmpegPush.sh 赋予运行权限.

  - 启动脚本,ffmepg成功执行命令. 输出多媒体信息.

  - 启动vlc客户端,输入对应的网络流地址,进行拉流测试.rtmp://192.168.1.101/live/livestream. 发现可以稳定播放srs提供的视频源

  - 然后在自己开发的Android JVideoAssit中,输入rtmp流媒体的地址, 使用NodeMediaPlay成功播放了rtmp流, 实时性比较高, 偶尔出现卡顿. 

  - 测试是在自己的实验室的wifi条件下,4路视频同时拉流播放.

- 下一步,测试本机USB相机的推流,利用上半年研究记录的知识, 2020年10月26日 USB摄像头利用ffmpeg实现rtmp推流

  - ffmpeg 采集相机数据生成本地视频文件

     `ffmpeg -f video4linux2 -r 30 -s 640x480 -i /dev/video0 output_4video.avi`

    `ffmpeg -f v4l2 -framerate 25 -video_size 640x480 -i /dev/video0 output_data.mkv`

  - ffmpeg 采集相机数据进行RTMP推流

    `./ffmpeg -f video4linux2 -s  640x480 -i /dev/video0  -f flv rtmp://127.0.0.1:1935/live/live`

    `ffmpeg -r 30  -i /dev/video0 -vcodec h264 -max_delay 100 -f flv -g 5 -b 700000 rtmp://219.216.87.170/live/test1`

    `ffmpeg -f video4linux2 -qscale 10 -r 12 -s 640x480 -i /dev/video0 -f alsa -i hw:1 -ab 16 -ar 22050 -ac 1 -f mp3 -f flv rtmp://127.0.0.1/rtmpsvr/rtmp1`

  - 网上研究记录

    - linux FFMPEG 摄像头采集数据推流 https://www.cnblogs.com/enumx/p/12346711.html  最新的成果,比较全
    - 国外写的,https://www.scivision.dev/youtube-live-ffmpeg-livestream/,  命令很全
    - FFmpeg Live stream via Python PyLivestream

- 实际测试

  - 用ffmpeg采集本机USB相机,形成RTMP流,再本机VLC拉流播放,延时就比较大, 10秒延时级别+卡顿.

    ```shell
    ffmpeg -r 30  -i /dev/video0 -vcodec h264 -max_delay 100 -f flv -g 5 -b 700000 rtmp://192.168.1.101/live/test
    //-bf B帧数目控制，-g 关键帧间隔控制，-s 分辨率控制
    ```
  ```
  
  - 用ffmpeg采集本机USB相机,形成RTMP流,推送给SRS服务端,再本机VLC拉流播放,延时就比较大, 10秒延时级别+卡顿.
  
  - -b 指定码率注意单位是bit/s,所以我们一般要加k,比如 -b 1000k 就是1000kb/s
  
    -g 设置组的大小
  
  - ffmpeg常用参数说明：https://blog.csdn.net/encoder1234/article/details/51743331
  
    主要参数： -i 设定输入流 -f 设定输出格式 -ss 开始时间 视频参数： -b 设定视频流量，默认为200Kbit/s -r 设定帧速率，默认为25 -s 设定画面的宽与高 -aspect 设定画面的比例 -vn 不处理视频 -vcodec 设定视频编解码器，未设定时则使用与输入流相同的编解码器 音频参数： -ar 设定采样率 -ac 设定声音的Channel数 -acodec 设定声音编解码器，未设定时则使用与输入流相同的编解码器 -an 不处理音频
  
    - GDIGrab用于在Windows下屏幕录像(抓屏)
  
    - 使用ffmpeg录像屏幕, Linux下的屏幕录像, -vd x11
      ffmpeg -vcodec mpeg4 -b 1000 -r 10 -g 300 -vd x11:0,0 -s 1024x768 ~/test.avi
  
    - 上面测试出错,下面这个抓取是成功的命令
  
  ```
      ffmpeg -f x11grab -r 25 -s 800x600 -i :0.0 out.mp4
      ```
      
      –enable-x11grab	enable X11 grabbing (legacy) [no]
      
      需要ffmpeg配置编译选项,支持X11 设备的截屏
  
  ---
  
  2021年03月02日08:57:55
  
  - 继续优化FFmpeg的采集效果, 因为srs提供的命令推流,flv文件`source.200kbps.768x320.flv`速度比较快,客户端拉流比较快
  
  - 改进命令
  
    ```
    ffmpeg -f video4linux2 -s  640x480 -i /dev/video0  -f flv rtmp://127.0.0.1:1935/live/livesteam
    ```
  
    加上-g 20 -b:v 700k以后, vlc拉流播放画面很明显,清晰度提高了, 但是延时还是10s中左右,稳定一些了, 采样率是b那个参数.
  
    延时8秒中左右
  
  - 改进命令,根据youtub的外文的设置,修改
  
    ```shell
    #!/bin/bash
    ffmpeg \
    -f v4l2 -r 30 -i /dev/video0 \
    -c:v libx264 -pix_fmt yuv420p -preset ultrafast -g 30 -b:v 500k \
    -threads 0 -bufsize 512k \
    -f flv rtmp://192.168.1.101:1935/live/livestream
    ```
  
    刚开始感觉延时比较高,大概有8-10秒中, 后续运行一段时间后,实时性能提高,本地vlc播放延时高些为3-5秒.
  
    Android收集客户端拉取srs 流来进行播放, 实时性更好写,延时大概,1-2秒. 
  
    这个方案可以行. 不要用srs作为rtmp服务器,直接利用ffmpeg进行软解码推流,进行播放都可以.
  
    运行环境配置:
  
    - 可能是自己机器里面有nginx-rtmp-module配置,直接就可以进行rtmp的推流服务.
    - 需要在新机器验证
    
  - 设置ultrafast参数 ffmpeg命令行: 
    $ ./ffmpeg -i rtmp://192.168.1.12/live/src -vcodec libx264 -preset ultrafast -b:v 400k -s 720x576 -r 25  
  
  - ffmpeg的转码延时测试与设置优化
  
    - https://blog.csdn.net/wishfly/article/details/51911264
  
- 本机服务器创建了一个推流脚本, startCameraRTMP.sh

  - 确实使用在线秒表, 以及摄像头拍照当前秒表数据和在线秒表数据, 用截屏软件截取某一个时刻的图像,观察拍摄画面数据,和在线秒表数据,得出现实的延迟情况. 大概170ms, 对于mjpg-stream
  - 

- 下一步解决嵌入式ARM处理设备上面的,视频推流就可以. 还可以参考srs中的低延时方案,来进行视频流的分发传输.

- 手机客户端用了第三方的sdk,可以再使用其他的哔哩哔哩bilibili的客户端看看, NodeMediaPlayer这个是不支持rtsp, 然后感觉不是很稳.



-- -

- 《直播从零开始》SRS 带宽测试
  - https://langyastudio.blog.csdn.net/article/details/109743843?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-11.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-11.control



---

2021年03月08日15:47:37

- 起重机的算法适配开发完毕
- 开始项目其他的功能实现
- 语音识别的云端SDK的集成, 硬件部署端的方案测试

---

2021年03月09日09:24:29

- 讯飞语音注册,实名认证,免费功能领取

- 服务器认证信息

  ```
  服务接口认证信息
  APPID
  6046ca59
  APISecret
  6255e0e0e3ce3ed6462c64d751ed08cf
  APIKey
  c58057cda3ca656c78ca3f29f273ca18
  *SDK调用方式只需APPID。APIKey或APISecret适用于WebAPI调用方式。
  ```

  可以开通特定修正功能,候选词, 然后频繁使用的热词,来提高匹配度.

- https://console.xfyun.cn/services/iat 启用普通的语音听写, 下载对应版本的SDK

  -    语音听写 Android SDK 文档 [https://www.xfyun.cn/doc/asr/voicedictation/Android-SDK.html#_1%E3%80%81%E7%AE%80%E4%BB%8B](https://www.xfyun.cn/doc/asr/voicedictation/Android-SDK.html#_1、简介)

- Android Studio创建assets、jniLibs目录

  - https://blog.csdn.net/gengbaolong/article/details/79592584

- Android 科大讯飞语音SDK集成步骤

  - 离线识别 https://blog.csdn.net/qq_20330595/article/details/104573598?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242
  - [https://www.xfyun.cn/doc/asr/voicedictation/Android-SDK.html#_2%E3%80%81sdk%E9%9B%86%E6%88%90%E6%8C%87%E5%8D%97](https://www.xfyun.cn/doc/asr/voicedictation/Android-SDK.html#_2、sdk集成指南)  官方集成指南

- Android集成科大讯飞SDK实现语音识别

  - https://mp.weixin.qq.com/s?__biz=MzA4Nzk0NTU0Nw==&mid=2247484101&idx=1&sn=ef473df94e2815053e21d6f9c3955995&chksm=9030fae1a74773f7d0a2eb6fb8885bb6acf6c3f209e633f626d817582abc2fdd4414775213ac&scene=21#wechat_redirect
  - https://cloud.tencent.com/developer/article/1471667 
  - https://blog.csdn.net/Vaccae/article/details/111595864  这里代码可以直接参考实现, 可以复制
  - 干货】Android利用SurfaceView结合科大讯飞修改语音实别UI

- 实践过程
  - 折腾半天集成SDK, 发现是一个appID这个设置时候前面没有写=号
  - asserts的目录放置不对
  - 那个msc.jar和其他库文件可以直接全部放在libs目录下面
  - 最终还是参照demo的工程设置
  - 后面单独写一个activity测试程序,就可以出来科大的那个识别界面, 但是结果显示,还是要自己写的.

---

2021年03月10日14:59:07

- Linux下代码文件.h .cpp放到windows vs2010编译失败的问题

  - 今天将在Linux下面移植的重机支腿反力计算接口类,通过Windows发给徐工, 他将h和cpp文件添加到他的MFC工程后,提示处很多错误,莫名奇妙的

  - 我自己在本机qt测试没有任何问题

  - 后面徐工说解决了,是代码格式的文件,文件编码的原因.

  - Linux C++代码移植到Windows要解决的问题

    - https://wang520.blog.csdn.net/article/details/8930533?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control

    - https://blog.csdn.net/liumy_2013/article/details/106125880

    - 代码没有任何问题。我怀疑是文件编码问题。我的处理方法是：新建TXT文档，重命名为xxx.h或xxx.cpp，然后把代码复制到新建的文档中。用新建的文档替换以前的.h和.cpp文件。所有从linux拷贝到windows的.h和.cpp都按如此方法替换。然后再用vs2010编译，成功编译。

    - 出现这种情况的原因为两种操作系统的中文压缩方式不同，在windows环境中中文压缩一般为gbk，而在linux环境中为utf8，

      这就导致了在windows下能正常显示txt文件在linux环境下打开呈现了乱码状态。

    - windows与linux文件拷贝出现中文乱码解决
      使用ubuntu下载convmv
      使用命令 convmv -f UTF-8 -t GBK -r --nosmart --notest <文件夹名>
      由于windows使用GBK汉字显示，而linux使用UTF-8汉字，所以需要做相应转换后传输解决乱码问题

    - --notest 真正进行操作

      ```
      命令使用：
      格式:convmv -f 源编码 -t 新编码 [选项] 文件名/目录名
      ```

      原文链接：https://blog.csdn.net/zhangyuejf/article/details/109049392
    
  - 科大讯飞语音唤醒(Android)

    - https://blog.csdn.net/hdhhd/article/details/109810121
    - https://console.xfyun.cn/services/awaken  平台唤醒词语设置,sdk下载

  - Android ListView以及RecyclerView里面 监听Item可见以及不可见的状态

    - https://blog.csdn.net/huazai30000/article/details/88361440
    - 这个通常是打点的需求。 打省略号....
    - https://github.com/xuhuawei131/RecyclerViewItemVisible
    
  - Android 超好用的播放器——ijkplayer

    - https://www.jianshu.com/p/c5d972ab0309
    - Android基于ijkplayer的 RTSP视频播放器简易实现（20200923）
    - https://blog.csdn.net/weixin_42651184/article/details/108755895?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-1&spm=1001.2101.3001.4242
    - **https://github.com/wenyuanw/Android_Ijkplayer_app**
    - Android开发-基于ijkplayer框架开发网络电视直播播放器的实现
      - https://blog.csdn.net/fukaimei/article/details/80553709?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-1&spm=1001.2101.3001.4242

  - Android视频直播的实现

    - https://blog.csdn.net/huaxun66/article/details/53427771?utm_medium=distribute.pc_relevant.none-task-blog-2~default~BlogCommendFromMachineLearnPai2~default-2.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~BlogCommendFromMachineLearnPai2~default-2.control  清晰讲解

  - 使用RecyclerView结合jiaozivideoplayer去加载不同类型的布局

    - https://blog.csdn.net/asjqkkkk/article/details/78489245 
    - 布局内容丰富, 又告诉如何使用recycleview的教程,浅显易懂.
    - https://github.com/asjqkkkk/MySimpleNews  必须看看这个设计实现, 播放器,图片,点击效果,全屏,退出全屏

  - https://gitee.com/tcy0206/dkplayer  基于IjkPlayer的视频播放器，支持直播点播，悬浮窗播放，广告播放，边播边缓存；支持重力感应自动全屏；完美实现ListView和RecyclerView列表播放；支持清晰度切换；支持一行代码切换MediaPlayer和ExoPlayer；模仿抖音效果demo；Android O PiP demo

  - 

- OA电脑系统中,rar分块压缩一个大于10M的文件, 才能传输给其他人

- android实现下拉框和输入框结合 
  - 将一个EditText和ListView+PopupWindow 结合起来。自定义一个EditText，在自定义控件中用PopupWindow实现弹出ListView，已达到想要的效果。	
  - https://blog.csdn.net/adolph_jun/article/details/78254441
  
- Android进阶之自定义ViewGroup—带你一步步轻松实现ViewPager

  - https://www.jianshu.com/p/af8e14ff5f0c
  - 自定义的viewgroup, 如何使用,比如自定义的CellLayout, 可以通过addView()来添加子控件.

- Android实现fragment向Activity实时传递信息

  - 常用的一般有三种方式来实现以上需求:

    1. 通过fragment中brocastReceiver来通知activity刷新UI;
    2. 通过eventbus订阅者模式来通知Activity实时刷新UI;
    3. 通过fragment中编写接口设置监听器,然后在actvity中实现该接口,在接口方法中刷新UI即可
    原文链接：https://blog.csdn.net/s1674521/article/details/78318525
  
- Android Fragment与Activity交互的几种方式

  - 这里我不再详细介绍那写比较常规的方式，例如静态变量，静态方法，持久化，application全局变量，收发广播等等。

  - https://www.cnblogs.com/zhujiabin/p/7700192.html     activity 向 fragment发送消息

    首先我们来介绍使用Handler来实现Fragment与Activity 的交互

  - https://blog.csdn.net/tiramisu_ljh/article/details/67654454     利用handler fragment和activity双向发送消息

  - https://zhuanlan.zhihu.com/p/110878981

  - Android Handler正确使用姿势

    - https://blog.csdn.net/geanwen/article/details/54233895
    - removeCallbacksAndMessages
    
  - handler的正确使用姿势   这个讲了原理,解决方案,比较全面合理
  
    - https://blog.csdn.net/zhou4781182/article/details/79468682?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242
    - Android采取了单线程UI模型，开发者无法在子线程中更新UI，为此Android为我们提供了Handler这个工具，可以开发者切换到主线程更新UI。
    - 当前界面结束时将消息队列中未被处理的消息清除，从源头上解除了这条引用链
  
- Fragment与Fragment、Activity通信的四种方式 

  - http://blog.sina.com.cn/s/blog_1382e29410102xan8.html
  - 一般用接口, 实现
  - 用广播方便灵活,
  - Fragment直接调用Activity中的public方法
  - Fragment直接根据包含关系拿到另一个Fragment的实例,在调用中的public方法

-  设计模式C++实现（8）——代理模式,没事看看设计模式,具体开源实践技术,新的C++标准的实际使用应用,解决问题

- 分布式系统开发,应用,具体应用方向

  - https://blog.csdn.net/wuzhekai1985/article/details/6669219

- 音视频开发 Android获取（网络和本地）视频缩略图 https://blog.csdn.net/ywl5320/article/details/107576410#comments_15101076

- Android中Enum（枚举）的使用

  - https://www.cnblogs.com/whycxb/p/7995085.html

  - Android官网不建议使用enums，占用内存多（Enums often require more than twice as much memory as static constants.）。

    Android中当你的App启动后系统会给App单独分配一块内存。App的DEX code、Heap以及运行时的内存分配都会在这块内存中

  - 用法,一,直接定义常量,用法二, 添加自定义属性和方法

  - 替代方案, 接口变量, 定义接口来代替,
  
    ```
  因为接口会自动将成员变量设置为静态的（static）、不可变的（final），这一点可以防止某些情况下错误地添加新的常量。这也使得代码看起来更简单和清晰。 同时，一个的简单测试显示，同样的接口（字节码文件）占用的空间是209个字节左右，而类（字节码文件）占用的空间是366个字节左右。更少的字节码文件意味着加载和维护的成本更低。此外，JVM 加载接口的时候，不需要担心类提供的额外特征（如重载、方法的动态绑定等），因此加载更快。
    ```
  
  - ```
    public interface IConstants {
        //接口会自动将成员变量设置为静态的（static）、不可变的（final）
        String LANGUAGE = "language";
        String LANGUAGE_zh = "zh";
        String LANGUAGE_en = "en";
        String LANGUAGE_es = "es";
        String LANGUAGE_fr = "fr";
        String LANGUAGE_ar = "ar";
        String LANGUAGE_ru = "ru";
  }
    ```
  
  - https://www.jianshu.com/p/05ab8bd3c713 避免使用枚举,增大APK的体积.
  
- 科大讯飞语音唤醒(Android)

  - https://blog.csdn.net/hdhhd/article/details/109810121
  - 前面的工程项目配置和语音识别差不多，但是需要从SDK的res文件夹中复制ivw文件夹粘贴到main下面
  - https://blog.csdn.net/TZYZlpx123456789/article/details/80839009?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242

- 程序起来后,如何指导所有适配器数据初始化完成,数据控件加载完成,然后开始播放视频呢

  - Android – 如何知道RecyclerView何时完成放置项目？

  - http://www.voidcn.com/article/p-ssenvgvy-buz.html

  - 如何判断recyclerView刷新数据是否加载完毕？

    - recyclerView刷新数据：不管是添加项目，还是删除项目，还是notifychange完全重构列表。最终都应该会引起layout的改变，当layout完毕时，大概也就是题主说的“刷新数据加载完毕时？”如果是这样的话，很简单：recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    - getViewTreeObserver（）是个View对象通用的流程监视器，可以添加包括上面的各种状态监视。链接：https://www.zhihu.com/question/61971467/answer/193540885
    - 我加到这个逻辑到程序里面后,由于视频的播放,经常导致持续调用这个事件,一直提示,加载完成.估计是视频的画面一直在调整.

  - 再试试这个,适配器的数据事件, Android 监听RecyclerView内部数据变化

    - https://blog.csdn.net/qq569699973/article/details/104911212

  - *******,5星, 最后通过在Adapter里面设置onViewAttachedToWindows监听视图是否创建绑定到recycleview里面, 根据个数,最后调用FragVideo的启动播放的回调接口,完成软件启动后,等配置数据加载完成,自动开始所有的视频画面的播放.

    ```java
     @Override
        public void onViewAttachedToWindow(@NonNull RecycleViewHolder holder) {
            super.onViewAttachedToWindow(holder);
            Log.d(TAG,"RecycleViewHolder:" + holder + "添加到视图");
            if (mViewHolderMap.size() >= mPlayUrlMap.size()) {
                if (mItemDbClickListener != null) {
                    mItemDbClickListener.onStartPlay();
                }
            }
        }
    ```

    完成了功能, 每一个viewhoder创建,都会调用这个消息通知

  ---

  2021年03月18日08:58:45
  
  - java 延时的几种方法方法
    - https://www.cnblogs.com/jiangfeilong/p/10494414.html
    - Timer
    - new Thread sleep
    - Robot, delay
    - Timer类,schedule.TimeTask
    - 用concurrent包的TimeUnit类延时sleep()方法延时
  
- 自己开发的安卓APP怎么发布？

  - 首先打开安卓市场官网，在右上角找到注册按钮，先注册成为开发者。例如应用宝是可以利用qq账号登陆的，就百阅重新的注册账号了/
    在就是点击“开发者”进入“开发者中心”页面（也可从网页下方的“开发者入口”进入）。
    选择“发布软件”选项，依
  - 在android studio里创建一个签名文件，并使用它打包项目生成发布版APK安装包
  - Android 签名打包
    - https://blog.csdn.net/csdn_wlc/article/details/80573929
    - Android 要求所有已安装的应用程序都使用数字证书做数字签名，数字证书的私钥由开发者持有
  
- 服务端的程序部署

  - 开发mjpg-stream推流脚本 形成start_all_video.sh和stop_all_video.sh, 脚本运行在安装的mjpg_steamer根目录下, 识别命令mjpg_streamer
  - 开发srs_rtmp推流脚本 形成start_all_video.sh和stop_all_video.sh, 脚本运行在安装的mjpg_steamer根目录下, 识别命令mjpg_streamer

---

2021年03月19日10:44:16

- 找到一个好东西, 特别是针对c/C++, 包括QT, 源码分析和浏览网站

- https://code.woboq.org/

- ### Browse Open Source Projects

  → Browse the source code of [Qt](https://code.woboq.org/qt5/) | [GLibc](https://code.woboq.org/userspace/glibc/) | [LLVM](https://code.woboq.org/llvm/) | [Boost](https://code.woboq.org/boost/boost/) | [GCC](https://code.woboq.org/gcc/) | [Linux](https://code.woboq.org/linux/linux/)

- 可以编程的时候,查看类或者函数的定义, 然后可一查看源码里面具体的实现细节. 对掌握源码知识非常有帮助

- 如果有类图结构展示就更好了

- https://code.woboq.org/qt5/   qt5的源码,类,函数说明,

  - 是这个哥们在讲源码阅读的时候, 提到的方法,感谢
  - 利用doxygen扫描Qt的源码
  - 我先是利用doxygen扫描Qt的源码（这里默认已经添加了Qt Src组件），生成一份.chm的帮助手册。
    这个做法的优点是，可以即时查看源码，查看类图，比如想用到QImage类，那直接索引QImage，查看API，查看实现，查看继承关系，相类似的类等等，是一种将实践工作与学习结合在一起的方法
    原文链接：https://blog.csdn.net/Alezan/article/details/104558673

- Qt查看源码总结帖

  - https://blog.csdn.net/Alezan/article/details/104558673
  - 讲了了下载源码和pdb文件,在qtcreator和visual studio里面如何配置源码路径和pdb符号文件路径,然后进入源码,观察实现
  - 讲到了源码浏览网址 woboq.org, 专门分析qt, linux, boost的源码
  - 讲了调试进入源码观看,查看实现逻辑

- Linux进程内存分析pmap命令

  - ```
      pmap [ -x | -d ] [ -q ] pids... 
           pmap -V 
    ```

- 什么是RAII？

  RAII是Resource Acquisition Is Initialization（wiki上面翻译成 “资源获取就是初始化”）的简称，是C++语言的一种管理资源、避免泄漏的惯用法。利用的就是C++构造的对象最终会被销毁的原则。RAII的做法是使用一个对象，在其构造时获取对应的资源，在对象生命期内控制对资源的访问，使之始终保持有效，最后在对象析构的时候，释放构造时获取的资源。
  原文链接：https://blog.csdn.net/quinta_2018_01_09/article/details/93638251

- C++RAII机制

  - https://blog.csdn.net/quinta_2018_01_09/article/details/93638251

  - ```
    使用d-pointer的目的：
    实现二进制兼容，头文件与实现细节无关。Qt started out closed source？
    
    二进制兼容：即Qt（dll）版本的更新替换不会影响应用程序exe。因为Qt的接口类（QObject等）的实例的大小是固定的。
    
    在Qt中，QObject，QWidget，QLabel这些都是接口类，真正的实现在QObjectPrivate，QWidgetPrivate，QLabelPrivate 等Private类中。
    ```

- C++标准库为互斥量提供了一个RAII语法的模板类std::lock_guard

Qt 信号和槽源码分析

- https://segmentfault.com/a/1190000020241190

QtCreator源码分析（一）——QtCreator源码简介

- https://blog.51cto.com/9291927/2093779  最近就紧跟这个学习吧

- vlc命令行大全
  - https://blog.csdn.net/wupengqiangqinli/article/details/50728005
  - vlc v4l2:// :v4l2-dev=/dev/video6
  - vlc播放 vlc http://192.168.1.103:1024

