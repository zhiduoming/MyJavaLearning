# Git 面试与实战基础

## Git 是什么？

Git 是一个版本控制工具。

它主要解决的问题是：

```text
我改了哪些文件？
我什么时候改的？
我能不能回到之前版本？
多人同时改代码怎么合并？
一个功能能不能单独开发，不影响主分支？
```

可以把 Git 理解成给项目建立一条时间线，每一次 commit 就是一个存档点。

比如：

```text
commit 1：初始化项目
commit 2：完成登录功能
commit 3：接入 Redis 验证码
commit 4：修复评价发布 bug
```

每个 commit 都会记录：

```text
改了哪些文件
改了哪些内容
是谁改的
什么时候改的
提交说明是什么
```



## Git 和 GitHub 的区别

Git 是版本控制工具，主要运行在本地。

GitHub 是代码托管平台，用来保存远程仓库，也方便团队协作、代码审查、创建 PR、运行 CI 等。

关系可以理解为：

```text
本地仓库  --push-->  远程仓库 GitHub
本地仓库  <--pull--  远程仓库 GitHub
```

本地写代码、提交 commit，然后通过 push 推送到 GitHub。



## Git 的四个区域

Git 常见的几个区域：

```text
工作区 working tree：正在编辑的文件
暂存区 staging area：下一次 commit 准备提交的内容
本地仓库 local repository：电脑上的 commit 历史
远程仓库 remote repository：GitHub 上的仓库
```

一次完整提交流程：

```text
修改文件
-> git add
-> git commit
-> git push
```

可以理解为：

```text
改文件：写草稿
git add：选中这次要提交的内容
git commit：正式保存一个本地版本
git push：上传到 GitHub
```



## 个人开发常用命令

查看当前状态：

```bash
git status
```

查看具体改动：

```bash
git diff
```

添加指定文件到暂存区：

```bash
git add 文件名
```

添加全部改动到暂存区：

```bash
git add .
```

提交到本地仓库：

```bash
git commit -m "提交说明"
```

推送到远程仓库：

```bash
git push
```

拉取远程最新代码并合并到当前分支：

```bash
git pull
```

查看提交历史：

```bash
git log --oneline
```

个人开发闭环：

```text
修改文件
-> git status 看状态
-> git diff 看改了什么
-> git add 放入暂存区
-> git commit 生成本地提交
-> git push 推到远程
```



## origin 是什么？

origin 是远程仓库的默认名字。

比如本地仓库连接了 GitHub，Git 通常会给这个远程仓库起一个默认别名：

```text
origin
```

查看远程仓库：

```bash
git remote -v
```

可能看到：

```text
origin  https://github.com/xxx/xxx.git (fetch)
origin  https://github.com/xxx/xxx.git (push)
```

所以：

```bash
git fetch origin
```

意思是：去名叫 origin 的远程仓库获取最新分支和提交信息。



## fetch 和 pull 的区别

核心区别：

```text
git fetch：只把远程仓库的最新信息拿回来，不改当前分支代码
git pull：把远程最新代码拿回来，并合并到当前分支
```

可以记成：

```text
fetch = 看看远程有什么变化
pull = 把远程变化拉下来并合进当前分支
```

`git pull` 本质上约等于：

```bash
git fetch
git merge
```

比如在 main 分支执行：

```bash
git pull
```

通常等价于：

```bash
git fetch origin
git merge origin/main
```

也就是先获取远程 main 的最新信息，再合并到本地当前 main 分支。



## 什么时候用 pull，什么时候用 fetch？

### 从最新 main 创建新分支

如果要从最新 main 开一个功能分支，应该先更新 main：

```bash
git switch main
git pull
git switch -c feature/xxx
```

这里用 pull 合理，因为目的就是把本地 main 更新到远程最新状态。



### 查看远程有什么新分支

如果只是想看看远程仓库有哪些新分支，不想改变当前代码：

```bash
git fetch origin
git branch -r
```



### 审查别人 PR 分支

