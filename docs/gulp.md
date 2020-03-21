---
title: gulp
tag: Gulp
date: 2017-08-16
---

![](https://github.com/RoyJia/mdimgs/raw/master/res/gulp-logo.png)

前言
---

今天碰到一个问题，在build项目，跑gulpjs的时候出现了问题，gulp的一个task（check-complexity）失败了。一直无法定位问题所在，所以来研究一下gulpjs到底是个什么鬼。
希望经过一番研究之后能够找到解决办法。

<!-- More -->

> Question：gulp是什么鬼东西？作用是什么？

-   是一个压缩文件（将多个文件-css/js压缩到一个文件中）的工具吗？不是，或者说压缩多文件是它的功能中的一种。有了，是一种自动化的工具。
-   gulp能作什么 - 对项目中的js/less/sass/html/css…进行测试、检查、合并、压缩、格式化、部署和监听。说白了就是对文件(js,sass,less…)写入内存，进行任务处理，再写出到磁盘。

![](https://github.com/RoyJia/mdimgs/raw/master/res/gulp-stream.png)

### gulp API

```bash
    gulp.src：获取文件
    gulp.dest：写入文件
    gulp.tasks：注册任务
    gulp.watch：监控文件的改动
```

### 核心配置文件 - gulpfile.js

示例代码：

```js
    gulp.task('min-css',function(){
        gulp.src('./src/css/*.css')
          .pipe(gulp_concat("index.min.css"))
          .pipe(minify_css())
          .pipe(gulp.dest('./dist/css'));
    });
```

Reference Link
---

-   [https://segmentfault.com/a/1190000003003847](https://segmentfault.com/a/1190000003003847)
-   [https://segmentfault.com/a/1190000006873386](https://segmentfault.com/a/1190000006873386)
-   gulp官方网址：[http://gulpjs.com](http://gulpjs.com)
-   gulp插件地址：[http://gulpjs.com/plugins](http://gulpjs.com/plugins)
-   gulp 官方API：[https://github.com/gulpjs/gulp/blob/master/docs/API.md](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
-   gulp 中文API：[http://www.ydcss.com/archives/424](http://www.ydcss.com/archives/424)