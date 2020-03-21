---
title: Functional Programming with JavaScript(ES6)
tag: JavaScript
date: 2018-04-27
---

### What is Functional Programming

函数式编程的目的：使用一种更贴近自然语言表达的方式编写程序代码。

**函数式编程是一种编程方式，将电脑运算视为数学的函数计算。**

例如，有这样一个数学表达式：

`(1 + 2) * 3 - 4`

过程式的编程方式：

```js
    var a = 1 + 2;
    var b = a * 3;
    var c = b - 4;
```

<!-- More -->

函数式编程要求使用函数，使用函数重新定义运算过程。

在此之前，先考虑将过程式编程中的每一步转换成函数。

划分维度 - 从里到外的嵌套，从小到大的扩展。这其实是一种书写顺序的习惯。

Order：

1.  考虑最小，最里边的运算单元：`1 + 2` –\> `var a = add(1, 2);`
2.  向外扩散一级，考虑乘法：`a * 3` –\> `var b = multiply(a, 3);`
3.  扩展至最外围，考虑减法：`b - 4` –\> `var c = substract(b - 4);`

最终将函数嵌套获得结果：`var result = substract(multiply(add(1, 2), 3) - 4);`

#### Arrow Functions (Fat Arrows)

箭头函数创建一个简洁的表达式，封装一小段功能。

```js
    // const multiply = function(x,y) {
    //         return x * y;
    // }

    // Can be rewritten as:
    // const multiply = (x, y) => { return x * y };

    // Since the function is a single expression return and braces are not needed.
    const multiply = (x, y) => x * y;

    console.log(multiply(5,10)) //50
```

箭头函数看上去像匿名函数的一种简写。但实际上，箭头函数和匿名函数有个明显的区别：箭头函数内部的this是此法作用于，由上下文决定。或者，换一种说法，箭头函数没有局部this的绑定。

[https://blog.fundebug.com/2017/05/25/arrow-function-for-beginner/](https://blog.fundebug.com/2017/05/25/arrow-function-for-beginner/)

#### Function Delegates

函数委托封装了一个方法，允许组装函数或者将其当做数据传递。

```js
    const isZero = n => n === 0;

    const a = [0, 2, 0, 1, 0, 9];
    console.log(a.filter(isZero).length); // 3
```

#### Expressions Instead of Statements

表达式(Expressions)是一个运算过程，并且会返回结果；语句(Statements)只是执行某种操作，没有返回值。这个函数式编程的一个特性，函数要求只使用表达式而不适用语句。也就是说，每一步都是单纯的运算，并且都有结果返回。

```js
    Statement

    const getSalutation = function(hour) {
        var salutation; // temp value

        if (hour < 12) {
            salutation = "Good Morning";
        } else {
            salutation = "Good Afternoon"
        }

        return salutation; // mutated value
    }

    Expression

    const getSalutation = (hour) => hour < 12 ? "Good Morning" : "Good Afternoon";

    console.log(getSalutation(10)); // Good Morning
```

#### Higher Order Functions

函数可以接受其他的函数作为参数，或者返回一个函数。

```js
    function mapConsecutive(values, fn) {
        let result = [];
        for(let i=0; i < values.length - 1; i++) {
            result.put(fn(values[i], values[i+1]));
        }

        return result;
    }

    const letters = ['a','b','c','d','e','f','g'];
    let 2by2 = mapConsecutive(letters, (x, y) => [x, y]);
    console.log(2by2); // [[a,b], [b,c], [c,d], [d,e], [e,f], [f,g]]
```

#### Currying

柯里化(Currying)是指把接受多个参数的函数转变为接受一个单一参数的函数的技术。

原本呢，有一个函数，其接受多个参数，但是可以将这个函数转化，转化为一个函数序列（其实是分解成了多个函数，只不过在使用的时候，看起来我们用了一个只需要一个参数的函数）。

```js
    const convertUnits = (toUnit, factor, offset = 0) => input =>
        ((offset + input) * factor).toFixed(2).concat(toUnit);

    const milesToKm = convertUnits('km', 1.60936, 0);
    const poundsToKg = convertUnits('kg', 0.45460, 0);
    const farenheitToCelsius = convertUnits('degrees C', 0.5556, -32);

    milesToKm(10); //"16.09 km"
    poundsToKg(2.5); //"1.14 kg"
    farenheitToCelsius(98); //"36.67 degrees C"

    const weightsInPounds = [5,15.4,9.8, 110];
    // without currying
    // const weightsInKg = weightsInPounds.map(x => convertUnits('kg', 0.45460, 0)(x));

    // with currying
    const weightsInKg = weightsInPounds.map(poundsToKg);
    // 2.27kg, 7.00kg, 4.46kg, 50.01kg
```

#### Array Manipulation Functions

数组函数是JavaScript函数式编程的入口，这些函数简化了大多数数据和集合的操作。

`[].every(fn)` Checks if all elements in an array pass a test.

`[].some(fn) | [].includes(fn)` Checks if any of the elements in an array pass a test.

`[].find(fn)` Returns the value of the first element in the array that passes a test.

`[].filter(fn)` Creates an array filled with only the array elements that pass a test.

`[].map(fn)` Creates a new array with the results of a function applied to every element in the array.

`[].reduce(fn(accumulator, currentValue))` Executes a provided function for each value of the array (from left-to-right). Returns a single value, the accumulator.

`[].sort(fn(a,b))` warning, mutates state!

Modifies an array by sorting the items within an array. An optional compare function can be used to customize sort behavior. Use the spread operator to avoid mutation. `[...arr].sort()`

`[].reverse()` warning, mutates state!

Reverses the order of the elements in an array. Use the spread operator to avoid mutation. `[...arr].reverse()`

#### Method Chaining

方法链允许链式的将一系列连续的操作写在一起实现功能。

```js
    let cart = [{name: "Drink", price: 3.12},
        {name: "Steak", price: 45.15},
        {name: "Drink", price: 11.01}];

    let drinkTotal = cart.filter(x=> x.name === "Drink")
        .map(x=> x.price)
        .reduce((t,v) => t +=v)
        .toFixed(2);

    console.log(Total Drink Cost $${drinkTotal}); // Total Drink Cost $14.13
```

#### Pipelines

这是一个试验中的功能，试验性的管道操作符 |\> （目前在 stage 1阶段）允许以一种易读的方式去对函数链式调用。本质上来说，管道操作符是单参数函数调用的语法糖，它允许你以`'%21' |> decodeURI`来替代`decodeURI('%21')`。

通过设计模式实现管道操作符：

```js
    const pipe = functions => data => {
        return functions.reduce((value, func) => func(value), data);
    };

    let cart = [3.12, 45.15, 11.01];
    const addSalesTax = (total, taxRate) => (total * taxRate) + total;

    const tally = orders => pipe([
        x => x.reduce((total, val) => total + val), // sum the order
        x => addSalesTax(x, 0.09),
        x => `Order Total = ${x.toFixed(2)}` // convert to text
    ])(orders); // Order Total = 64.62
```

Reference Link
---

 - [http://www.defmacro.org/2006/06/19/fp.html](http://www.defmacro.org/2006/06/19/fp.html)