如果要把别人 PR 对应的远程分支拉到本地测试：

```bash
git fetch origin
git switch -c feature/review-validation origin/feature/review-validation
```

这表示：先获取远程分支信息，再基于远程分支 `origin/feature/review-validation` 创建本地分支 `feature/review-validation` 并切换过去。



## branch 分支是什么？

分支是一条独立开发线。

主分支一般叫：

```text
main
```

开发新功能时，不建议直接在 main 上改，可以新建一个功能分支：

```text
feature/redis-cache
```

这样 main 继续保持稳定，新功能在 feature 分支上开发，开发完成后再合并回 main。

查看分支：

```bash
git branch
```

切换到 main：

```bash
git switch main
```

创建并切换到新分支：

```bash
git switch -c feature/redis-cache
```

切换到已有分支：

```bash
git switch feature/redis-cache
```

把某个分支合并到当前分支：

```bash
git merge feature/redis-cache
```



## 如何从 main 拉取一个新分支？

标准流程：

```bash
git switch main
git pull
git switch -c feature/xxx
```

解释：

```text
git switch main：切到 main 分支
git pull：把远程 main 的最新代码合并到本地 main
git switch -c feature/xxx：基于当前 main 创建新分支并切过去
```

第一次把新分支推送到 GitHub：

```bash
git push -u origin feature/xxx
```

以后在这个分支上继续提交，可以直接：

```bash
git push
```



## PR 是什么？

PR 全称是 Pull Request，中文一般叫拉取请求、合并请求、代码合并申请。

可以理解为：

```text
我在一个功能分支上完成了开发，现在请求把这个分支合并到 main 分支。
```

比如：

```text
main：稳定主分支
feature/redis-cache：开发 Redis 缓存的分支
```

创建 PR：

```text
base: main
compare: feature/redis-cache
```

意思是：

```text
请求把 feature/redis-cache 合并到 main
```

PR 里一般可以查看：

```text
Conversation：讨论区
Commits：提交记录
Checks：自动化测试结果
Files changed：具体改了哪些代码
```

PR 的本质是一次正式的代码合并申请。



## 为什么要有 PR？

团队开发中不能每个人都直接往 main 上推代码。

如果没有 PR：

```text
坏代码可能直接进入主分支
别人可能立刻拉到有问题的代码
部署时也可能把问题带到线上
代码没有 review 阶段
```

有 PR 之后：

```text
创建分支
-> 写代码
-> 提交 commit
-> push 到 GitHub
-> 创建 PR
-> code review
-> 跑测试
-> merge 到 main
```

PR 的价值是：让代码在进入主分支前先经过审查和测试。



## PR 还没合并，如何测试？

PR 还没合并，但它背后对应的是一个远程分支。

审查人员可以把这个远程分支拉到本地测试：

```bash
git fetch origin
git switch -c feature/review-validation origin/feature/review-validation
mvn test
mvn spring-boot:run
```

逐行解释：

```text
git fetch origin：
从 GitHub 获取最新的远程分支和提交信息，不改变当前代码。

git switch -c feature/review-validation origin/feature/review-validation：
基于远程 PR 分支创建一个本地分支，并切换过去。

mvn test：
运行项目测试。

mvn spring-boot:run：
启动 Spring Boot 项目，手动验证功能。
```

如果要测试合并到 main 后的效果，也可以本地模拟合并：

```bash
git switch main
git pull
git switch -c test/pr-review-validation
git merge origin/feature/review-validation
```

这时本地的 `test/pr-review-validation` 分支就相当于：

```text
main + PR 改动
```

然后可以在这个临时分支上运行测试。

企业里更常见的是 CI 自动测试，比如 GitHub Actions、GitLab CI、Jenkins。PR 创建后，CI 会自动拉取 PR 分支代码，执行编译、单元测试、代码格式检查等。



## 一个完整企业协作流程

假设要修复登录 bug。

先从 main 创建分支：

