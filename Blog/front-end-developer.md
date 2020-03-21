---
title: Front-End Developer
tag: Front-End
date: 2017-08-14
---

### 前端开发 - Front-end web development/client-side development

Web dev主要玩三种东西：JavaScript/Html/CSS

![](https://github.com/RoyJia/mdimgs/raw/master/res/web-tech-employed.jpg)

<!-- More -->

> 一个合格的web产品必须满足以下三个条件：

-   We have to ensure our web app comes up correctly in different browsers (cross-browser),
-   different operation systems (cross-platform),
-   different devices (cross-device).

![](https://github.com/RoyJia/mdimgs/raw/master/res/what-is-front-end-dev.png)

### Core web technologies

1.  Uniform Resource Locators (aka URLs)
2.  Hypertext Transfer Protocol (aka HTTP)
3.  Hyper Text Markup Language (aka HTML)
4.  Cascading Style Sheets (aka CSS)
5.  JavaScript Programming Language (aka ECMAScript 262)
6.  JavaScript Object Notation (aka JSON)
7.  Document Object Model (aka DOM)
8.  Web APIs (aka HTML5 and friends or Browser APIs)
9.  Web Content Accessibility Guidelines (aka WCAG) & Accessible Rich Internet Applications (aka ARIA)

Don’t learn jQuery, learn the DOM. Don’t learn SASS, learn CSS. Don’t learn HAML, learn HTML. Don’t learn CoffeeScript, learn JavaScript. Don’t learn Handlebars, learn JavaScript ES6 templates. Don’t just use Bootstrap, learn UI patterns.

![](https://github.com/RoyJia/mdimgs/raw/master/res/front-end-spectrum.png)

1.  Text editor - 选择编辑器
    光谱图中列出了Atom、sublime、WebStorm。其实还有很多，例如Brackets、Visual Studio、Intellj …
2.  Tools - Version Control/Back-End - 安装工具

    -   git - 版本控制工具，Expedia AWS的项目都托管于github
    -   nodejs - 为项目提供JavaScript运行环境 **\***
    -   npm - 是nodejs的包管理器，大家都熟悉的npm install xxx，管理项目中一些公共的JavaScript包 **\***
    -   rails - 基于MVC的web开发框架 \*\*\*

3.  Core - HTML/JavaScript/Css
    从最开始的页面设计说起，首先需要使用HTML和CSS设计静态页面，也就是UI设计，直接呈现给user。接下来需要做一些动态的交互，那么就需要用到JavaScript，JavaScript的生态系统已经相当复杂，同时JavaScript是web开发中占比最大的一部分。（乱入 - web component，web component是一些现有的，标准的具有高复用性的组件，每一个web component自有html、js、css）

**CSS叫做层叠样式表**（Cascading Style Sheets），用作开发网页样式，但它并不是一种变成语言，它没有变量，也没有条件语句。所以有人为CSS加入了变成元素，叫做“CSS预处理器”，Less和Sass就是CSS的预处理器，以编程的方式进行网页设计，然后再编译成正常的CSS。

-   UI Frameworks - Bootstrap/Ionic/Foundation - Expedia使用自己的UI库UIToolkit - [http://uitoolkit.sb.karmalab.net/uitoolkit-current/docs/index](http://uitoolkit.sb.karmalab.net/uitoolkit-current/docs/index)
-   JS Frameworks - Jquery/Backbone/Ember/React(Flux/Redux)/AngularJS/Polymer/D3
-   Backbone - web前端MVC模式的js框架
-   Templating - Handlebars/Haml/Jade
-   Handlebars - 是js的一个语义模板库，讲view和data分离，主思路为“Logic-less template”
-   JS Preprocessors - Babel/TypeScript/CoffeeScript
-   Babel是js的语法编译器，例如将ES6的js编译为旧版本的js以支持旧版本的浏览器、编译React的JSX语法糖。
-   Building Tools - RequireJS/Browserify/Webpack
-   RequireJS - 是一个JS模块加载器
-   Code Quality - ESLint/JSCS
-   ESLint - 是一个QA工具，用来避免低级错误和统一代码风格，可以自己指定Rules。以前多用JSHint，逐渐被ESLint取代。
-   Process Automation - Gulp/Grunt/Broccoli
-   Front-End Performance - Webpagetest/mod\_pagespeed/PreBudget/CriticalCSS/Picturefill
-   OOCSS & Style Guides - MVCSS/SMACSS/BEM/Inuitcss/KSS/Pattern Lab
    Browser Refreshing - LiveReload/Guard

Thinking of a whole web app. It contains Front-End and Back-End, we can keep them together or split them into two separated codebases.
We can use Webpack to wrap all resources like `*.js`/`*.css`/`*.png`/`*.jpg`/`*.hbs`/`*.sass`/`*.less` to a package
Webpack is a module bundler, this means webpack takes modules with dependencies and emits static assets representing those modules.
We have to make data interaction with restful interface.
Split Front-End and Back-End, split into two separated codebases

### ES6 — NODEJS — REACT — ANGULARJS — RESPONSIVE WEB DESIGN

```bash
    Service(Back-End) —>;
    RESTful Interface(Data Interaction) —>;
    Component Concept
    React/Backbone/Ember(JS Framework - MVC/FLUX/REDUX) —>;
    JQuery UI/Bootstrap(UI) —>;
    Webpack(Module Bundler) —>;
    RequireJS(Module Loader) —>;
    Handlebars(Template) —>;
```

Reference Link
---

-   [https://medium.com/@withinsight1/the-front-end-spectrum-c0f30998c9f0](https://medium.com/@withinsight1/the-front-end-spectrum-c0f30998c9f0)
-   [https://frontendmasters.com/books/front-end-handbook/2017/](https://frontendmasters.com/books/front-end-handbook/2017/)