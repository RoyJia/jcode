---
title: GraphQL and REST
tag: GraphQL, REST
date: 2018-04-15
---

GraphQL and REST
---

> GraphQL现在很火，但可能REST也不会彻底消失，GraphQL之于REST，就像JSON之于XML。

### 为什么要用GraphQL

GraphQL解决了三个重要的问题：

-   **必须通过多次请求服务获取视图所需的初始数据** - GraphQL可以做到是：只一次请求，便获得视图所需的所有初始化数据；但使用REST，我们必须引入难以管理和扩展的非结构化的参数和条件。
-   **客户端依赖服务器** - 使用GraphQL，可以将客户端和服务器解耦，因为客户端将使用一种请求方式：一种消除了服务器对数据形状或大小的硬编码的需求。这意味着我们可以独立于服务器对客户端进行维护和改进。
-   **糟糕的前端开发体验** - 使用GraphQL，前端开发人员使用声明性语言表示他们用户界面的数据需求，即只表明他们需要的数据，而不是考虑怎么获取数据。对GraphQL来讲，UI所需要的数据和开发人员使用GraphQL描述这些数据的方式有着紧密的关系。

以上三个问题，对于我来讲，其实有点难以理解，毕竟我也不熟悉REST。我知道的是，前端可以通过url的方式从服务请求数据，既然是url，那应该是基于HTTP的原理传输数据。从上面的问题描述看来，GraphQL之于REST有了很大改进，那GraphQL是个全新的东西，what exactly GraphQL is？

<!-- More -->

### What is GraphQL?

GraphQL是一种语言，如果我们将GraphQL教授给一个软件应用程序，那么该应用程序将能够声明式地把任何数据传递给会说GraphQL这种语言的后端数据服务。

*就像一个孩子可以快速学习一门新语言一样 - 而成年人将很难接受它 - 使用GraphQL从头开始创建一个新的应用程序比将GraphQL引入成熟的应用程序要容易得多。*

教授一个应用程序使用GraphQL，我们需要实现一个运行时层，并将它展示给想要与服务端进行通信的客户端。可以将服务端的运行时层当做一个简单的GraphQL翻译器，或者是一个想要展现数据服务的应用GraphQL语言的代理。GraphQL它不是一个存储引擎，所以它本身不是一个完整的解决方案。所以这就是我们不能只有应用GraphQL的服务，而且我们需要实现运行时的翻译。

这个运行时翻译器可以用任何语言编写，其定义了一个通用的基于图形的schema来发布一个它所代表的数据服务的功能。应用GraphQL的客户端可以查询这个schema。这种方法将服务端和客户端分离，并允许他们进行各自独立的进化和扩展。

GraphQL请求可以是查询（读取操作）或改写（写入操作）。 对于这两种情况，请求都是一个简单的字符串，GraphQL服务可以用特定格式的数据interpret，execute和resolve。 通常用于移动和Web应用程序的流行的响应格式是JSON。

#### 所以，什么是GraphQL？

GraphQL是关于数据通信的一个东西。我们有需要交互的客户端和服务端，客户端告诉服务端它需要什么数据，而服务端返回真实的数据给客户端。GraphQL介于这个通信的中间。

SQL（Structured Query Language）是**结构化查询语言**的简称。所以Graph+QL = **图表化**（可视化）**查询语言**，是一种描述客户端如何向服务端请求数据的`API`语法。

> 或许你会问，为什么客户端不能直接跟服务端通信？当然可以。

为什么客户端和服务端之间存在GraphQL层呢？有几个理由：其中说的最多一个原因是效率问题。客户端通常需要从服务端同时请求多个资源，但服务端通常只知道如何回复单个资源。因此，客户端最终会对服务端进行多次请求以收集所需要的数据。

那么使用GraphQL的意义就在于此，我们可以将这种多请求的处理转义到服务端，由服务端的GraphQL层来处理。这完全符合客户端的期望，客户端向GraphQL发出一个请求（请求多个资源），且GraphQL返回给客户端单一的响应。

GraphQL的好处不止上面所说的这一点，它还可以实现同时与多个服务通信。当我们有多个客户端从多个服务端请求数据时，GraphQL可以标准化并简化其通信过程。虽然这不是放弃REST的真正理由（因为REST也可是实现同样的功能），但GraphQL可以提供一种标准化和结构化的方法。

