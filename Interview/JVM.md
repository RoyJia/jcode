# JVM - Java Virtual Machine

JVM is an abstract virtual machine(program) which is could be installed on any device or operating systems. One good explaination of [JVM Architecture](https://www.youtube.com/watch?v=QHIWkwxs0AI)

![app-jvm-platforms](https://images.idgesg.net/images/article/2019/03/javaworld_jvm_jdk_jre_explainer_java_virtual_machine_debug_and_optimize_3x2_overview_update-100790558-orig.jpg)

- to provide runtime environment to execute other programs(Java application).
- to manage and optimize program memory.

## Modules that JVM has

- Class Loader
- Memory Area - Allocated by JVM
  - Class Area
  - Heap
  - Stack
  - PC Registor
  - Native Method Stack
- Execution Engine

### ClassLoader

ClassLoader is a subsystem of JVM which is used to load class files, whenever we run the java program, it is loaded first by ClassLoader.

- Loading - This component loads `.class` files form the hardware system into the JVM memory and stores the binary data(such as qualified class-name, immediate parent class-name, constructor info, method info, variables etc.) into Class(Method) Area.
  - Bootstrap ClassLoader - This is the first ClassLoader which is the super Class of extension ClassLoader, to load rt.jar(run time) which contains all class files of Java Standard Edition like java.lang.\*; java.io.\*; java.util.\*;
  - Extension ClassLoader - This is the sub ClassLoader of Bootstrap ClassLoader and the parent ClassLoader of application ClassLoader to load class files which are located inside $JAVA_HOME/jre/lib/ext directory.
  - System / Application ClassLoader - This is the sub ClassLoader of Extension ClassLoader to load Java app class files. It loads the class files from classpath, by default, it's currrent directory. the classpath could be change by `-cp` or `-classpath`.
- Linking - This component performs the linking of a class or an interface. As it involves the allocation if new date structure, it may throw `outOfMemoryError` and performs 3 important activities.
  - Verification - This process if performed by Bytecode verifier and if the generated `.class` file is not valid, then throw `VerifyError`.
  - Preparation - This is the process of assigning the memory for the class level or interface level static variables and assigns the default value.
  - Resolution - This is the process of changing the symbolic references with the original memory references from the Class(Method) Area.
- Initialization - This component performs the last phase of class loading where all the static variables are assigned the original values and the static blocks are executed from parent to child class. This process requires care synchronization as JVM is multithreaded and some threads may try to initialize the same class or interface at the same time.

### Runtime Data Areas

Memory management system of JVM, it is used to store Class info, instance info, method info, constants or variables.

![JVM-runtime-data-areas](https://www.javacodegeeks.com/wp-content/uploads/2018/04/jvm_archi_clrda_guide_5.jpg)

#### Class(Method) Area

ClassLoader loads the `.class` files and save bytecode in the Class(Method) area. This 

#### Heap

JVM heap is a part of JVM memory where all the objects and it's corresponding instance variables and arrays are stored. There is only one heap area and is shared across multiple threads as the data stored here is not thread-safe.

#### Stack

JVM Stack is a part of JVM memory where all temporary variables are stored, this area has stack frames and allocates one frame for each thread, once the thread execution is completed, the frame also gets destroyed. This component is thread-safe.

#### PC(Program Counter) Regiser

This component holds the address of JVM instruction which is currently executing, each Java thread has its own PC register to hold the address of the current executing instruction. Which means this component is thread-safe.

#### Native Method Stack

This component is written in different language and holds the native method info, each Java thread has a separate native method stack, which means that this component is thread-safe.

There are 2 exceptional condition is associated with this area:

- If the program requires more native method stack than it's permissible limit, the JVM throws `StackOverflow` error.
- If the native method stack is insufficiently expanded, the JVM throws `OutOfMemory` error.

### Execution Engine

This component executes the bytecode which is assigned to runtime data area and it has 3 main sub-components

- Interpreter - this component reads the bytecode instructions and executes them in sequential manner
- JIT(Just In Time) compiler - this component counterbalances Interpreters's disadvantage of slow execution and improves the performance
- Garbage Collection - this component frees up the memeory by collecting and removing the unreferenced objects

#### Garbage Collection

Garbage collection is the process of identifying used and unused objects on Java heap and removing unused object from the heap.
A live object means an object is still referred to some part of program. Unused object means object is not being referred by any part of program and is eligible for garbage collection.
Programmer does not have to do manual garbage collection like C or C++. Java take care of it.

JVM memory is devided to three parts

- Young generation
- Old generation
- Metaspace (Perm Gen)

##### Young Generation

As the name suggests, young generation is the area where newly created objects are allocated.

- When Young Generation fills up, it cause minor garbage collection aka Minor GC.
- When Minor GC occurs, the dead objects will be removed from Young Generation.
- If you have lots of dead objects in Young Generation, Minor GC will be performed faster.
- All Minor GCs are "stop the world" events, so when Minor GCs occurs, application thread will also stop.

![Young and Old generation](https://java2blog.com/wp-content/uploads/2019/05/YoungOldGeneration-1024x733.png)

##### Old Generation

- It is used to hold old long surviving objexts.
- It is generally lager than the Young Generation.
- When tenured space is completely filled(or predefined threshold) with objects then Major GC occur. It will reclaim the memory and free up the space.
- Often, Major GCs are slower and less frequent than Minor GC.

##### Garbage Collection Algorithms

###### serial collector

It uses single thread to perform all the garbage collection and is suitable for basic application with single processor machines.

###### Parallel collector

It uses multiple CPUs to perform garbage collector. While serial collector uses 1 thread to perform GC, parallel GC uses several threads to perform GC and it is useful when there is enough memory and good number of cores.

###### Concurrent collector

Concurrent collector performs garbage collection with application threads. It is useful for applications which have medium to large datasets and require quick response time.

### Native Method Interface (JNI - Java Native Interface)

This component is a programming framework that allows Java code to call or be called by the libraries and the native application(the programs specific to the hardware or the OS of the system)

### Native Method Libraries

This component is a collection of native C, C++ libraries which are required by the execution engine.

## References

- https://www.javacodegeeks.com/2018/04/jvm-architecture-overview-of-jvm-and-jvm-architecture.html
- https://www.javacodegeeks.com/2018/04/jvm-architecture-jvm-class-loader-and-runtime-data-areas.html
- https://www.javatpoint.com/jvm-java-virtual-machine