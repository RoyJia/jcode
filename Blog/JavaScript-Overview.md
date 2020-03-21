---
title: Javascript
tag: JavaScript
date: 2017-07-26
---

![](https://github.com/RoyJia/mdimgs/raw/master/res/javascript_logo.png)

MDN上[JavaScript](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript)的标题是这样的JavaScript – Dynamic client-side scripting。

JavaScript是什么？
---

**JavaScript** (JS) 是一种轻量级解释型的，或是JIT（just in time - 即时编译器）编译型的程序设计语言，但不同于 Java，C 和 C++，它是作为 Web 页面的脚本语言而出名的。JS 是基于原型、多范式同时具有面向对象、命令式和声明式（函数式）编程风格的脚本语言。JS 可能是最具吸引力的语言，使用 JS 操作数据，实现某个酷炫的效果会有相当的成就感。

<!-- More -->

起源
---

在 1995 年 Netscape 一位名为 Brendan Eich 的工程师创造了 JavaScript，随后在 1996 年初，JavaScript 首先被应用于 Netscape 2 浏览器上。最初的 JavaScript 名为 LiveScript，后来因为 Sun Microsystem 的 Java 语言的兴起和广泛使用，Netscape 出于宣传和推广的考虑，将它的名字从最初的 LiveScript 更改为 JavaScript —— 尽管两者之间并没有什么共同点。这便是之后混淆产生的根源。\_

ECMAScript
---

1997年 Netscape 以 JavaScript1.1 为蓝本的建议被提交至 ECMA(European Computer Manufacturers Association)欧洲计算机制造商协会，ECMA 指定 39 号技术委员会(TC39)完成了 ECMA-262 —— 定义一种名为 ECMAScript 的新脚本语言的标准。随后在 1999 年以 ECMAScript 第三版的形式更新，第四版由于更新内容跨度过大且委员会内部意见不统一而尚未推出便被废除。直到 2009 年 12 月发布第五个版本，其中引入了第四版草案加入的许多新特性。第六版于 2015 年 6 月发布称 ES6 或者 ES2015。

宿主环境
---

与大多数编程语言不同，JavaScript 没有输入或输出的概念。它是一个在宿主环境（host environment）下运行的脚本语言，任何与外界沟通的机制都是由宿主环境提供的\_。浏览器是最常见的宿主环境，但在非常多的其他程序中也包含 JavaScript 解释器，如 Adobe Acrobat、Photoshop、SVG 图像、Yahoo! 的 Widget 引擎，以及
[Node.js](http://nodejs.org/)之类的服务器端环境。JavaScript 的实际应用远不止这些，除此之外还有 NoSQL 数据库（如开源的[Apache CouchDB](http://couchdb.apache.org/)）、嵌入式计算机，以及包括[GNOME](http://www.gnome.org/)（注：GNU/Linux 上最流行的 GUI 之一）在内的桌面环境等等。

JavaScript数据类型
---

JavaScript变量只能存储两种类型的值，基本类型的值(primitive values)和引用类型的值(reference values)。所以JavaScript数据类型有两种 - 基本类型和应用类型。 基本类型的变量是按值访问的，将一个基本类型的变量var a = “Hello World”; 赋值给var b = a;时，会将栈(stack)中的“Hello World”备份一份。 引用类型的变量是按引用访问的，赋值或者复制引用类型的变量是，其实只是多提供了一个引用类型值的引用。引用类型的额值存储在堆(heap)内存中。

```js
    // typeof 判断变量的基本类型 
    var str = 'Hello World';
    console.log(typeof(str)); // "string" str instanceOf String 
    // false   

    // instanceof 判断变量的引用类型
    var str1 = new String("Hello World");
    console.log(typeof(str1)); // "object" str1 instanceOf String 
    // true
```

> \* 基本类型 和 \$ 引用类型
>
> -   Number ( \* )
> -   String ( \* )
> -   Boolean ( \* )
> -   Symbol ( \* new in ES6)
> -   Object ( \$ )
>     -   Function ( \$ )
>     -   Array ( \$ )
>     -   Date ( \$ )
>     -   RegExp ( \$ )
> -   null ( \* )
> -   undefined ( \* )

JavaScript函数的参数传递
---

ECMAScript 中函数的参数在内部使用一个数组来表示的。函数接收到的始终是这个数组而不关心属于中包含哪些参数(如果有参数的化)。在函数体内可以通过访问 arguments 这个对象来访问参数数组，从而获取传递给函数的每一个参数。

JavaScript 执行环境(Execution context)和作用域链(Scope Chaine)
---

要了解 JavaScript 的执行环境，必须先了解 JavaScript 的宿主环境，JavaScript 是在宿主环境(host environment)下运行的脚本语言，任何与外接沟通的机智都由宿主环境提供。浏览器是最常见的宿主环境，也有很多其他的程序包含 JavaScript 解释器，如：Adobe Acrobat、Photoshop、SVG图像、Yahoo! 的 Widget 引擎，以及 NodeJS 之类的服务端环境。

当然这里要说的执行环境并不是上面提及的宿主环境，宿主环境只提供 JavaScript 的运行环境。

执行环境定义了变量或函数有权访问的其他数据，决定了它们各自的行为。每个执行环境都有一个与之对应的变量对象，环境中定义的所有变量和函数都是这个变量对象的属性和方法。根据 ECMAScript 实现所在的宿主环境不同，表示执行环境的对象也不一样。通常执行环境有全局执行环境和函数执行环境。Web 浏览器中，全局执行环境被认为是 window 对象。每个函数都有自己的执行环境，当执行流进入一个函数时，函数的环境被推入一个环境栈中，当执行完毕后，栈将环境弹出，对应的变量对象随之被销毁，并将控制权返回给之前的执行环境。

当代码在一个环境中执行时，会创建变量对象的作用域链。作用域链的用途是保证对执行环境有权访问的所有变量和函数的有序访问。作用域链的前端始终是当前执行的代码所在的环境的变量对象。