当使用GraphQL时，客户端不需要直接与多个数据服务进行通信，只需要与GraphQL进行通信，并且GraphQL将与多个数据服务进行交互通信。这就是客户端与使用不同语言数据服务通信的原理。GraphQL可以将来自客户端的单个请求转换为应对多个不同语言服务的请求。

*想象一下，如果现在有三个说不同语言的人，当然他们拥有不同的认知文化。而你有一个问题，需要从这三个人处得到一个包含三种的观念的答案。那么如果你有一个翻译，他会这三种不同的语言，想要得到整合三种文化的答案将非常简单。这就是GraphQL干的事情。*

计算机还没有聪明到可以回答任何问题（至少现在还没有），所以他们需要遵循一个算法规则，这就是为什么我们需要为GraphQL运行定义一个schema，而且这个schema将被客户端获取使用。

该schema是一个功能性文档，其中列出了客户端询问GraphQL层的所有问题。在如何使用schema方面有一定的灵活性，因为我们在这里讨论的是节点图 该schema规定GraphQL可以回答的范围。

还是很迷糊？让我们简单的调用一下GraphQL（替代REST API）。在此之前，解答一下你最想问的问题。

### What’s wrong with REST APIs?

REST API通常是一组endpoint，其中每个endpoint代表一个资源。 因此，当客户端需要来自多个资源的数据时，需要对REST API执行多次往返以整合其所需的数据。所以REST API最大的问题是其有多个endpoint，客户端要获取数据时，必须进行多次请求。

在REST API中，不存在客户端请求语言。客户端无法控制服务器返回的数据，没有这样的语言可以做到这样的控制。更确切的说，客户端可以使用的语言非常有限。

例如，使用REST API读取数据

-   GET `/ResourceName` - 返回改资源的所有记录列表。或者
-   GET `/ResourceName/ResourceID` - 获取由该ID标识的单个记录。

客户端无法做到的是，指定记录的字段。这样的信息位于REST API服务中，并且REST会始终返回记录的所有字段而不管客户端是否真的需要。GraphQL认为这是在过渡提取不需要的信息，是在浪费客户端和服务端的网络和内存资源。

REST API的另一个大问题是版本控制。如果需要支持多个版本，就意味着要增加新的endpoint。这导致在使用和维护这些endpoint时会出现更多问题，并且这可能是服务端代码重复的原因。

上面提到的REST API的问题，是GraphQL试图解决的问题。它们当然不是REST API的所有问题。

### GraphQL是怎么做到解决以上问题的？

GraphQL背后有很多概念和设计决策，但最重要的可能是：

-   GraphQL的schema是强类型的schema。schema中的每个字段都具有一个类型，这些类型可以是GraphQL内建的，也可以是自定义的。这样的类型系统具有丰富的功能，如具有内省的API，并且可以为客户端和服务器构建强大的工具。
-   GraphQL将数据表述为一个图表，可以这么理解，数据本身就是天然的图表。如果你想展现一些数据，那么使用图表结构不失为一个正确的选择。GraphQL的运行时允许我们使用图表API展现数据，而且该API会帮助映射数据和数据匹配的自然图形形状。
-   GraphQL通过声明的方式表示数据。GraphQL给客户端提供了声明性的语言让其表述其所需的数据。

为了解决多次往返请求的问题，GraphQL使得响应服务器成为一个端点。基本上，GraphQL将自定义终端的想法考虑到了极致，并让整个服务器成为一个可以回答所有数据问题的自定义终端。

与这个单一端点概念相关的另一个重要概念是使用该端点时需要一种富客户端请求语言。如果没有客户端请求语言，单一断点的概念也就没用了。所以它需要一种语言来处理自定义请求并响应该自定义请求的数据。

具有客户端请求语言意味着客户端将得到控制。客户端可以准确的表述他们需要什么，服务器会响应他们要求的内容。这解决了超载问题。

说到版本控制，GraphQL有一个有趣的东西。基本上，我们可以在不删除旧字段的情况下添加新字段，因为我们有图形，并且可以通过添加更多节点来灵活地增加图形。因此，API在增长的同时，我们可以在图标上保留旧API的路径，并引入新路径而不将它们标记为新版本。

这对移动客户端尤其重要，因为我们无法控制他们使用的API的版本。安装完成后，移动应用可能会继续使用相同的旧版API。在网络上，很容易控制API的版本，因为我们只是推新代码。但对于移动应用程序来说，这很难做到。

接下来我们对GraphQL和REST进行一对一的比较，并展示一个实际的例子。

### RESTful APIs vs GraphQL APIs — Example

