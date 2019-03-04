---
title: Fiddler使用入门到入土
date: 2018-12-25 13:54:23
tags: Web
categories: Web
---

# Fiddler
## 1.fiddler介绍

介绍的话，抛一个链接到官网去看看吧  
https://www.telerik.com/fiddler

一个中文版本的Fiddler
https://bbs.125.la/forum.php?mod=viewthread&tid=14106559

<!--more-->

![](https://i.imgur.com/aPue7UY.png)

## 界面介绍

![](https://i.imgur.com/FOmNZjL.png)

### 会话窗口

|   |   |
|:---:|:---|
| **Result**  |  **HTTP状态码**  |
|  **Protocol**   | **请求使用的协议，如HTTP/HTTPS/FTP等**  |
|  **HOST** | **请求地址的主机名或域名**  |
|  **URL** | **请求资源的位置**  |
| **Body**  | **请求大小**  |
| **Caching**  | **请求的缓存过期时间或者缓存控制值**  |
| **Content-Type**  | **请求响应的类型**  |
| **Process**  | **发送此请求的进程ID**  |
| **Comments**  | **备注**  |
|  **Custom** | **自定义值**  |



----------
### Inspectors
- 抓包得到的数据在列表中显示，点击之后在右侧的Inspectors显示详细内容。


#### http request


### *statistics
> 各种请求时间、header、body之类的
### *Inspectors（检查者）


### *Composer
> 将左侧请求拖到右侧，可更改登录信息，然后点击右上侧Excute

### *Filters
> 1. show only Internte Hosts  
 - Run ...
 - Actions → now
> 2. Flag the following Hosts  

----------

## Fiddler工作原理

> &emsp;Fiddler的本质是一个局域网HTTP代理，即通过手动设置或自动设置，将局域网中的数据请求中转至软件内部的请求处理程序，再由Fiddler程序进行发送和接收请求，并解析至软件显示界面，同时将接受的请求结果返回给原始请求发送者。  
> &emsp;使用的代理地址是：[127.0.0.1](#127)，端口默认为8888，即默认监听127.0.0.1:8888。退出的时候它会自动注销代理，这样就不会影响别的程序。  
> &emsp;Fiddler可以抓取支持http代理的任意程序的数据包，如果要[抓取https会话](#https)需进行设置


## Fiddler的工作流程

![](https://i.imgur.com/3PPX4bx.png)

> 首先fiddler截获客户端浏览器发送给服务器的https请求,此时还未建立握手。  


1. fiddler向服务器发送请求进行握手， 获取到服务器的CA证书， 用根证书公钥进行解密， 验证服务器数据签名， 获取到服务器CA证书公钥。
2. fiddler伪造自己的CA证书， 冒充服务器证书传递给客户端浏览器， 客户端浏览器做跟fiddler一样的事。
3. 客户端浏览器生成https通信用的对称密钥， 用fiddler伪造的证书公钥加密后传递给服务器， 被fiddler截获。
4. fiddler将截获的密文用自己伪造证书的私钥解开， 获得https通信用的对称密钥。
5. fiddler将对称密钥用服务器证书公钥加密传递给服务器， 服务器用私钥解开后建立信任， 握手完成.

> 对称密钥加密消息，开始通信

1. fiddler接收到服务器发送的密文， 用对称密钥解开， 获得服务器发送的明文。再次加密， 发送给客户端浏览器。
2. 客户端向服务器发送消息， 用对称密钥加密， 被fidller截获后， 解密获得明文

> 由于fiddler一直拥有通信用对称密钥， 所以在整个https通信过程中信息对其透明。

## 2. Fiddler的HTTP代理
### HTTP协议了解
> 超文本传输协议，基于请求与响应模式的、无状态的、应用层的协议  
> 


### 配置浏览器 Chorme、IE、FireFox

> Chorme、IE不需要做代理设置，FireFox需要手动更改,手动更改之后不再使用Fiddler时需恢复修改  

![](https://i.imgur.com/mvD6cit.png)

端口设置
端口一共有0~65535的范围，而在TCP/IP网络中，为各种公共服务保留的端口号范围是1~1023，其提出“协议端口”的概念，用于标识两个通信的进程。
一般配置时使用1w+~6w+之间

### <span id="https">配置fiddler允许监听到https</span>
> fiddler默认只抓取http格式的

- 打开fiddler菜单Tools->Options->HTTPS


####### 其他具体内容见参考文档

##


----------
# 补充
## <span id="127">localhost，127.0.0.1 和 本机IP 三者的区别</span>


https://blog.csdn.net/hongxiaoshuang/article/details/52924527

https://blog.csdn.net/xiao_xing_yun/article/details/53412058


##网页无法访问
> 如果Fiddler非正常退出，这时候因为Fiddler没有自动注销，会造成网页无法访问。

- 解决方法  
结合Fiddler的工作原理，可能是Fiddler没有自动注销造成，所以修改 IE浏览器的默认代理即可完成。**打开IE浏览器->设置选项中-> 连接-> 局域网设置-> 代理服务器取消掉。**










----------

参考文档：
https://www.cnblogs.com/miantest/p/7289694.html

https://docs.telerik.com/fiddler/Configure-Fiddler/Tasks/ConfigureBrowsers




















给大家准备好刀了，一人一把，别抢 ！  
∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤ ∝╬▅▆▅▆▅▆▅▆▅▆▅▆▇◤  
拿好了，大家，上！！

