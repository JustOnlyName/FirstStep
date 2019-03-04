---
[miscellaneous_杂项](miscellaneous_%E6%9D%82%E9%A1%B9.md)
title: miscellaneous_杂项
date: 2018-12-25 14:06:40
tags: Hello
categories: Hello
---

> 作为一名各种方面赤果果的新手，在博客搭建方面、markdown、计算机……遇到很多问题，姑且先记录下来，以便为日后思考解决方案。同样那句话，好记性不如烂键盘膜*.*

<!--more-->
# MarkDownPad2相关

## 1. 无法输入中文
> 新建一篇博文，打开后无法输入中文内容

- 将应用程序Tools→Options更换为English格式，不要使用中文格式

## 2. 表格

> 在https://c-xuan.com/download/table2code.xlsm下载文件用于Excel文件转表格代码


<table><tr><th width='10%'>1</th><th width='10%'>a</th></tr><tr><td>2</td><td>b</td></tr><tr><td>3</td><td>c</td></tr><tr><td>4</td><td>d</td></tr><tr><td>5</td><td>e</td></tr><tr><td>5</td><td>e</td></tr><tr><td>6</td><td>f</td></tr></table>

> **添加表格的扩展**

工具 》选项 》 Markdown 》Markdown处理器 改为 “Markdown(扩展)”即可。

\  
| daf  | fdasf | fdasf | fdsa | fdas |
|------|-------|-------|------|------|
| fads |       | fsad  | fdas | fda  |
|      | fdsa  | fdsa  | fsda | fda  |
| fsda | fsad  | fdsa  |      | fads |

\  
第一列表头在\<td(th) rowspan="4">的作用下无法顺利去掉，跨行那一单元格无法到第一列

|| fdasf | fdasfffffff | fdsa | fda<br>s |df
|:------:|-------:|:-------|------|------|
|<td rowspan="4"> 跨行| d |   |  |   |
|        |        |        |      |
|        |        |        |      |
|        |        |        |      |



- **注意**：表格区域上下必须留有空格  
表格内进行换行\<br>  
居中处理：在“----”前后添加冒号


