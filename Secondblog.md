# hexo博客搭建

> 欣赏了一些其他人的博客，并不是简单的仓库，遂由网上查找关于hexo搭建github博客的文档

- Hexo官方：https://hexo.io/ 
- Hexo官方(中文)：https://hexo.io/zh-cn/ 

#### hexo简介

Hexo类似于一个个人网站，搭建出来的效果如同csdn、cnblog那样的界面，其拥有高效的博客搭建框架，将博客内网页完美渲染。

![](https://i.imgur.com/9p1LvwD.png)

#### hexo是需要用npm命令，即需要下载安装node.js工具

- Node.js官方网站：https://nodejs.org/en/ 
- Node.js官方文档：https://nodejs.org/en/docs/ 

![](https://i.imgur.com/UNVcYq4.png)

点击安装，next、next就行

#### 1. 安装Hexo

- `npm install hexo-cli -g` //使用该命令，在node.exe中进行，也可以在Git bash Here中进行

![](https://i.imgur.com/k02GfNZ.png)

#### 2. 创建blog文件夹
> 用于之后搭建网站

- 在本地创建wblog文件夹，进入文件夹，打开Git Bash
- 初始化一个hexo blog网站`hexo init`

#### 3. 运行

- `npm install`
- `hexo server`

#### 4. 测试网页

> 打开网址，http://localhost:4000/就可以看到创建的blog

![](https://i.imgur.com/x9RpLHe.png)

- 这里创建的blog只是在本地，并没有部署到Github上

#### 5. 修改_config.yml配置文件

![](https://i.imgur.com/kw3SxKR.png)

- 在最后添加
- git 
- repo: git@github.com:用户名/用户名.github.io.git
- branch: master

![](https://i.imgur.com/vBsWUcr.png)

#### 6. 安装部署使用的插件

- `npm install hexo-deployer-git -save`//

![](https://i.imgur.com/Vd17UWC.png)

#### 7. 生成网站
> 该网站是要部署到github上的，因为github pages支持静态页面的解析，而Hexo 是用来生成 HTML，所以我们在部署网站前要先生成静态网站

- `hexo generate`//可简写为`hexo g`

#### 8. 进行自动部署网站
> 注意部署前需要重新生成网站, 每一次修改后都需要重新生成网站并进行部署，

- `hexo deploy`简写为`hexo d`

> 此处生成网站、网站部署操作可以一步进行  
> 在进行完博客编写更新之后，进行部署，`hexo g -d`


#### 9. 网址输入个人博客ip地址检查
> 这里对我的脑子有点无语了，JustOnlyName.github.io仓库中还只放了一个README.md文件，以为进行完这些操作之后就能想https://localhost:4000/一样的界面，这里没有放除README.md外的文件，就只会出现README.md里的内容

**上述错误**
进行完操作之后需要等待几分钟，这里需要时间上传，之后就能出现想要的界面，而JustOnlyName.github.io仓库中也出现上传的文件

![](https://i.imgur.com/NmIF0ge.png)


----------

### 补充
1.
 
	不清楚原因，用校园网制作该Hexo、github博客命令使用后的流程一切正常，但使用宿舍网制作了一次，http://localhost:4000/无法测试，删除仓库重新制作，用手机流量进行，卡到了另一个流程，初步推测应该是网络连接无法maintain的问题

2.

	一般认为github是用来托管项目源码，其用来展示称为博客样式是使用的github的pages服务。其实每个github仓库都可以通过setting来用项目的index.html为入口展示项目。

例如：

我之前的仓库FirstStep

![](https://i.imgur.com/4Kuq0Kk.png)

![](https://i.imgur.com/mNC0dJk.png)

- 将none改为有项目展示入口index.html那一级

之后会出现`Your site is published at https://.......`


----------

参考文档：  
https://blog.csdn.net/u013162035/article/details/80718576  
https://juejin.im/post/598eeaff5188257d592e55bb  
