---
title: CSS Grid - layout way to page
tag: CSS
date: 2018-01-04
---

> 13年刚毕业的时候，进入一家给煤矿做ERP系统的公司。当时的页面采用“表格布局”，页面中各种`tr` `td`，以单元格的方式构建页面布局。如果是比较复杂的页面，表格嵌套的逻辑更是让人头疼不堪。

CSS Grid的出现，使得页面布局变得更加容易，不需要HTML表格嵌套，也不需要更加复杂的 CSS 代码。

<!-- More -->

以下是css-trick给出的CSS Grid介绍：CSS Grid Layout (aka “Grid”), is a two-dimensional grid-based layout system that aims to do nothing less than completely change the way we design grid-based user interfaces. CSS has always been used to lay out our web pages, but it’s never done a very good job of it. First we used tables, then floats, positioning and inline-block, but all of these methods were essentially hacks and left out a lot of important functionality (vertical centering, for instance). Flexbox helped out, but it’s intended for simpler one-dimensional layouts, not complex two-dimensional ones (Flexbox and Grid actually work very well together). Grid is the very first CSS module created specifically to solve the layout problems we’ve all been hacking our way around for as long as we’ve been making websites.

MDN、W3C、css-trick都提供了很全面的介绍教程：

-   [CSS Grid Layout from Mazilla](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout)
-   [CSS Grid form w3school](https://www.w3schools.com/css/css_grid.asp)
-   [Complete Guide Grid from css-tricks](https://css-tricks.com/snippets/css/complete-guide-grid/)

此外，推荐scrimba的[free course](https://scrimba.com/g/gR8PTE)

### Tips

垂直水平居中
```css
    div{
        display: grid/inline-grid;
        justify-content: center;
        align-content: center;
    }
```