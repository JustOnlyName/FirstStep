---
title: 反编译测试
date: 2019-01-30 21:20:07
tags: Decompile
---

&emsp;最近无趣，看了看某软件install时出现的accept协议，不同意不让安装那个。提到一句“不允许解码、逆向工程、反汇编或删减本软件至人们可感知的形式（除非相关适用法律允许这样做）”
下面了解了解反编译的知识

<!--more-->
# Java反编译

> &emsp;我初步理解“编译”是指源代码转换成二进制执行代码的过程，比如将C源代码编译成.exe可执行文件；那么把二进制执行代码转换成源代码的过程就叫“反编译”,意思是将代码、汇编语言这些东西制作成应用程序这个过程的反过程，比如把exe转换为C源代码就叫“反编译”。

那就用一个与应用程序那种可视化界面最接近的我以前的Java程序来测试一下。

## Java导出JAR file
> jar是什么，导出命名时发现，其与zip扩展名可互换，也就是一种包

- export过程
<img src="https://i.imgur.com/w0DeufY.png" align="left"></img>  

是个很简单的程序

![](https://i.imgur.com/28MorbO.png)

<img src="https://i.imgur.com/FNwXykZ.png" align="left"></img>

&emsp;  

&emsp;  

## jar文件转为exe文件
> &emsp;使用exe4j软件可以完成（下载界面介绍了解到install4j软件，记录下来以后可以尝试），也可以使用[Jar2Exe](http://www.jar2exe.com/)应用程序。  
&emsp;操作流程见[参考文档](#1)

### <font size=5 color=red>**Error**</font>  
&emsp;
<font size=5>1.&emsp;</font>    
  ![](https://i.imgur.com/SZDLovb.png)  

- 这是由于从eclipse中Export时操作错误导致。出现所需要的类没有在exe文件中，原因有
1. Export时选择单个的主类文件，没有选择整个project导出，使用整个project导出则会将使用到的所有包都包含在内。  
2. 导出时没有选择JAR file，而是选择Runnable JAR file。  
<font size=5>2. &emsp;</font>  
  ![](https://i.imgur.com/VJeHc8B.png)
- 由于使用exe4j时操作失误导致。本机JVM为64bit，但打包成exe过程中选择的时32bit   
  ![](https://i.imgur.com/Cw23jNa.png)

<font size=4>**注意**</font>  
  填写.jar包或jre路径时，使用<font color=red>relative path</font>

## exe文件反编译重点过程
> 几个常用的Java源码类型的反编译软件或插件<font color=blue>JD-GUI、XJad</font>

- 原本以为是exe文件反编译为java文件，但操作之后是将exe文件运行时受支持的源jar文件反编译回java文件。

### JD-GUI

> 此处可以了解一下C:\Users\***\AppData\Local\Temp文件夹的作用

运行exe文件时，会有支持该exe文件运行的临时文件.jar文件生成，找到该.jar文件。  
运行JD-GUI应用程序，直接将".jar"文件拖入进去即可查看里边的“.class”文件

> 可以反编译单个.class文件，右侧显示代码。   

![](https://i.imgur.com/IBrmJKZ.png)

# Unity3D反编译

## Builds\balls.exe
> 从同学那里捣鼓过来的，就来当个人的实验样本吧  

![](https://i.imgur.com/yk7cGWE.png) ![](https://i.imgur.com/CL8eqBw.png)

反编译出来的文件放到RE文件夹里

## 使用Reflector
> 这个软件是.NET的，但是可以用到Unity的C#代码上，需要用到插件Reflector.FileDisassembler.dll下载地址：http://www.xdowns.com/soft/184/dll/2014/Soft_130597.html

- 把下载好的`Reflector.FileDisassembler.dll`文件放到软件根目录下的Addins文件夹中（哪里都可以）

- 添加插件  
![](https://i.imgur.com/cHXdADq.png)
![](https://i.imgur.com/9SZ6zQj.png)  
添加后关闭窗口即可

上述准备工作完成，可以进行反编译测试了

- Ctrl+O,打开文件,选择Unity程序对应的应用程序扩展，扩展名为.dll那些
左侧有分析好的，代码部分在{}花括号里，将花括号里的文件反编译出来。

![](https://i.imgur.com/63rko2X.png)

完成之后  
![](https://i.imgur.com/BMvtGDR.png)  

## 注意
在进行下一次反编译前，先Refresh软件，否则 file disassembler不可用  


# 参考文档：  

- <span id="1">[eclipse 导出可运行jar包时三种Library handling的区别](https://blog.csdn.net/qq_21808961/article/details/81185934)</span>

- [exe4j安装及注册](https://www.cnblogs.com/jepson6669/p/9211208.html)

- [使用exe4j将java项目打成exe执行程序](https://www.cnblogs.com/duwanjiang/p/6390379.html)

- [Java反编译工具使用对比，最好用的Java反编译工具 --- JD-GUI、XJad](https://blog.csdn.net/chenchunlin526/article/details/78259682)

- [几种java反编译软件的安装以及使用总结](https://blog.csdn.net/qq_26458903/article/details/79974775)

- [Unity3d 各种反编译](https://blog.csdn.net/qq_15267341/article/details/51749986)