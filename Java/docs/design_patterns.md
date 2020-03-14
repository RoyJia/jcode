# Design Patterns in Java

## Singleton

> Note: Singleton property can be broken using multithreading, refection, serialization.

### Common Steps

- Make constructor private: to make constructor price so it is not able to create instance of class from outside of the class
- Provide static method to access object of singleton class
- Create instance of same class as private static which will be returned by static method, you could choose to init instance whild declaring or later

```java
public class EagerInitializationSingleton {
    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private EagerInitializationSingleton() {}

    public static EagerInitializationSingleton getInstance() {
        return instance;
    }
}
```

```java
public class LazyInitializationSingleton {
    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {}

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}
```

if we want to make the above 2 ways to thread safe, just synchronize `getInstance` method, but there is performence cost associated with it as we have made whole method synchronized.

```java
public class ThreadSafeSingletonDoubleCheck {
    private static volatile ThreadSafeSingletonDoubleCheck instance;

    private ThreadSafeSingletonDoubleCheck() {}

    public static synchronized ThreadSafeSingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized(ThreadSafeSingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDoubleCheck();
                }
            }
        }
        return instanced;
    }
}
```

```java
public class BillPughSingleton {
    private BillPughSingleton() {}

    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
```