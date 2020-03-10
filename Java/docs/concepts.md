# Concepts

Object Oriented Programming (commonly OOP) concepts are based on real life examples, where every entity in existence can be represented as an object.

## The essential concept of Object Oriented Programming(OOP)

### Abstraction

Abstraction is a concept of exposing only essetial details and hiding implementation details. Abstraction retains only infomation which is most relevant for the specific purpose.

### Encapsulation

Encapsulation is process of binding related data (variables and methods) into a class, we can achieve encapsulation using access modifiers such as public, private, protected.
Encapsulation is implementation of desired abstraction.

### Polymorphism

Polymorphism means one name many forms, in Java, polymorphism can be achieved by method overloading and method overriding.
There are 2 types of polymorphism in Java:

- Compile time polymorphism - method overloading
- Run time polymorphism - method overriding

### Inheritance

In commen terms, inheritance means the bequeathing of property and characteristics from generation to generation, i.e. the property or characteristics of parents are handed down to their children and the forthcoming generations.

Inheritance in Java, as derived of concept of OOP, is defined as the process by which a child class or object(Known as sub-class) inherits the behavriours and properties(methods and varialbes) from its predecessors or parent class(Knows as super-class). Inheritance in Java is implemented by the use of the keyword `extends`, this special word makes the Java compiler understand that the current class is inheriting or extending another class. Inheritance represents an `IS-A relatioship` between classes.

## Synchronization

Synchronization is ability to restrict access to shared resource to only one thread. When two or more threads need access to shared resource, there has to be some mechanism such that shared resource will be used by only one thread.

Achieve synchronization

- synchronized method

```java
public class RequestCounter {
    private int count;

    public synchronized int incrementCount() {
        count ++;
        return count;
    }
}
```

- synchronized block

```java
public class RequestCounter {
    private int count;

    public int incrementCount() {
        synchronized(this) {
            count ++;
            return count;
        }
    }
}
```

Locking types

- Object level locking

Object level locking means you want to synchronize non-static method or block so that it can be accessed by only one thread at a time for that instance. It is used if you want to protect non-static data.

- Class level locking

Class level locking means you want to synchronize static moethod or block so that is can be accessed by only one thread for while class. if you have two or more instances of class, only one thread will be able to access only one method or block of any one instance at a time. It is used if you want to protect static data.

### Questions

#### Can two threads execute static and non static method concurrently?

Yes, since two threads will acquire lock on different objects. They can be executed concurrently without any issue.

#### If one method of class is synchronized and other method of same class is not synchronized? Can they be executed concurrently by two threads?

Yes, because one thread will require lock to get into synchronized block but second thread which will execute non synchronized method that won’t require any lock, so it can be executed concurrently.

#### Is it safe to call a synchronized method from another synchronized method?

Yes, it is safe to call a synchronized method from another synchronized method because when you call synchronized method, you will get lock on this object and when you call another synchronized method of same class, it is safe to execute as it already has lock on this object.

## Garbage Collection

Garbage collection is the process of identifying used and unused objects on Java heap and removing unused object from the heap.
A live object means an object is still referred to some part of program. Unused object means object is not being referred by any part of program and is eligible for garbage collection.
Programmer does not have to do manual garbage collection like C or C++. Java take care of it.

JVM memory is devided to three parts

- Young generation
- Old generation
- Metaspace (Perm Gen)

### Young Generation

As the name suggests, young generation is the area where newly created objects are allocated.

- When Young Generation fills up, it cause minor garbage collection aka Minor GC.
- When Minor GC occurs, the dead objects will be removed from Young Generation.
- If you have lots of dead objects in Young Generation, Minor GC will be performed faster.
- All Minor GCs are "stop the world" events, so when Minor GCs occurs, application thread will also stop.

![Young and Old generation](https://java2blog.com/wp-content/uploads/2019/05/YoungOldGeneration-1024x733.png)

### Old Generation

- It is used to hold old long surviving objexts.
- It is generally lager than the Young Generation.
- When tenured space is completely filled(or predefined threshold) with objects then Major GC occur. It will reclaim the memory and free up the space.
- Often, Major GCs are slower and less frequent than Minor GC.

### Garbage Collection Algorithms

#### serial collector

It uses single thread to perform all the garbage collection and is suitable for basic application with single processor machines.

#### Parallel collector

It uses multiple CPUs to perform garbage collector. While serial collector uses 1 thread to perform GC, parallel GC uses several threads to perform GC and it is useful when there is enough memory and good number of cores.

#### Concurrent collector

Concurrent collector performs garbage collection with application threads. It is useful for applications which have medium to large datasets and require quick response time.