想象我们是负责构建一个闪亮的新用户界面来代表星球大战电影和角色的开发者。

我们负责构建的第一个UI很简单：显示单个星球大战人员信息的视图。例如，达斯维达以及这个人出现的所有电影。这个页面应该显示这个人的姓名，出生年份，星球名称以及他们出现的所有电影的标题。

听起来很简单，实际上我们在处理3种不同的资源：人物，地球和电影。这些资源之间的关系也很简单，任何人都可以在这里猜出数据的形状。 一个人物体属于一个行星，并且它将具有一个或多个电影。

此UI的JSON数据可能类似于：

```json
    {
      "data": {
        "person": {
          "name": "Darth Vader",
          "birthYear": "41.9BBY",
          "planet": {
            "name": "Tatooine"
          },
          "films": [
            { "title": "A New Hope" },
            { "title": "The Empire Strikes Back" },
            { "title": "Return of the Jedi" },
            { "title": "Revenge of the Sith" }
          ]
        }
      }
    }
```

假设一个数据服务器为我们提供了这个数据的精确结构，下面是用React.js表示其视图的一种可能的方式：

```js
    // The Container Component:
    <PersonProfile person={data.person} ></PersonProfile>
    // The PersonProfile Component:
    Name: {person.name}
    Birth Year: {person.birthYear}
    Planet: {person.planet.name}
    Films: {person.films.map(film => film.title)}
```

这是一个简单的例子，如果我们看过星球大战，将会对我们思考构建示例有所帮助，但其实用户界面和数据的关系已经简单明确。UI使用的是JSON数据对象的key。

接下来看看如何使用RESTful API来请求这些数据。

我们需要一个人的信息，假设我们知道该人的ID，RESTful API预计会公开这些信息：

`GET - /people/{id}`

这个请求会给我们提供姓名，出生年份和其他关于此人的信息。一个好的RESTful API也会给我们这个人的星球的ID和这个人出现在这个电影里的一系列ID。

这个请求的JSON响应可能类似于：

```json
    {
      "name": "Darth Vader",
      "birthYear": "41.9BBY",
      "planetId": 1
      "filmIds": [1, 2, 3, 6],
      *** other information we do not need ***
    }
```

读取星球的名字：`GET - /planets/1`

读取电影名称：

```js
    GET - /films/1
    GET - /films/2
    GET - /films/3
    GET - /films/6
```

一旦获得来自6个服务器的所有响应，便可以将它们组合起来作为视图所需要的数据。但是，这6次请求是必须的。