```bash
git switch main
git pull
git switch -c fix/login-bug
```

修改代码后：

```bash
git status
git diff
git add .
git commit -m "修复登录失败提示问题"
git push -u origin fix/login-bug
```

然后去 GitHub 创建 PR：

```text
base: main
compare: fix/login-bug
```

PR 标题：

```text
修复登录失败提示问题
```

PR 描述可以写：

```text
本次修改：
1. 统一登录失败提示
2. 避免暴露账号是否存在
3. 补充相关异常处理
```

然后等待 review 和测试。确认没问题后，再 merge 到 main。



## 冲突是什么？

冲突一般是两个分支修改了同一个文件的同一部分，Git 不知道该保留哪一份，就需要人工解决。

冲突文件中通常会出现：

```text
<<<<<<< HEAD
当前分支的代码
=======
要合并进来的代码
>>>>>>> feature/xxx
```

解决流程：

```text
1. 打开冲突文件
2. 找到 <<<<<<<、=======、>>>>>>> 标记
3. 手动选择保留哪些代码
4. 删除冲突标记
5. git add
6. git commit
```

面试说法：

> 冲突一般是多个分支修改了同一文件的同一部分导致的。解决时先打开冲突文件，查看 Git 标记的冲突区域，手动选择保留哪些代码，删除冲突标记，然后重新 add、commit，完成合并。



## 撤销和临时保存

放弃工作区某个文件的修改：

```bash
git restore 文件名
```

把文件从暂存区撤回来，但保留工作区修改：

```bash
git restore --staged 文件名
```

临时保存当前未提交改动：

```bash
git stash
```

恢复刚刚临时保存的改动：

```bash
git stash pop
```

注意：`git reset --hard` 会丢弃改动，风险较高，初学阶段不要乱用。



## 面试常见问题

### 你平时怎么用 Git？

我平时会用 Git 管理项目版本。开发时先用 `git status` 查看当前修改，再用 `git diff` 查看具体改动，确认没问题后用 `git add`、`git commit` 提交到本地仓库，最后用 `git push` 推送到 GitHub。

更规范的流程是从 main 分支拉功能分支开发，完成后 push 到远程分支，再通过 PR 合并到 main。



### git pull 和 git fetch 区别？

`git fetch` 只是从远程仓库获取最新分支和提交信息，不会修改当前分支代码。

`git pull` 相当于 fetch 后再 merge，会把远程代码合并到当前分支。

简单来说：

```text
fetch = 只更新远程信息，不动当前代码
pull = 拉取远程更新并合并到当前分支
```



### PR 是什么？

PR 是 Pull Request，也就是代码合并请求。

一般在功能分支开发完成后，push 到远程仓库，然后创建 PR 请求合并到 main。PR 可以查看代码 diff、commit 记录、运行 CI、做 code review，确认没问题后再 merge。



### 如何解决冲突？

冲突一般是多个分支修改了同一文件的同一部分。

解决时先打开冲突文件，查看 Git 标记的冲突区域，手动选择保留哪些代码，删除冲突标记，然后重新 add、commit，完成合并。



### git merge 和 rebase 区别？

merge 会生成一次合并提交，保留分支历史。

rebase 会把当前分支的提交重新应用到目标分支后面，让提交历史更线性。

实习阶段主要掌握 merge 即可，rebase 先了解概念，不要在不熟悉时乱用。



## 当前阶段需要掌握到什么程度？

达到下面程度就够支撑实习面试和日常使用：

```text
知道 add / commit / push / pull
知道 branch / switch / merge
知道 fetch 和 pull 区别
知道 PR 是什么
知道如何解决冲突的大致流程
知道 GitHub 上 PR 页面看什么
```

暂时不需要深入：

```text
rebase 复杂用法
reset --hard
cherry-pick
bisect
submodule
Git hooks
CI/CD 配置
```

Git 当前主线：

```text
个人版本管理：add -> commit -> push
团队协作开发：branch -> commit -> push -> PR -> review -> merge
```
