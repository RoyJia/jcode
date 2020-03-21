---
title: Flux
tag: Flux
date: 2017-08-08
---

Flux是一种设计模式，单项数据流的设计模式。

在高互动的前端应用中，应用程序的数据状态和使用者的操作时间，是最伤脑筋的地方。例如当用户更新个人资料-头像，状态更新，必须刷新UI。
因此，当我们在处理事件改变状态，状态刷新UI，这类复杂的互动时，就非常需要一个模式来规范应用程序的数据流，Flux就是这样一个规范。

![](https://github.com/RoyJia/mdimgs/raw/master/res/flux-flow.png)

<!-- More -->

Flux中的四个角色：Action/Dispatcher/Store/View
Action：规范所有改变数据的动作，也就是所有的操作事件定义在Action中，事件集合；
Dispatcher：将当前发生的行为，告知所有已注册的store；
Store：存放数据和业务逻辑，并且只提供getter API供取得数据，数据集合；
View：根据数据渲染UI和监听使用者的操作事件，UI集合。

### **Dispathcer**
职责：
1. 提供API让Store注册callback；
2. 提供API让Action Creator传送action单位；
3. 将action单位传送给所有已注册的Store。

有两个行为：
register - 在Store中使用register()注册callback
dispatch - 在Action Creator中，使用dispatch()将action广播给所有已经注册的callback function

### **Store**
问：Store是react中的state吗？
回答：react中的state，只是一个数据集，当其改变的时候，会重新render UI。Store不仅仅是一个数据集，其中还包含业务逻辑；当Store数据更新完成后，要告诉前端页面re-render UI，但是Store并不是state，所以View会监听Store的更新。如果是搭配react作为View的话，可能会在componentDidMount时，binding一个Store listener。
componentDidMount: function () {
PhotoStore.bind(‘change’, this.photoChange);
}

使用Flux的意义是什么？
Flux明确规范每个参与角色的职责。
1. 通过Action，可以快速掌握App的所有行为；
2. 通过Store，清楚数据和业务逻辑；
3. View只需要关心UI的排版。

是否应该使用Flux？
如果应用程序需要处理动态数据，则推荐使用Flux；相反，如果只是静态数据的APP，则完全没有必要使用Flux。

Reference Link
---

[http://blog.andrewray.me/flux-for-stupid-people/](http://blog.andrewray.me/flux-for-stupid-people/)