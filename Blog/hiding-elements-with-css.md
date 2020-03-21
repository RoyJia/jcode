---
title: Hiding Elements With CSS
tag: CSS
date: 2018-04-09
---

> 显示和隐藏元素是响应式设计的重要组成部分。以下是通过CSS来显示和隐藏元素的方法。

通过CSS属性
---

### display

HTML文档中的每个元素都是一个矩形框，当通过设置 `display: none;` 隐藏元素的时候，该元素如同不存在（但依然存在于DOM树种），不占用页面空间，不会出现在渲染树种。尽管通过浏览器的检查工具，依然可以看到，但对用户来说，它是不可见的。
同样可以通过修改 `display` 属性的值将元素显示出来。

```css
    display: none;
```

<!-- More -->

### visibility

当使用 `visibility: hidden;` 时，元素会被正常generated，但是不会渲染在屏幕上，对用户来说，它是不可见的。但是浏览器可以感知到它的存在，因为该元素依然占据页面空间，所以会对页面布局产生影响。
同样可以通过修改 `visibility` 属性的值将元素显示出来。

```css
    visibility: hidden;
```

### opacity

`opacity` 属性仅处理元素在视觉上的可见程度，即透明度。
当元素的 `opacity` 属性值设置为绝对最低值时，尽管它在屏幕上可视化的隐藏了起来，但在功能上与将元素设置为纯色是相同的。该元素任然占据页面空间，仍然可以与其进行交互。

```css
    opacity: 0;
```

### position

`position` 通常不用于隐藏或者显示元素，出于隐藏元素的目的，可将元素放置在页面上不可见的范围之外。

> 结合 `top` 和 `left` 属性，将元素移出页面可见范围

```css
    position: absolute;
    top: -9999px;
    left: -9999px;
```

> 通过设置 `clip` 将矩形框的大小调整为无意义的，从而使其在功能上隐藏

```css
    position: absolute;
    clip: rect(1px 1px 1px 1px); /* syntax for IE6 & IE7 */
    clip: rect(1px, 1px, 1px, 1px);
```

Summary
---

| ---- | display | visibility | opacity | position |
| :--- | :-----: | :--------: | :-----: | :------: |
| Is the box model generated? | ✗ | ✓ | ✓ | ✓ |
| Does the box affect the document layout? | ✗ | ✓ | ✓| ✗ |
| Is the box visible on screen? | ✗ | ✗ | ✗ | ✗ |
| Will the element’s content be read by screen readers? | ✗ | ✗ | ✓ | ✓ |
| Is the element actionable(clickable, focusables) | ✗ | ✗ | ✓ | ✓ |