---
title: Freemarker
tag: Freemarker
date: 2017-11-01
---

![Freemarker logo](https://github.com/RoyJia/mdimgs/raw/master/res/freemarker-logo.png)
[http://freemarker.org/](http://freemarker.org/)
**FreeMarker**
Apache FreeMarker is a template engine: a java library to generate text output (HTML web pages, e-

We all heard FTL/JSP
We want to create a template to use anywhere. From the tech point, we have Java Server Page first. I don’t know what is ftl before and when it was defined. For now, I still don’t know how to describe it or clarify it to others.

<!-- More -->

### What is FTL?

> FTL = Freemarker Template Language

From the definition of FTL, it’s language exactly. And it’s based on templates and changing data, templates are written in the FreeMarker Template Language.
The important thing is that the templates displays that already prepared data.
![FTL date flow](https://github.com/RoyJia/mdimgs/raw/master/res/ftl-flow.png)

### Feature

Highlights of FreeMarker:

-   Powerful template language: Conditional blocks, iterations, assignments, string and arithmetic operations and formatting, macros and functions, including other templates, escaping by default(optional);
-   XML processing capabilities: Drop XML DOM-s into the data-model and traverse them, or even process them declaratively;
-   Versatile data-model: Java objects are exposed to the templates as a tree of variables through pluggable adapters, which decides the template sees them.

### Data-Model

![FTL data model](https://github.com/RoyJia/mdimgs/raw/master/res/ftl-data-model.png)

-   Hashes - The variables that act like directories are called hashes. animals.mouse.price
-   Scalars - The variables that store a single value are called scalars. message
-   Sequences - The subvariables are just in a list. misc.fruits[0]

Data-Model to Template

-   `${…}`: FreeMarker will replace it in the output with actual value of the expression inside the curly brackets. They are called interpolations.
-   FTL Tags: FTL tags are a bit similar to HTML tags, but they are instruction to FreeMarker and will not be printed to the output. The name of these tags start with `#`.(User defined FTL tag use `@` instead of `#`)
-   Comments: Comments are similar to HTML comments, but they are delimited by `<#-- and -->`, unlike HTML comments, FTL comments won’t get into the output (won’t be visible in the page source for a visitor). Because FreeMarker skips them.

### Tips

[https://freemarker.apache.org/docs/dgui\_quickstart\_template.html](https://freemarker.apache.org/docs/dgui_quickstart_template.html)

Dealing with missing variables
Regarding variable accessing with multiple steps, like `animals.python.price`, writing `animals.python.price!0` is correct only if `animals.python` is never missing and only the last subvariable, `price` is possibly missing (in which case here we assume it’s `0`). If `animals` or `python` is missing, the template processing will stop with an “undefined variable” error. To prevent that, you have to write `(animals.python.price)!0`. In that case the expression will be `0` even if `animals` or `python` is missing. Same logic goes for `??`; `animals.python.price??` versus `(animals.python.price)??`.

#### Warning!

A frequent mistake of users is the usage of interpolations in places where they needn’t/shouldn’t/can’t be used. Interpolations work only in text sections (e.g. `<h1>Hello ${name}!</h1>`) and in string literals (e.g. `<#include "/footer/${company}.html">`). A typical WRONG usage is `<#if big>...</#if>`, which will cause a syntactical error. You should simply write `<#if big>...</#if>`. Also, `<#if "${big}">...</#if>` is WRONG, since it converts the parameter value to string and the if directive wants a boolean value, so it will cause a runtime error.

`<@greet color="black" person="Fred"/>`

When you call the macro, you can use only parameters that you have defined in the macro directive (in this case: person and color). So if you try `<@greet person="Fred" color="black" background="green"/>` then you will get an error, since you haven’t mentioned parameter background in the `<#macro ...>`.

Creating a library/Writing the variables of imported namespaces - [https://freemarker.apache.org/docs/dgui\_misc\_namespace.html](https://freemarker.apache.org/docs/dgui_misc_namespace.html)

Data-model 不仅包含常规类型的数据（like String, Number, Boolean…) 还包含 Method implements `TemplateMethodModel` or Directive `TemplateDirectiveModel`

### Maven Support

Latest version is 2.3.27-incubating - [Download](https://freemarker.apache.org/freemarkerdownload.html)

```xml
    <dependency>
        <groupId>org.freemarker</groupId>
        <artifactId>freemarker</artifactId>
        <version>2.3.27-incubating</version>
    </dependency>
```

In order to process with SpringMVC, also the spring-context-support dependency should be added

```xml
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context-support</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
```

### GitHub repo

[https://github.com/RoyJia/jjuina](https://github.com/RoyJia/jjuina) - Spring MVC + Freemarker

Reference Links
---

 - [http://freemarker.org/](http://freemarker.org/)
 - [https://rajinnovations.wordpress.com/tag/free-marker/](https://rajinnovations.wordpress.com/tag/free-marker/)
 - [http://www.baeldung.com/freemarker-in-spring-mvc-tutorial](http://www.baeldung.com/freemarker-in-spring-mvc-tutorial)