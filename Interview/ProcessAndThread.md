# Process and Thread

做 Web 开发时，很少关心操作系统层面的运行，很多时候都不注意 Server 端是如何在操作系统上运行的。但是有个课题是软件开发中很突出的，那就是尽可能研究更高效的调用系统资源的方式以实现程序高效并可靠的运行。

所以作为一个开发而不清楚操作系统可以提供什么资源，程序员写出来的java，python，JavaScript 的执行过程具体是什么样的，调用了操作系统的什么资源，以什么样的方式完成了运行，得到了所有人期望的结果。

如果需要提供一段程序的优化方案，前提是要尽可能详细的了解其执行过程。

操作系统的本质是管理计算机的各种资源，并提供调度资源的接口。谁在调用这些接口呢？运行在操作系统上的应用程序。

## The components of a computer

A computer is an electronic device that manipulates information or data. computer is made of Hardware and Software.

Motherboard, CPU, RAM, Hard Drive, Firmware...

上个世纪五六十年代，计算器刚刚兴起，由于硬件的限制，那时的计算机是巨型怪物，而且通常只能进行一类计算。后来随着晶体管的出现，可以以微型元件制作电路板，一块很小的电路板上安置了成千上万的电子元件。这也是我们目前的笔记本才几千克的重量却具有超强的计算能力的原因。

晶体显像管，晶体电子元件，与纳米技术的结合，物理技术的进步明显的改变了制造，改变了人类世界。每一年新的处理器的推出意味着现在物理技术依然在高速的进步发展。在物理技术进步的同时，软件技术也在不停的更新迭代。苹果系统基本每年都会出一个新的版本。从我 17 年入手 MacBook Pro 开始，我已经经历了 MacOS 10.12: Sierra- 2016. MacOS 10.13: High Sierra- 2017. MacOS 10.14: Mojave- 2018. and current one MacOS 10.15: Catalina- 2019.

## CPU

Central Processing Unit - 中央处理单元，提供运算能力，是一块电路板，其上有成千上万个电子元件。其运算过程一般包含四个步骤：fetch instructions, decode instructions, execute and writeback.

## Operating System

An Operating System is system software that manages computer hardware, software resources, and provides common services to computer programs.

OS usually provides Process, Device, Memory, File, I/O, Secondary-Storage management and Security, Job Accounting and control over system performance.

