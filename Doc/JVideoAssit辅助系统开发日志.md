2021年01月20日 HRI系统 安装辅助系统

---

- 科技宅」教你用超声波实现毫米级测距，附送程序源码
  - https://baijiahao.baidu.com/s?id=1658521479319138302&wfr=spider&for=pc
  - 超声波测距模块其实有很多种，其中HC-SR04是我们较为常见的一种型号，在这里我们使用HC-SR04超声波测距模块来实现我们的测距功能。HC-SR04支持2cm-400cm之间的非接触式距离测量功能，测量精度可以到达3mm！该模块集成了超声波发射器、接收器和其他控制电路等。
  - **HC-SR04的驱动程序**
  - GPIO 引脚驱动库

- 开发板推荐,基于androi系统

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
    - 

- 使用RecyclerView和SurfaceView实现视频播放

  - https://blog.csdn.net/wang927893/article/details/78860735?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-2&spm=1001.2101.3001.4242
  - 这个参考原理，recycleview的用法

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

  - 可以切换的时候，自己实现hide或者show; 可以设置缓存，可以自己实现缓存。

  - ```
    mViewPager.setOffscreenPageLimit(5);  这个是有效的，4个页面全部缓存成功。
    ```

  - https://blog.csdn.net/weixin_33787529/article/details/94472152

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