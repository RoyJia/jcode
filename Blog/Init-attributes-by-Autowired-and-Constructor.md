---
title: Init attributes by Autowired and Constructor
tag: Java
date: 2018-06-11
---

Overview
---

以下定义了一个抽象类 AbstractSummaryPageModel 和 其继承类 UpcomingSummaryPageModel

1.  AbstractSummaryPageModel 的大部分成员变量通过其 Constructor 初始化，而 FormatApiConfiguration 通过 @Autowired 初始化。
2.  UpcomingSummaryPageModel 继承了AbstractSummaryPageModel，并在其 Constructor 中调用 super() 对 AbstractSummaryPageModel 的部分成员量初始化。
3.  在使用 UpcomingSummaryPageModel 的时候，通过 new UpcomingSummaryPageModel(equestContext,simplifiedTrip, abbreviatedDateTimeFormatter, clock) 实例化对象。
4.  结果是 AbstractSummaryPageModel 的所有属性都被初始化了，除了 使用了 @Autowired 的 formatConfig 是null。

<!-- More -->

```java
  public abstract class AbstractSummaryPageModel implements SummaryPageModel{

    protected final SimplifiedTrip simplifiedTrip;
    private final AbbreviatedDateTimeFormatter abbreviatedDateTimeFormatter;
    private final DateTime start;
    private final DateTime end;
    protected final IRequestContext requestContext;

    @Autowired
    private FormatApiConfiguration formatConfig;

    public AbstractSummaryPageModel(IRequestContext requestContext,
      SimplifiedTrip simplifiedTrip,
      AbbreviatedDateTimeFormatter abbreviatedDateTimeFormatter,
      DateTime start,
      DateTime end)
    {
      this.requestContext = requestContext;
      this.simplifiedTrip = simplifiedTrip;
      this.abbreviatedDateTimeFormatter = abbreviatedDateTimeFormatter;
      this.start = start;
      this.end = end;
    }
  }

  public class UpcomingSummaryPageModel extends AbstractSummaryPageModel
  {
    private static final int DAYS_IN_WEEK = 7;
    private final Clock clock;
    private final DateTime start;
    private final DateTime end;

    public UpcomingSummaryPageModel(IRequestContext requestContext,
      SimplifiedTrip simplifiedTrip,
      AbbreviatedDateTimeFormatter abbreviatedDateTimeFormatter,
      Clock clock)
    {
        super(requestContext, simplifiedTrip, abbreviatedDateTimeFormatter, simplifiedTrip.getStartTime().getDateTime(), simplifiedTrip.getEndTime().getDateTime());
        this.clock = clock;
        start = simplifiedTrip.getStartTime().getDateTime();
        end = simplifiedTrip.getEndTime().getDateTime();
    }
  }
```

### Questions

> Q1

如果一个类中既包含构造方法初始化的成员变量，也包含通过@Autowired注解的变量。当使用new关键字实例化类对象的时候，是否所有的成员变量都会被初始化？
答案是使用Autowired注解的成员不会被初始化

那么上面这个null的问题该怎么解决呢？

最后采用的做法是：取消使用 @Autowired 注解，将 formatConfig 通过构造方法参数的方式初始化。

```java
  public abstract class AbstractSummaryPageModel implements SummaryPageModel{

    protected final SimplifiedTrip simplifiedTrip;
    private final AbbreviatedDateTimeFormatter abbreviatedDateTimeFormatter;
    private final DateTime start;
    private final DateTime end;
    protected final IRequestContext requestContext;
    private final FormatApiConfiguration formatConfig;

    public AbstractSummaryPageModel(IRequestContext requestContext,
      SimplifiedTrip simplifiedTrip,
      AbbreviatedDateTimeFormatter abbreviatedDateTimeFormatter,
      DateTime start,
      DateTime end,
      FormatApiConfiguration formatConfig)
    {
      this.requestContext = requestContext;
      this.simplifiedTrip = simplifiedTrip;
      this.abbreviatedDateTimeFormatter = abbreviatedDateTimeFormatter;
      this.start = start;
      this.end = end;
      this.formatConfig = formatConfig;
    }
  }

  public class UpcomingSummaryPageModel extends AbstractSummaryPageModel
  {
    private static final int DAYS_IN_WEEK = 7;
    private final Clock clock;
    private final DateTime start;
    private final DateTime end;

    public UpcomingSummaryPageModel(IRequestContext requestContext,
      SimplifiedTrip simplifiedTrip,
      AbbreviatedDateTimeFormatter abbreviatedDateTimeFormatter,
      Clock clock,
      FormatApiConfiguration formatConfig)
    {
        super(requestContext, simplifiedTrip, abbreviatedDateTimeFormatter, simplifiedTrip.getStartTime().getDateTime(), simplifiedTrip.getEndTime().getDateTime(), formatConfig);
        this.clock = clock;
        start = simplifiedTrip.getStartTime().getDateTime();
        end = simplifiedTrip.getEndTime().getDateTime();
    }
  }
```

> Q2

我看到可以在一个类的构造方法上使用 Autowired 注解，此种方法等同于对每个成员变量使用 Autowired 注解。

```java
  class A{
    private B b;
    private C c;

    @Autowired
    public A(B b, C c) {
      this.b = b;
      this.c = c;
    }
  }
```

等于

```java
  class A{
    @Autowired
    private B b;

    @Autowired
    private C c;
  }
```

### To Do - 其实可以接这个机会研究一下Spring的注解机制