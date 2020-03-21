---
title: The Part of Web Server
tag: Web Server
date: 2017-08-16
---

> **Apache/Nginx/IIS —\> Jetty/Tomcat/GlassFish/Weblogic/JBoss/WebSphere**

### HTTP Server

![](https://github.com/RoyJia/mdimgs/raw/master/res/HTTP-Request-Response.png)

**HTTP Server**(Apache/Nginx)本质上也是一种应用程序，通常安装运行在服务器上。其作用是绑定服务器的IP，监听某个TCP端口来接受并处理HTTP请求。这就是客户端通过HTTP协议获取服务器上网页（HTML/CSS/JS…）、文档（PDF/TXT…）、音频（MP3/MP4…）、视屏（MOV/RMVB/MKV/AVI…）等等资源的原理。
Apache HTTP Server和Nginx常用作静态内容服务和代理服务，本身不支持动态生成内容，擅长将静态资源直接传送到客户端。也就是说HTTP Server的Response部分是静态资源。但是都有插件支持动态编程语言处理。但是，Nginx的IO模型比Apache更适合跑代理，所以Nginx一般作为前端缓冲代理。

<!-- More -->

> Question：那么Nginx的反向代理和负载均衡是什么鬼概念？

-   反向代理 - [https://my.oschina.net/yoyoko/blog/147414](https://my.oschina.net/yoyoko/blog/147414)
-   负载均衡 - [http://blog.csdn.net/u014686399/article/details/71156342](http://blog.csdn.net/u014686399/article/details/71156342)

### Application Server - Web Container

![](https://github.com/RoyJia/mdimgs/raw/master/res/Tomcat-Request-Response.png)

Application Server(Tomcat/JBoss/Jetty) - Servlet/JSP应用的容器
Tomcat运行在JVM上，作用和HTTP Server一样，绑定IP并监听TCP端口，但同时还有额外的职责：

-   管理Servlet程序的生命周期
-   讲URL映射到指定的Servlet进行处理
-   动态生成内容，响应客户端（Servelt动态生成静态内容，并传送至客户端）

> Question：通常听到说Tomcat配合Nginx一起使用，他们用在一起做什么了？

-   动静态资源分离 - 运用Nginx反向代理功能分发请求：讲动态资源的请求交给Tomcat，静态资源请求交由Nginx处理。降低Tomcat处理动态内容的压力
-   负载均衡 - 当业务压力增大到一个Tomcat实力不足以处理时，可以启动多个Tomcat进行水平扩展。Nginx的负载均衡功能可以把请求通过算法分发到各个不同的实例进行处理

Reference Link
---

-   Nginx配置实例 - [http://blog.csdn.net/hiyun9/article/details/51602428](http://blog.csdn.net/hiyun9/article/details/51602428)