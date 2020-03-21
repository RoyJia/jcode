---
title: Preparing
tag: Jnote
date: 2018-04-09
---

The new feature of HTML5
---

> Semantization

使用基于人类理解的，合理的，正确的标签来展示内容

好处：

-   易于用户阅读，当样式丢失的时候，页面能够呈现清晰的结构
-   利于使用SEO，搜索引擎根据标签确定上下文和各个关键字的权重
-   方便其他设备解析，例如盲人设备根据语义渲染网页
-   利于开发和维护，语义化更具可读性

<!-- More -->

Strict mode and Quirks mode of Browser
---

由于历史原因问题，各浏览器对页面渲染的方式是不同的，甚至同一浏览器的不同版本也是不同的。
直到W3C发布了渲染标准，也就有了标准模式和怪异模式之分。

> 标准模式

浏览器按照W3C标准解析执行代码。这样用规定的统一的语法渲染页面，就可以兼容各个浏览器，以确保正确显示页面。

> 怪异模式

在W3C标准出台之前，不同浏览器所采用的页面渲染方式没有同意的规范，存在差异，即怪异模式。

> 浏览器是怎么确定自己该使用什么模式来渲染页面的？

document对象中有一个规定文档解析类型的属性 - document.compatMode，其存在两个值BackCompat和CSS1Compat，分别对应quirks mode和strict mode。那么，通过什么方式声明文档解析类型的值呢？答案是开始HTML文档时所声明的文档类型DOCTYPE，若HTML文档中有明确的DOCTYPE声明，则document.compatMode的值为CSS1Compat，即为标准模式；若HTML文档中没有明确的DOCTYPE声明，即为怪异模式。html5的文档声明方式：`&lt;!DOCTYPE HTML&gt;`。

> 标准模式和怪异模式的区别

1.  width/height不同

    Strict mode: width/height是内容(content)的宽度/高度。
    Quirts mode: width/height是内容(content)的宽度/高度 + padding + border。

2.  the size of inline element

    标准模式下，span等行内元素设置width和height不会生效。反之怪异模式下可以自定义行内元素的大小。

3.  元素百分比高度

    标准模式下元素的高度取决于内容的高度。怪异模式下，如果父元素设置了明确的高度，子元素可以使用百分比高度，且会正确显示。

4.  元素溢出处理

    标准模式下，overflow默认为visible。

XHTML和HTML的区别
---

> XML(EXtensible Markup Language - 可扩展标记语言)

```xml
    <note>
        <to>George</to>
        <from>John</from>
        <heading>Reminder</header>
        <body>Don't forget the meeting</body>
    </note>
```

**被设计用来存储和传输数据。** XML没有预定义的标签，也就是说，我们可以完全自定义标签。但是HTML具有语义化的预定义标签，而且很多。

既然是用来存储和传输数据，经常需要关注的一个问题是XML的解析方式。

> HTML(Hypertext Markup Language - 超文本标记语言)

被设计用来显示数据。[HTML5 introduction](https://scrimba.com/g/ghtml)

> XHTML

XHTML是更严谨更纯净的HTML版本。理论上，XHTML介于HTML和XML之间，是按照XML的标准改进的HTML。

-   XHTML元素必须被正确的嵌套
-   XHTML元素必须关闭
-   标签名必须使用小写字母
-   XHTML文档必须拥有根元素

为什么我有中XHTML不重要的感觉，因为程序员大部分都会遵守以上规则，很少会出现不关闭的标签，错乱的嵌套或者大写的标签。