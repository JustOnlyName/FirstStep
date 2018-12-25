# 更新博客搭建

> &emsp;作为一名在hexo方面赤果果的新手，我在博文写作方面遇到了很多问题，故特意将这些错误及其解决方案记录下来，以便日后查证之用，同时，也可给各位在遇到类似问题时提供一点参考。俗话说的好，好记性不如烂键盘^.^


## Theme—Next

> &emsp;这个主题会有两个不是一个路径下的config文件需要更改，一个是在hexo的blog的root目录下，一个是在之后下载来的theme相关路径下的config文件  
>> 1. 第一个是在站点根目录下，其中包含Hexo的配置
>> 2. 第二个是在主题根目录下，由NexT提供并包含主题的配置

### 1. 下载NextTheme
> 进入hexo的blog文件夹

- `git clone https://github.com/theme-next/hexo-theme-next themes/next`  
- 此处可以不用clone，可以直接进入网址下载文件，再复制粘贴到指定文件夹下（个人感觉这样速度快一些）


### 2. 更改config文件
- Ctrl+F查找theme，enable:true  
- theme的大的外观时由scheme控制，可更换其他样式

### 3. 测试效果

![](https://i.imgur.com/rEaT84T.png)

这样就已经安装并使用了next主题，但并没有想其他人的网站博客那样的个性化，接下来进行一下更多设置。

----------

### 发布一篇新文章

首先Ctrl+C停止当前的本地服务，然后  

- hexo n "我的第一篇文章Test"  
这样就会在博客目录下source\_posts中生成相应的“Test.md”文件，之后编辑markdown文件就行

![](https://i.imgur.com/WFBbcsH.png)

至于为何会出现一个Test文件夹，里面目前还是空的，无法判断用处，之后再了解（注意事项[4](#4)

----------


## 美化主题
### 1. 添加Fork me on Github
点击[这里](https://blog.github.com/2008-12-19-github-ribbons/)或者[这里](http://tholman.com/github-corners/)挑选自己喜欢的样式，并复制代码。

复制样式的代码，放在`themes/next/layout/_layout.swig`文件中(放在`<div class="headband"></div>`的下面)，并把href改为你的github地址  
**如图**  
![](https://i.imgur.com/Uwt6wgf.png)  

效果  
![](https://i.imgur.com/ry0ZNvp.png)

### 2. 在每篇文章末尾添加「致谢」
> 1. 在路径`\themes\next\layout\_macro`中新建 `passage-end-tag.swig` 文件,并添加以下内容：

	<div>
    	{% if not is_index %}
        	<div style="text-align:center;color: #ccc;font-size:14px;">-------------　　　　本文结束　<i class="fa fa-heart"></i>　感谢您的阅读　　　　-------------</div>
    	{% endif %}
	</div>

> &ensp;2. 在post.swig文件中，`post-footer` 之前添加代码


    <div>
      {% if not is_index %}
    	{% include 'passage-end-tag.swig' %}
      {% endif %}
    </div>


> &ensp;3. 在theme配置文件中启用`passage_end_tag`  

![](https://i.imgur.com/q3DDYP8.png)
### 3. 网站底部字数统计
> 1. 博客根目录下`$ npm install hexo-wordcount --save`  

> 2. `/themes/next/layout/_partials/footer.swig`添加（位置可以换，调试调试就知道）

    <div class="theme-info">
      <div class="powered-by"></div>
      <span class="post-count">博客全站共{{ totalcount(site) }}字</span>
    </div>

**也可以不需要设置这么多项目**  
**只安装插件，在`theme/_comfig.yml`中更改设置即可**  
![](https://i.imgur.com/22eVZnT.png)


### 4. 文章加密访问
#### 设置加密
> 1. 打开`themes->next->layout->_partials->head.swig`文件，在以下位置插入这样一段代码

![](https://i.imgur.com/vFpoL94.png)
> 代码如下

	<script>
	    (function () {
	        if ('{{ page.password }}') {
	            if (prompt('请输入文章密码') !== '{{ page.password }}') {
	                alert('密码错误！');
	                if (history.length === 1) {
	                    location.replace("https://...."); // 这里替换成你的首页
	                } else {
	                    history.back();
	                }
	            }
	        }
	    })();
	</script>

> &ensp;2. 在需要加密的文档中添加password关键字，并设置value  
![](https://i.imgur.com/KVftbfl.png)

#### `read more`控制文章内容显示--博文显示缩略

![](https://i.imgur.com/pYlBXJd.png)

> **只需在写的文档中添加`<!--more-->`即可在该断点处显示**  

![](https://i.imgur.com/5ptc9i6.png)



### 5. 更改标签图标

![](https://i.imgur.com/82710ft.png)

> 感觉这个#不太美观，修改：

> `/themes/next/layout/_macro/post.swig`，搜索`rel="tag">#`，将` # `换成`<i class="fa fa-tag"></i>`![](https://i.imgur.com/YGTucDi.png)



### 6. 添加动态小live

抛一个[链接](https://github.com/EYHN/hexo-helper-live2d/blob/master/README.zh-CN.md)，按照链接操作吧。（默认好像就是我现在界面的样子，目前没学会换图标）

### 设置博文置顶
> 个人觉得没什么必要（目前），所以就不进行设置

## Hexo重装与位置移动

> &emsp;最近想要将笔记本重新更新一下，把所有文件都删掉再重装，这也就可能出现我没有想到的问题，所以就先查找一下重装之后的blog在本地笔记本上的新设置之类的内容

### 1. 重装
> &emsp;安装基本配置应用程序，Git，Node.js,Hexo  
> &emsp;`hexo init`→`npm install hexo-deployer-git -save`(类似初始化创建blog一样)
> &emsp;更改站点配置文件最后的几项内容，之后只需要修改主题，美化之类的即可  
##### **注意**  
如果需要原博文内容，可以先复制原博文内容，再重装，将博文内容粘贴到_post文件夹内（目前没实际操作过，应该如此）

### 2. 位置移动
只要将Hexo环境配置好之后，将原本地blog文件夹整个复制，然后放到一个新文件夹路径下即可（安装新系统之前先复制一份）

----------

## 个人遇到的需要**注意**的事情
#### 1. 有时美化后无法显示  
> &emsp;个人一般只在`/localhost:4000/`中调试，`$ hexo s --debug`，小的改动可以通过刷新显示，但大的改动（比如美化主题）刷新有可能无法显示，可以先生成`$ hexo g`再`$ hexo s --debug`

#### 2. 安装插件时出bug


![](https://i.imgur.com/pfaqOZy.png)

解决及解释：https://docs.npmjs.com/cli/audit  

- `npm audit fix`：修复所安装插件遇到的漏洞  
- `npm audit`：查看还有什么漏洞未解决
#### 3. error deployer not found:git 的报错
在`hexo d`时出现 

这是因为 hexo 3.0 不适配 hexo 2.0 的bug

执行: `npm install hexo-deployer-git --save` 即可

#### <span id="4">4. </span>Hexo图片显示问题
> 1. 使用Markdown应用程序upload图片功能不会出现问题  
> 2. 使用之前说到的`hexo n "Test"`生成.md时，同时生成的一个/Source/_post/Test文件夹

- 按照upload图片格式`![这里输入图片描述]( Test/图片名.jpg)`

还是markdown程序自带upload图片功能方便

----------


参考文档：  
http://theme-next.iissnan.com/getting-started.html  

Next成品界面：ouxiaolong.github.io  

Next美化：http://shenzekun.cn/hexo%E7%9A%84next%E4%B8%BB%E9%  A2%98%E4%B8%AA%E6%80%A7%E5%8C%96%E9%85%8D%E7%BD%  AE%E6%95%99%E7%A8%8B.html  



https://huaji8.top/  随鼠标移动live


http://www.runoob.com/w3cnote/best-python-ide-for-developers.html 推荐10款Python IDE








https://ouxiaolong.github.io/page/2/图片显示问题