---
title: Getting the pixel width/height of text on a web page
tag: SVG
date: 2018-06-18
---

Overview
---

> 为什么我需要关注这个问题？JavaScript 如何获得一段文本的像素宽度和高度（pixel width/height）

将一段文本显示在一个矩形框的正中间。对没错，就是这样一个简单的需求。

但是考虑到矩形框是 SVG 的子标签 rect，文本是 SVG 的子标签 text。我知道的是，SVG 中的所有元素，是按照从前到后的顺序依次加载渲染的，且每个元素的位置由指定的坐标决定的。
而且 SVG 中各个子元素的坐标都是基于 SVG 标签左上角的原点坐标`(0, 0)`。再加之整个代码环境基于 React。所以我的目的是让 text 基于一个 rect 的坐标，将其定位在 rect 中间的位置。

```js
    textWidth + wPadding * 2 = rectWidth
    textHeight + hPadding * 2 = reactHeight

    rect_x + wPadding = text_x
    rect_y + hPadding + textHeight = text_y

    text_x / text_y                   3
      wPadding / hPadding             2
        textWidth / textHeight        1
```

根据以上公式，我必须先获取到 text 的宽度和高度（单位：像素）

<!-- More -->

DOM元素对象表示size的属性
---

### element.style.width / element.style.height

理论上可以通过`element.style.width / element.style.height`获得，但是因为 style 的width 和 height 默认值都是 0，除非在元素中明确设置，比如下面的代码`element.style.width`的值才是 100px

    <div class="test" style="width:100px"></div>

### element attributes offsetWidth / offsetHeight or scrollWidth / scrollHeight or clientWidth / clientHeight

`offsetWidth / offsetHeight` **用来计算元素的物理空间**。该空间的内容包括 border 和 padding，其实还包括滚动条的宽度的，但大多数时候滚动条是计算到 padding 或者 content 中的。

![](https://github.com/RoyJia/mdimgs/raw/master/res/computed-element.jpg)

`scrollWidth / scrollHeight` **用来计算可滚动容器的大小，包括不可见的部分**。比如一个 *300\\*300*的 div 容器放入一个*600\*600\* 的图片，此时 scrollHeight 为 600，当然，scrollHeight 的值是加了 padding 的。

`clientWidth / clientHeight` 表示可视区域，包含 content 和 padding。如果存在滚动条，还要减去滚动条的宽度。

> 那么想通过 JS 获取元素的尺寸，通过上述 element 对象的一些表示尺寸的属性就可以实现

[](#获取SVG子元素的的尺寸 "获取SVG子元素的的尺寸")获取SVG子元素的的尺寸
---------------------------------------------------------------------------

理论上 SVG 及其子元素都是 HTML 标签元素，可以通过上述 element 对象的尺寸对象获得 SVG 及其子元素尺寸，但是，经过测试之后，SVG 及其子元素对象的上述属性的值都是 0。

既然 HTML 普通元素对象的属性无法获取 SVG 元素的尺寸，那么 SVG 肯定有特殊的方式表示尺寸。

参考 MDN 文档 [SVGGraphicsElement](https://developer.mozilla.org/en-US/docs/Web/API/SVGGraphicsElement)

![](https://github.com/RoyJia/mdimgs/raw/master/res/Inheritance-of-SVGGraphicsElement.jpg)

所以，通过`SVGGraphicsElement.getBBox()`方法可获得 SVG 元素的尺寸。总结 [Polling SVG TEXT and TSPAN width](https://bl.ocks.org/MSCAU/58bba77cdcae42fc2f44)

[](#React-获得-DOM-元素的尺寸 "React 获得 DOM 元素的尺寸")React 获得 DOM 元素的尺寸
-----------------------------------------------------------------------------------

目前为止，我已经知道如何通过 JavaScript 获取 SVG DOM 元素的尺寸，但是由于 React 存在虚拟 DOM 概念，所以在使用 React 编码的时候，并不能通过上述方式获得对象元素的尺寸。

Google 之后，发现一个库 [string-pixel-width](https://github.com/adambisek/string-pixel-width) 可以满足我的需求。

但是，经测试之后

```js
    var pixelWidth = require('string-pixel-width');

    const width = pixelWidth('My text ...', { size: 10 });
```

在 React 的环境下，得到的 width 的值总是异常的大。

**Okay，关于我的想法（通过计算获得 text 坐标并保证 text 显示在 rect 中间部位）的调查到此结束，因为我找到了正确的，简单的解决方案。**

Reference Links
---

 - [原生 JS 获取元素的尺寸和位置](https://segmentfault.com/a/1190000007687940)
 - [Polling SVG TEXT and TSPAN width](https://bl.ocks.org/MSCAU/58bba77cdcae42fc2f44)
 - [SVGGraphicsElement](https://developer.mozilla.org/en-US/docs/Web/API/SVGGraphicsElement)