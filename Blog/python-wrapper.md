---
title: python wrapper
tag: Python
date: 2018-07-31
---

装饰器（Wrapper）
---

> 如果想在一个方法运行之前或者之后做一些事情，普通的解决办法就是在方法被调用的时候前后添加代码

```python
    def normal_func():
      print("This is a normal function")

    ## a inner func is defined
    def another_normal_func(param_func):
      print("Before we run function: " + param_func.__name__)
      param_func()
      print("After we run function: " + param_func.__name__)

    another_normal_func(normal_func)
```

<!-- More -->

使用装饰器（decorator）可以在不修改当前方法的情况下扩展该方法。

装饰器所依赖的特性：

-   Python可以在方法内部定义方法
-   可以将一个函数当做参数传递给另一个函数

### 定义一个标（简）准（单）的装饰器

```python
    ## a standard decorator
    def standard_decorator(func):
      def wrapper():
        print('Do something before func')
        func()
        print('Do something after func')
      return wrapper

    ## define a ordinary func
    def _an_ordinary_func():
      print('I\'m ordinary function - 1')

    ## how to use decorator
    ## 1. pass _an_ordinary_func to standard_decorator as a param
    standard_decorator(_an_ordinary_func)()

    print('--------------------------------------------------')

    ## 2. define a variable to accept wrapper and run that variable
    use_decorator = standard_decorator(_an_ordinary_func)
    use_decorator()

    print('--------------------------------------------------')

    ## 3. connect decorator by @, and run _an_ordinary_func2
    @standard_decorator
    def _an_ordinary_func2():
      print('I\'m ordinary function - 2')

    _an_ordinary_func2()
```

output:

```bash
    Do something before func
    I'm ordinary function - 1
    Do something after func
    --------------------------------------------------
    Do something before func
    I'm ordinary function - 1
    Do something after func
    --------------------------------------------------
    Do something before func
    I'm ordinary function - 2
    Do something after func
```

### 如何装饰带参数的方法

```python
    def standard_decorator2(func):
      def wrapper(*args, **kwargs):
        print('Do something before func', *args)
        func(*args, **kwargs)
        print('Do something after func')
      return wrapper

    @standard_decorator2
    def _an_ordinary_func2(param1, param2):
      print('I\'m an another ordinary function', param1, param2)

    _an_ordinary_func2('aaaaa', 'bbbbb')
```

output:
```bash
    Do something before func aaaaa bbbbb
    I'm an another ordinary function aaaaa bbbbb
    Do something after func
```

### 一个创建封装器的方法

```python
    def make_decorator(make_decorator_param1):
      def decorator(func):
        def wrapper(*args, **kwargs):
          print('Let\'s print a param named make_decorator_param1:', make_decorator_param1)
          print('Do something before func', *args)
          func(*args, **kwargs)
          print('Do something after func')
        return wrapper
      return decorator

    @make_decorator('ccccc')
    def _an_ordinary_func3(param1, param2):
      print('I\'m an another~ ordinary function', param1, param2)

    _an_ordinary_func3('aaaaa', 'bbbbb')
```

output:

```bash
    Let's print a param named make_decorator_param1: ccccc
    Do something before func aaaaa bbbbb
    I'm an another~ ordinary function aaaaa bbbbb
    Do something after func
```

Reference Links
---

[http://www.wklken.me/posts/2013/07/19/python-translate-decorator.html](http://www.wklken.me/posts/2013/07/19/python-translate-decorator.html)
[https://www.saltycrane.com/blog/2008/01/how-to-use-args-and-kwargs-in-python/](https://www.saltycrane.com/blog/2008/01/how-to-use-args-and-kwargs-in-python/)
[http://kaito-kidd.com/2017/02/06/python-advance-decorator/](http://kaito-kidd.com/2017/02/06/python-advance-decorator/)