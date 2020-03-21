---
title: Canvas plus SVG
tag: Canvas, SVG
date: 2018-06-02
---

### Overview

目前正在开发一个应用，目的是要制作一个图形界面，在屏幕上显示整个办公区的工位图，并实现通过搜索定位员工、Team。

起初一开始就打算使用SVG实现整个图形界面。同时也知道Canvas，以为这两个东西要结合起来才能实现一些动态的效果。

但是等了解了SVG和Canvas的概念之后，再做一个对比，才发现并不需要Canvas。

<!-- More -->

### SVG

SVG是一种使用XML节点描述2D图形的语言。SVG基于XML，就像HTML其他的元素一样，可以为每个SVG DOM添加JS事件。

在SVG中，每个被绘制的图形均被视为对象。当对象的属性发生改变，则浏览器能够自动重新渲染图形。

### Canvas

Canvas通过JavaScript绘制2D图形。Canvas只提供一个图形容器，即在html文件中使用`<canvas>`元素，绘制图形，通过JavaScript实现，渲染图形通过加载JavaScript代码实现。

### SVG vs Canvas

从目前的了解得出，Canvas适合网页游戏的制作，将大量复杂的图形以及动画逻辑通过书写JavaScript代码实现，考虑如果使用SVG进行游戏开发，势必会创造大量的DOM节点，这对追求流畅性的游戏开发来说是不可选的。

> Canvas
>
> -   依赖分辨率
> -   不支持事件处理器
> -   弱的文本渲染能力
> -   能够以 .png 或 .jpg 格式保存结果图像
> -   最适合图像密集型的游戏，其中的许多对象会被频繁重绘

> SVG
>
> -   不依赖分辨率
> -   支持事件处理器
> -   最适合带有大型渲染区域的应用程序（比如谷歌地图）
> -   复杂度高会减慢渲染速度（任何过度使用 DOM 的应用都不快）
> -   不适合游戏应用

Reference Links
---

[https://github.com/bxm0927/canvas-special](https://github.com/bxm0927/canvas-special)