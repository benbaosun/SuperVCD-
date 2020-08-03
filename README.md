# SuperVCD-
SuperVCD Store是一个用纯Java技术开发的音乐及视频光盘销售系统。它由两部分组成: 前端光盘查询，及后端数据采集和传输。其中光盘查询模块提供了基于Swing技术的可视化图形界面，用户可以搜索要找的光盘类别,查看光盘的详细信息等等；数据采集和接收模块则负责读取光盘数据文件，并通过基于网络和多线程技术的机制传输数据。
SuperVCD Store项目概述

2.1． 项目需求分析
SuperVCD Store是一个用纯Java技术开发的音乐及视频光盘销售系统。它由两部分组成: 前端光盘查询，及后端数据采集和传输。其中光盘查询模块提供了基于Swing技术的可视化图形界面，用户可以搜索要找的光盘类别,查看光盘的详细信息等等；数据采集和接收模块则负责读取光盘数据文件，并通过基于网络和多线程技术的机制传输数据。.
1.前端光盘查询
 
图2-1 查询界面首页
 
图2-2选择目录查询界面
 
图2-3查询结果概要
 
图2-4 选择查询结果概要
 
图2-5查询结果明细
2.后端数据采集和接收

 
图2-6 后端数据服务启动
 
图2-7后端数据服务运行
 
图2-8 SuperVCD应用启动

2.2．项目结构分析和运行指南
2.2.1应用程序结构


表2-1  图形用户界面文件列表
文件名称	功能
MainFrame.java	StoneForest应用的主界面框架
MusicPanel.java	这个类构建VCD的主面板(panel)
MusicDetailsDialog.java	这个类显示VCD详细信息对话框
MusicEntryDialog.java	这个类提供VCD详细信息输入框（可选，本项目未使用）
TrackEntryDialog	这个类提供VCD歌曲信息输入框（可选，本项目未使用）
表2-2  数据服务类列表
文件名称	功能
DataAccessor.java	这个抽象类定义了如何读取一个数据文件
MusicDataAccessor.java	音乐VCD数据读取的实现类，继承了DataAccessor
Handler.java	这个类是基于socket连接的多线程处理器
MusicDataClient.java	这个类连接数据服务器来获得数据
MusicDataServer.java	这个类提供数据服务
StoneForestProtocol.java	这个接口包含数据服务的协议信息
表2-3   工具类列表
文件名称	功能
StoneForest.java	这个类是整个应用的主（main）入口类
Duration.java	这个类描述时间的长度。 它包括小时，分和秒
Track.java	这个类代表歌曲VCD数据
Recording.java	这个抽象类代表音乐VCD数据，比Track含更多信息
MusicRecording.java	这个类代表音乐VCD数据, 继承了Recording

表2-4   其他
文件名称	功能
music.db	这个文件以特定格式提供数据
runjavadoc.bat	这个批处理命令可以用来生成java doc文档
docs	这个文件夹用来放置生成的java doc文档
images	这个文件夹用来放置项目所需的图片

2.2.2项目运行指南：

(1) 编译并启动数据服务器  
假定已经配置好Java开发环境，那么打开一个DOS控制台(Console)，然后编译数据服务类MusicDataServer.java, 如下：
javac MusicDataServer.java
之后运行数据服务器，如下：
java MusicDataServer
(2) 编译并启动StoneForest类  
打开另一个DOS控制台(Console)，然后编译StoneForest.java类, 如下：
javac StoneForest.java
之后运行它，如下：
java StoneForest
项目就会启动并运行。


