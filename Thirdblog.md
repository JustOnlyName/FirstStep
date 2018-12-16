#更新Github远程仓库内容

## 多人合作开发项目基本问题
> &emsp;我在上传FirstBlog时并没有什么不妥，因为刚开始Create repository时里面并没有什么内容，直接上传不会发生事故  
> &emsp;但上传SecondBlog时，出现错误

$ git push -u origin master  
To git@github.com:\*\*\*\*\*\*/Demo.git  
 ! [rejected] master -> master (non-fast-forward)  
error: failed to push some refs to 'git@github.com:******/Demo.git'  
hint: Updates were rejected because the tip of your current branch is behind  
hint: its remote counterpart. Merge the remote changes (e.g. 'git pull')  
hint: before pushing again.  
hint: See the 'Note about fast-forwards' in 'git push --help' for details.  

> 虽然听说有强制push的方法，也查到具体操作步骤，但一般不使用这种方法，找了找相关解释出现这种状况的原因

![](https://i.imgur.com/MqTjAHZ.png)

- 这是本地仓库与Github repository冲突导致，可以用git log看每一次该文件的版本，因为一些文件版本不同，而用git status查看到的更新信息并不包含其他人做出来的内容  
- A B两个人共同开发一个项目,都向test repository中commit、push,A向test push 1.txt

![](https://i.imgur.com/S6k0QaM.png)

- 而B完成新文件2.txt，直接提交会与远程仓库出现冲突。

![](https://i.imgur.com/YH5Qpjm.png)


### **解决方法**

#### 1. 使用强制push方法

- `$ git push -u origin master -f`  
这样会使远程修改丢失，一般是不可取的，尤其是多人协作开发的时候。

#### 2. push前先将远程repository修改pull下来
> 所有想upload到Github中的文档，都到了本地仓库中时

- `$ git pull origin master`
- `$ git push -u origin master`

#### 3. 创建新分支，放到新分支中

> 几个人合作用开发项目时，代码保存到GitHub上，我们不在原有代码上直接修改调试，这时就要创建一个新的分支，在分支上改自己的代码，修改完成后，把分支上修改的代码合并到主分支master上就好了。这个过程需要经过以下几个步骤：

1. 创建一个分支test  
　　git branch test

2. 查看分支创建是否成功，下面的命令可以得到现在仓库中的分支列表  
　　git branch  
![](https://i.imgur.com/4t4Jbbt.png)  
&emsp;&emsp;git branch -D ...//删除分支

3. master分支是仓库默认的主分支，把工作从master分支下切换到test分支下  
　　git checkout test

4. 内容修改完成后，通过下面命令把内容提交给test分支下  
　　git add -a  
　　git push -u origin test

5. 再把工作从test分支下切换到master下  
　　git checkout master

6. 因为是合作开发项目，这时远程仓库中的内容有可能已经发生了变化，所以我们需要将远程仓库中的内容和本地分支中的内容进行合并  
　　git pull origin master

7. 接下来要做的是将test分支合并到master上  
　　git merge test

8. 查看分支中内容提交的状态  
　　git status

9. 最后一步，我们把修改的内容提交到主分支上  
　　git push origin master  
如果你感觉合并后的内容有问题，你可以通过撤销合并恢复到以前状态。  
　　git reset --hard HEAD  
代码已经提交，撤销的方法是  
　　git reset --hard ORIG_HEAD


---------- 



参考文档：  
https://www.cnblogs.com/code-changeworld/p/4779145.html   
http://www.cnblogs.com/leilei0327/p/8688244.html