> 或使用[Table generator](http://www.tablesgenerator.com/)

<table>
    <tr>
        <th rowspan="3">我占了三行</th>
        <th>第一列</th>
        <th>第二列</th>
        <th>第三列</th>
    </tr>
    <tr>
        <td>第一列</td>
        <td>第二列</td>
        <td>第三列</td>
    </tr>
    <tr>
        <td>第一列</td>
        <td>第二列</td>
        <td>第三列</td>
    </tr>
</table> 

### 结论
- 使用普通Excel样式不需要特殊要求的，使用markdown语法编写表格
- 使用特殊，跨行跨列使用html语法

## 3. 使用内嵌HTML语言设置font

<font face="宋体">宋体</font>  
<font face="黑体" color=red>红色黑体</font>  
<font face="黑体" color=red size=7>7号红色黑体</font>

## 4. quote \>

> 第一级
>> 第二级
>>> 第三级


## 5. 其他编辑器

[windows下最好用的markdown编辑软件](http://www.360doc.com/content/17/0822/22/11678336_681351279.shtml)

# Hexo相关
## 1. `hexo n ".."`后设置password值
> 不能乱测试，不知为何，设置相关value之后更改无法实现  

- 将password删除，进入博文内容仍需password
- 更换为其他value值，网页仍使用原value值

**已解决，只需等待更新即可**

## 2. `can not read a block mapping entry`某个.md文档编译错误

![](https://i.imgur.com/Yf7KUtr.png)

**这种错误常见解决方法**  

- 在错误的地方重新输入，手打  
- **在：后面一定要有空格**  
- “：”要用英文格式


## 3. categories不显示链接，而tags正常
> 通过图片可看出categories没有链接，而其他正常


![](https://i.imgur.com/xL0Kpjz.png)

- 查看categories/index.md文件，有没有出现拼写错误或冒号后无空格现象


# 计算机相关

## 计算机备份

http://iknow.lenovo.com/detail/dc_177365.html 

## 计算机重装系统

http://iknow.lenovo.com/detail/dc_178940.html  

## 台式机硬盘如何接笔记本

https://product.pconline.com.cn/itbk/bjbzj/notebook/1707/9553145.html


## win10进入安全模式

开始->设置 -> 修复-> 高级启动中的立即重启 ->进入安全操作界面 -> 选择疑难解答-> 高级选项-> 启动设置-> 重启-> 4或F4启用安全模式

win+R ,输入msconfig,弹出的页面点击“引导” 安全引导 最小 应用 确定 重新启动

## 网络

https://blog.csdn.net/qq_36868342/article/details/82821595 UserAgent


## 下载使用应用程序

http://www.myzaker.com/article/5ba5790577ac640a26664694/

http://fulibus.net/proxyee.html

![](https://imgsa.baidu.com/exp/w=480/sign=a0e2efd98e025aafd3327fc3cbecab8d/267f9e2f070828386ec1750db499a9014d08f1df.jpg)

qBittorrent的功能

https://www.jianshu.com/p/85dd82370a20

### vscode
https://blog.csdn.net/rj_han/article/details/82801501


### Chrome 缓存更换磁盘

https://jingyan.baidu.com/article/3c343ff72345c20d3679635e.html

https://jingyan.baidu.com/article/1974b289afa4cdf4b1f774a8.html

https://blog.csdn.net/weixin_40364421/article/details/82769021

https://zhidao.baidu.com/question/745410413736661572.html

https://blog.csdn.net/lcmssd/article/details/30804843


## 卸载
### VC6.0
https://blog.csdn.net/sanqima/article/details/38513915

https://jingyan.baidu.com/article/cbcede0761124902f40b4d12.html

### 卸载McAfee
https://jingyan.baidu.com/article/ceb9fb10ab6db68cad2ba0b0.html

## 镜像MSDN

[各种系统镜像、工具下载汇总](https://msdn.itellyou.cn/)



# CTF相关
## main（web）方面
### 查看网页源代码

- **User error is common  用户错误很常见**  
**Source code can tell you a lot  源代码可以告诉你很多**
- **网页标签会欺骗你，只显示一点点内容，而后面的……会显示password**


## crypt方面
在线encode集锦  

https://blog.csdn.net/youzen_ing/article/details/73075180 



**Fun 的一道题
http://www.chiange.com/wechall-shadowlamb-chapter-i-fun/
**

2017.08.14这两天开始刷ctf的题目，首先看了i春秋上边的ctf入门视频，了解到很多刷题网站，分享如下： 
http://pwdme.cc/tag/idf%E5%AE%9E%E9%AA%8C%E5%AE%A4/ 
https://microcorruption.com/login 
http://smashthestack.org/ 
http://overthewire.org/wargames/ 
http://pwnable.kr/ 
http://prompt.ml/0 
https://ctftime.org/ 
https://www.xctf.org.cn/ 
https://www.wechall.net/challs 

解题思路：  
http://blog.chrstm.com/2017/05/11/WeChall/

https://delcoding.github.io/2017/11/wechall-write1/

# 算法

## 常用排序算法
http://www.cnblogs.com/eniac12/p/5329396.html




# 数据恢复还原

目前流行的数据恢复软件包括EasyRecovery、FinalData、Acronis Disk Director、PC Inspector File Recovery、RecoverNT、Recover4all等等。





# 虚拟机
## virtual box
https://blog.csdn.net/wl_627292578/article/details/17167821 
## VMware
https://blog.csdn.net/shanzhizi/article/details/8293638

https://www.cnblogs.com/yellowcool/p/8142839.html



##########壁纸
http://www.win4000.com/zt/daojianshenyubizhi.html