# FirstBlog
### Create Github repository
> 在网页github上创建project

![](https://i.imgur.com/BIutuUV.png)


#### Create loacl repository
> 本地仓库

- 需要**下载安装Git**客户端 链接：[https://git-scm.com/](https://git-scm.com/)，安装后右键出现

![](https://i.imgur.com/0FOJY4A.png)

（后续操作可以在Git Bash Here中进行，也可以在cmd中进行）


- **配置**身份信息：
> 1. `git config –global user.name “username”`
> 2. `git config –global user.email “useremail”`
> 3. //此处的username和useremail分别是Github账号的用户名和绑定邮箱

- 操作完成之后检查配置完成内容

    git config -l
显示配置信息列表

![](https://i.imgur.com/l2C0UGc.png)

- 本地分支,到一个本地文件夹目录创建一个项目

> 初始化项目
    git init

- 与远程仓库相关联
`git remote add origin https://github.com/JustOnlyName/FirstStep.git`
//链接是这个项目刚开始创建时出现的链接

 这里的origin后续操作要用到，对后面的链接取个名字，可以指定一个简单的名字,以便将来引用,运行


- 开发
- 检查modify文件

    git status
    
![](https://i.imgur.com/PyRrE3K.png)

//这里略微有些不符，显示更改这些操作
- 使这些文件生效

> 1. `git add *` //这个*是文件名作为参数，可以是具体的文件或目录
> 2. `git commit -m 'commit_test'`//这个-m里面的参数是注释
> 
> //这里并没有推送到github远程仓库中，只是在本地的一个暂存区中

- 推送到github上

    `git push -u origin master`
//master是branch分支，可以创建新分支，默认分支为master

> 本地仓库创建时一个文件夹对应一个project，一般不要把本地仓库A放到本地仓库B的路径下

![](https://i.imgur.com/OauYl1q.png)

这时在远程仓库中

![](https://i.imgur.com/OXM3ZxU.png)

会出现newporject，但无法打开，并不是文件路径

这时需要删除远程仓库文件

对一个project，一般可以在远程仓库进行操作的有：

-  create new file
-  setting--delete repository（删除仓库）

所以只能通过命令来解决

git pull origin master                    # 将远程仓库里面的项目拉下来

dir                                                # 查看有哪些文件夹

git rm -r --cached newproject              # 删除newproject文件夹

git commit -m '删除了newproject'        # 提交,添加操作说明

-----------

创建新分支
- 创建dev分支，然后切换到dev分支上

git checkout -b newbranch
![](https://i.imgur.com/wsRsLGQ.png)

git branch newbranch(分步，创建）

git checkout newbranch（切换）


----------
MarkDownPad2使用

Github基本使用文档为.md文件，使用markdown编辑器
![](https://i.imgur.com/WKSSb6L.png)
出现错误，强制输入，进入帮助界面
![](https://i.imgur.com/myUTSnv.png)
按照提示下载安装这两个应用程序

![](https://i.imgur.com/53zVN2l.png)
正常使用



参考文档：
https://www.cnblogs.com/wuer888/p/7656219.html

https://blog.csdn.net/wudinaniya/article/details/77508229

https://blog.csdn.net/u013162035/article/details/78476880