星球大战数据有一个RESTful API，在[http://swapi.co/](http://swapi.co/)上。我们可以在这里尝试构建数据，且一定会是6次请求，而且有些数据并不是我么所需要的。

当然，这只是这个数据的RESTful API的一个实现。有更好的实现可以使这个视图更容易实现。例如，如果API服务器实现了嵌套资源并理解了一个人与一部电影之间的关系，我们可以通过以下方式读取电影数据：

`GET - /people/{id}/films`

但是，纯粹的RESTful API服务器很可能不会实现这一点，我们需要让我们的后端工程师创建这个自定义端点。这是扩展RESTful API的现实 - 我们只是添加自定义端点以有效地满足不断增长的客户需求。 像这样管理自定义端点很困难。

现在我们来看看GraphQL方法。假设我们有一个GraphQL端点可以通过HTTP请求位于/graphql的数据。

由于我们希望通过一次往返的方式获取所需的数据，因此我们需要一种方式来表达我们对服务器的完整数据需求。 我们用GraphQL查询来做到这一点：

`GET or POST - /graphql?query={...}`

GraphQL查询只是一个字符串，但它必须包含我们需要的所有数据。

在英语中，这样表述我们需要的数据：我们需要一个人的姓名，出生年份，地球名称和所有电影的标题。在GraphQL中，则转化为：

```js
    {
      person(ID: ...) {
        name,
        birthYear,
        planet {
          name
        },
        films {
          title
        }
      }
    }
```

### GraphQL灵活性的代价

完美的解决方案是不存在。由于GraphQL的灵活性，又出现了新的问题。

GraphQL让一个重要的威胁变得更容易，资源耗尽攻击（AKA拒绝服务攻击）。过度复杂的查询会损害服务器的所有资源，从而导致GraphQL服务器受到攻击。查询深层嵌套关系（user -\> friends -\> friends …）或使用字段别名多次询问相同字段非常简单。资源耗尽攻击并不是特定于GraphQL的，但是在使用GraphQL时，我们必须对它们进行额外的小心处理。

我们可以在这里做一些缓解措施。我们可以提前对查询进行成本分析，并对可以消耗的数据量执行某种限制。我们还可以实施超时来终止需要很长时间才能解决的请求。另外，由于GraphQL只是一个解决层，我们可以在GraphQL下的较低级别处理速率限制实施。

如果我们试图保护的GraphQL API端点不是公开的，并且意味着我们自己的客户端（web或移动设备）的内部消耗，我们可以使用白名单方法并预先批准服务器可以执行的查询。客户端可以请求服务器使用查询唯一标识符执行预先批准的查询。 Facebook似乎正在使用这种方法。

认证和授权是我们在使用GraphQL时需要考虑的其他问题。我们是否在GraphQL解析过程之前，之后或期间处理它们？

要回答这个问题，可以将GraphQL视为一种DSL（域特定语言），在您自己的后端数据读取逻辑之上。这只是我们可以在客户端和我们的实际数据服务（或多个服务）之间建立的一个层。

将认证和授权视为另一层。 GraphQL不会帮助实现认证或授权逻辑。这不是为了那个。但是，如果我们希望将这些层放在GraphQL之后，我们可以使用GraphQL在客户端和强制逻辑之间传递访问令牌。这与我们使用RESTful API进行身份验证和授权的方式非常相似。

客户端数据缓存是GraphQL带来更多挑战的另一项任务。由于其字典性质，RESTful API更容易缓存。这个位置给出了这些数据。我们可以将位置本身用作缓存键。

使用GraphQL，我们可以采用类似的基本方法，并使用查询文本作为缓存响应的关键。但是这种方法有限，效率不高，可能会导致数据一致性问题。多个GraphQL查询的结果可以很容易地重叠，这种基本的缓存方法不会考虑重叠。

尽管如此，这个问题有一个很好的解决方案。图形查询意味着图形缓存。如果我们将GraphQL查询响应标准化为一组平坦的记录集合，为每条记录提供一个全局唯一ID，那么我们可以缓存这些记录，而不是缓存完整的响应。

尽管这不是一个简单的过程。将会有记录引用其他记录，我们将在那里管理一个循环图。填充和读取缓存将需要查询遍历。我们需要编写一个图层来处理缓存逻辑。但是这种方法总体上比基于响应的缓存更有效。 Relay.js是一个采用这种缓存策略并在内部自动管理的框架。

可能我们应该关注的GraphQL最重要的问题是通常被称为N + 1 SQL查询的问题。 GraphQL查询字段设计为独立函数，用数据库中的数据解决这些字段可能会导致每个已解析字段发生新的数据库请求。

对于简单的RESTful API端点逻辑，可以通过增强构建的SQL查询来轻松分析，检测和解决N + 1问题。对于GraphQL动态解析的字段，并不那么简单。幸运的是，Facebook正在开创一种可能的解决方案：DataLoader。

顾名思义，DataLoader是一个可用于从数据库中读取数据并将其提供给GraphQL解析器函数的实用程序。我们可以使用DataLoader而不是直接从数据库中用SQL查询读取数据，DataLoader将充当我们的代理来减少我们发送给数据库的实际SQL查询。

DataLoader使用批处理和缓存的组合来实现这一点。如果相同的客户端请求导致需要向数据库询问多件事情，DataLoader可用于整合这些问题并从数据库批量加载其答案。 DataLoader还会缓存这些答案，并使它们可用于后续有关相同资源的问题。

### GraphQL调试工具

insomnia是类似于postman（postman目前还不支持GraphQL）的API验证工具，[下载地址](https://insomnia.rest/download/)，下载之后完全可以自己倒腾，有助于对GraphQL的理解。就像使用markdown编辑器编辑markdown文件一样，左边写query request，点击查询（CMD + enter），右边直接显示查询结果。

另外还可以用Chrome浏览器的插件，例如：[ChromeiQL](https://chrome.google.com/webstore/search/ChromeiQL?hl=en)

Reference
---

 - [https://medium.freecodecamp.org/rest-apis-are-rest-in-peace-apis-long-live-graphql-d412e559d8e4](https://medium.freecodecamp.org/rest-apis-are-rest-in-peace-apis-long-live-graphql-d412e559d8e4)
 - [http://graphql.org/](http://graphql.org/)
 - [GraphQL Queries by Insomnia](https://support.insomnia.rest/article/61-graphql)