---
title: Way of performing HTTP request
tag: HTTP
date: 2018-03-17
---

Requirement

数据源是一个包含目的地名称的数组 `Florence,Faro,Budapest`，同时存在一个service，将目的地名称当做参数，通过一个[URL](https://sem-keyword-entity-recognition-service.us-east-1.bigdata.expedia.com/entity/parse?locale=en_IE&siteId=4400&keyword=Florence)来获取目的地信息。

最终需要返回一个由这样的元素`/Florence-Hotels.d1221.Travel-Guide-Hotels`组成的数组。

Code Placement

HttpHelper.java in [https://github.com/RoyJia/jjuina/](https://github.com/RoyJia/jjuina/)

Reference Link

[http://www.baeldung.com/java-http-request](http://www.baeldung.com/java-http-request)