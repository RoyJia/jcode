---
title: Backbone
tag: Backbone
date: 2017-09-08
---

![](https://github.com/RoyJia/mdimgs/raw/master/res/backbone.png)

**Backbone** - [http://backbonejs.org/\#](http://backbonejs.org/#) - [https://github.com/jashkenas/backbone/](https://github.com/jashkenas/backbone/)

<!-- More -->

### What is backbone?

A powerful JavaScript MVC framework. Backbone is only hard dependency [Underscore.js](http://underscorejs.org/). For RESTful persistence and DOM manipulation with Backbone.View, include [jQuery](https://jquery.com/) and [json2.js](https://github.com/douglascrockford/JSON-js)

### What is backbone used for?

> Serve web application in front-end

With Backbone, you present your data as Model, which can be created, validated, destroyed, and save to server. Whenever a UI action causes an attribute of a model to change, the model triggers a ‘change’ event. All the Views that display the model’s state can be notified of the change, so that they are able to respond accordingly, re-rending themselves with the new information. In a finished Backbone app, you don’t have to write the glue code that looks into the DOM to find an element with a specific id, and update the THML manually - when the model changes, the views simple update themselves.

### Models and Views

![](https://github.com/RoyJia/mdimgs/raw/master/res/models-and-views-backbone.png)

The single most important thing that Backbone can help you with is keeping your business logic separate from your user interface. When the two are entangled, change is hard; when logic doesn’t depend on UI, your interface become easier to work with.

### Models are *Heart* of a Backbone project

-   Orchestrates data and business logic
-   Loads and saves from the server
-   Emits events when data changes

A Model manager an internal table of data attributes, and triggers ‘change’ events when any of its data is modified. Models handle syncing data with persistence layer - usually a RESTful API with a backing database. Design you models as the atomic reusable objects containing all of the helpful functions for manipulating their particular bit of data. Models should be able to be passed around throughout your app and used anywhere that bit of data is needed.

### Views - Between Models and UI

-   Listens for changes and renders UI
-   Handles user input and interactivity
-   Sends captured input to the model
    A View is an atomic chunk of user interface. It often renders the data from a specific model or number of models - but views can also be data-less chunks of UI that stand alone. Models should be generally unaware of views. Instead, views listen to the model ‘change’ events, and react or re-render themselves appropriately.

Reference Links
---

-   [https://www.safaribooksonline.com/blog/2014/11/09/level-backbone-js-javascript/](https://www.safaribooksonline.com/blog/2014/11/09/level-backbone-js-javascript/)
-   [https://addyosmani.com/backbone-fundamentals/](https://addyosmani.com/backbone-fundamentals/)
-   [http://devdocs.io/backbone/](http://devdocs.io/backbone/)