---
title: js 数字运算
tag: JavaScript
date: 2017-07-25
---

> js 在小数计算时会有丢失精度

```bash
    0.1 + 0.2 = 0.30000000000000004
    0.1 + 0.7 = 0.7999999999999999
    0.3 - 0.1 = 0.19999999999999998
    0.23 * 0.1 = 0.023000000000000003
    0.3 / 0.1 = 2.9999999999999996
```

<!-- More -->

`result.toFixed(num)` - 结果返回字符串，`num` 为小数点后位数，有四舍五入功效（之前一直以为数字转字符串是 `22.127456 + ""` 这样来的，殊不知有 `toFixed` 方法）

- `Math.ceil(result)` - 返回整数，向上取整
- `Math.floor(result)` - 返回整数，向下取整
- `Math.round(result)` - 返回整数，四舍五入

> 方法：将小数乘以10的整数倍，转换成整数进行计算

以下是从网上摘过的方法，不知是否已经过时

```js
    //除法函数，用来得到精确的除法结果
    //说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
    //调用：accDiv(arg1,arg2)
    //返回值：arg1除以arg2的精确结果
    function accDiv(arg1,arg2){
        var t1=0,t2=0,r1,r2;
        try{t1=arg1.toString().split(".")[1].length}catch(e){}
        try{t2=arg2.toString().split(".")[1].length}catch(e){}
        with(Math){
            r1=Number(arg1.toString().replace(".",""));
            r2=Number(arg2.toString().replace(".",""));
            return (r1/r2)*pow(10,t2-t1);
        }
    }
    //给Number类型增加一个div方法，调用起来更加方便。
    Number.prototype.div = function (arg){
        return accDiv(this, arg);
    };
    //乘法函数，用来得到精确的乘法结果
    //说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
    //调用：accMul(arg1,arg2)
    //返回值：arg1乘以arg2的精确结果
    function accMul(arg1,arg2)
    {
        var m=0,s1=arg1.toString(),s2=arg2.toString();
        try{m+=s1.split(".")[1].length}catch(e){}
        try{m+=s2.split(".")[1].length}catch(e){}
        return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
    }
    //给Number类型增加一个mul方法，调用起来更加方便。
    Number.prototype.mul = function (arg){
        return accMul(arg, this);
    };
    //加法函数，用来得到精确的加法结果
    //说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
    //调用：accAdd(arg1,arg2)
    //返回值：arg1加上arg2的精确结果
    function accAdd(arg1,arg2){
        var r1,r2,m;
        try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
        try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
        m=Math.pow(10,Math.max(r1,r2));
        return (arg1*m+arg2*m)/m;
    }
    //给Number类型增加一个add方法，调用起来更加方便。
    Number.prototype.add = function (arg){
        return accAdd(arg,this);
    }
    //减法函数
    function accSub(arg1,arg2){
         var r1,r2,m,n;
         try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
         try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
         m=Math.pow(10,Math.max(r1,r2));
         //last modify by deeka
         //动态控制精度长度
         n=(r1&gt;=r2)?r1:r2;
         return ((arg2*m-arg1*m)/m).toFixed(n);
    }
    ///给number类增加一个sub方法，调用起来更加方便
    Number.prototype.sub = function (arg){
        return accSub(arg,this);
    }
```

> 判断数组中是否包含某个元素

```js
    var sites = ['4401', '4402', '4403', '4404', '4405', '4406', '4407'];
    var siteID = '4405'

    var isContains = false;

    // with ES5
    isContains = sites.indexOf(siteID) >= 0 ? true : false;

    // with ES7
    isContains = sites.includes(siteID);

    // with a for in function
    var isContains = function(arr, value) {
        for(let i=0; i < arr.length; i++) {
            if(arr[i] == value) {
                return true;
            }
        }
        return false;
    }
```