---
title: Shit Scala
tag: Scala
date: 2018-08-11
---

### Value and Variable

**Value** like `const` in ES6, it couldn’t be re-assigned. Which means we cannot change the value of a **Value**

```scala
    val x: Int = 1 +1;
    x +1;
    println(x); // 2
    println(x+1); // 3
```

<!-- More -->

**Variable** it’s same as `var` in ES6

```scala
    var x: Int = 1 + 1;
    x = 3;
    println(x * x); // 9
```

With Java, we can say a variable just like below

```java
    int x = 1;
    String str1 = "See, I am a string";
    List list = new ArrayList();
```

### Fcuntion and Method

> In Java and Javascript, we say function and method are the same things

A **Function** in scala, it’s an Arrow fucntion in Javascript

```scala
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2
```

Methods in scala has to be defined with the `def` keywork

```scala
     private def formatDateTime(dt: String): String = {
        var existingDt: DateTime = new DateTime()
        if (dt.length > 0) {
          val inputFormat: org.joda.time.format.DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S")
          existingDt = inputFormat.parseDateTime(dt)
        }
        val outputFormat: org.joda.time.format.DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss")
        outputFormat.print(existingDt)
      }
```

### Classses and Objects

**Class** is defined with `class` keyword followed by its name and constructor parameters.

```scala
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit =
        println(prefix + name + suffix)
    }
```

**Objects** are single instances of their own definitions. You can think of them as singletons of their own classes.

```scala
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }

    val newId: Int = IdFactory.create()
    println(newId) // 1
    val newerId: Int = IdFactory.create()
    println(newerId) // 2
```

### Really shit there is no return statement in Method/Function

> How let programmer know which will be return in a Method/Function, maybe computer know it

[https://stackoverflow.com/questions/12560463/return-in-scala](https://stackoverflow.com/questions/12560463/return-in-scala)