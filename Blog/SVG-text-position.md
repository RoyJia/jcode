---
title: Positioning text element into rectangle central
tag: SVG
date: 2018-06-19
---

Overview
---

接上篇。

```html
    <g id="seat_2">
      <rect width="50" height="25" x="50" y="25" stroke-width="1.5" stroke="#000000" fill="#49DD8E"></rect>
      <text id="text_seat_2" x="75" y="37.5" fill="#333" text-anchor="middle" dominant-baseline="central">Thor</text>
    </g>
```

我的目的就是将同一个 group 中的 text 定位到 rectangle 中间的位置。由于只考虑到 text 的坐标 baseline 是文本左下角的坐标（基点），所以考虑如何通过已知的值确定这个坐标，所以才有了上篇文档中描述的思路。但其实根本就不需要去考虑这个问题，因为 text 的坐标 baseline 是可以改变的，只需要让 text 的基点变成文本中间点的坐标就可以了。

<!-- More -->

### SVG text 对齐方式

text 的位置由`(x, y)`决定，而这个坐标默认是文本左下角的位置坐标。但其实 SVG 已经提供了方法改变这个基点。

#### text-anchor

`text-anchor` 属性可以改变 `(x,y)` 作为起始坐标的定义。
`text-anchor=”start”` 时，`(x,y)` 为的起始坐标。
`text-anchor=”middle”` 时，`(x,y)` 为的中轴坐标。
`text-anchor=”end”` 时，`(x,y)` 为的结束坐标。

```html
    <g style="font-size: 14pt;">
        <path d="M 100 10 100 100" style="stroke: gray; fill: none;"/>
        <text x="100" y="30" style="text-anchor: start">Start</text>
        <text x="100" y="60" style="text-anchor: middle">Middle</text>
        <text x="100" y="90" style="text-anchor: end">End</text>
    </g>
```

![](https://github.com/RoyJia/mdimgs/raw/master/res/text-anchor.png)

同理，dominant-baseline 属性可以纵向改变基点坐标的定义。

Reference Links
---

[SVG之text](https://segmentfault.com/a/1190000009293590)