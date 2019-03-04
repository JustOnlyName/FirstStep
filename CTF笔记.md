---
title: edu.aqniu笔记
date: 2019-02-18 22:02:15
tags: CTF
password: ctf.org
---
> 安全牛的课程演示记录

<!--more-->

# 1. sql宽字节注入
## url转码
|空格|%20|
|-|
|'|%27|
|#|%23|
|\|%5C|

利用MySQL的一个特性，MySQL使用GBK编码的时候，会认为两个字符时一个汉字（前一个ascii码要大于128，才到汉字的范围）

**&emsp;' 	&emsp;->	 &emsp;&emsp;\'&emsp;&emsp;		->	  %5C%27**  
**%df '	-> &emsp;%df\' &emsp;	->	<font color=red>%df%5C</font>%27**  
此处的单引号变为%27逃逸


## 基于约束的sql攻击

# 2. kali 持久加密USB安装

1. 将kali镜像iso文件复制到虚拟机当中（通过共享文件夹从物理主机传到虚拟机）
2. 插入U盘
> 命令    `dmesg` 显示U盘类型【sdb】系统写入的日志


##### 1. 将镜像文件刻录到U盘，制作usb的live启动盘

##### 2. 划分剩余分区，用于后续加密

- `dd if=kali-linux-...-amd64.iso of=/dev/sdb(此处的sdb是根据所插入的存储设备的类型） bs=1M`
- `parted`命令行磁盘分区
- `print devices`显示现在挂载的硬盘
- `select /dev/sdb`选中磁盘在此操作
- ![](https://i.imgur.com/dbWqvwN.png)
- `mkpart primary ** **`手动进行分区



##### 3. 使用luks对分区进行加密

> luks加密分前端和后端加密

- `cryptsetup --verbose --verify-passphrase luksFormat /dev/sdb3(u盘中的第3分区）`
- `cryptsetup luksOpen /dev/sdb3 usb(需要给一个挂载的名称，会在/dev/mapper/usb生成文件)`打开加密的分区来进行写入
- `ls /dev/mapper/usb `
- `mkfs ext3(ext4) /dev/mapper/usb`格式化磁盘分区
- `e2label /dev/mapper/usb persistence`设置卷标（必须用persistence）
- `mkdir /mnt/usb/`新创建一个目录
- `mount /dev/mapper/usb /mnt/usb`相当于连接目录
- `echo "/ union" > /mnt/usb/persistence.conf`
- `umount /dev/mapper/usb`将挂载的文件卸载掉
- `cryptsetup luksClose /dev/mapper/usb`完成持久加密的usb


# 3. 熟悉Linux环境

- `gnome-tweak-tool`字体调整，在terminal界面命令行
- `clear`将命令行界面清空
- `apt-get install netspeed`网络流量监视，1.安装包……2.添加到工具栏，点alt键在工具栏一行点右键，添加到面板

> `apt-get`命令 安装官方软件常用命令


# 4. 熟悉BASH命令

> ls、cd、pwd、cat、more、tail、cp、rm、top、ps、grep、ifconfig、netstat、awk、sort、route、mount、dmesg、find、whereis、echo、vi


命令使用方式可见[Linux 命令大全](http://www.runoob.com/linux/linux-command-manual.html)

**添加内容**  
`tail`命令常与`watch命令同时使用`





# DoS攻击

拒绝服务攻击：针对服务器展开的攻击。目的是让服务器无法继续提供服务。

手段是恶意**占用服务器提供的服务，**使服务资源衰竭，无法继续为其他人提供服务。

占用服务的办法：  
几条途径：TCP（传输层面向连接的协议）、UDP、ICMP

1. SYN洪水（很多，这个东西很多发给他，属于TCP层面的攻击）

   漏洞：三次握手的漏洞。

![](https://i.imgur.com/KpluQpo.png)

男女朋友之间，一个发起消息，另一个把TA晾在那

一次可能很短时间，但很多次请求消息可能时间就很长

服务器多次发送syn请求，但不回复，导致服务器资源耗光

**疑问：客户端先耗光资源，而服务器能力仍充足**

延伸：DDOS攻击，第一个D意思是分布式计算机，也就是控制多台电脑（肉机），让大家同时发送，就好比许多弱小的人，同时来攻击一个巨人。

1. land攻击

   建立在tcp基础上的攻击。  
   利用握手机制。

![](https://i.imgur.com/3J11MhG.png)

过程：客户端伪造一个tcp握手包，发送给服务器。该握手包的源IP地址被伪造为服务器的IP地址。服务器收到包后，向自己发送一个握手确认包，重点是服务器自己又回复了一个确认包，这样完成了三次握手。**建立了一个完全没有意义的链接。**

1. UDP攻击

   常见的一个攻击是利用服务器的两个服务，CHARGEN和echo服务。前者为客户端提供一些随机的字符，后者能够完全将客户端发给他的字符发送回来。

![](https://i.imgur.com/8750eKV.png)

漏洞分析：

无穷无尽之间的发送



1. 死亡之ping

Ping通常用来诊断网络是否导通，主机是否可访问。
他的缺陷是一个ping的数据包通常小于64K

做法：发送一个大约于64K的数据包，导致对方以为内存出错，导致主机故障。



## 实现

1. 网络编程<libnet.h>虚拟机Fedora

wireshark










