## Q1：什么是 CopyOnWriteArraySet 怎么使用
https://www.cnblogs.com/xiaolovewei/p/9142046.html

它是线程安全的无序的集合，可以将它理解成线程安全的HashSet
CopyOnWriteArraySet和HashSet虽然都继承于共同的父类AbstractSet；
但是，HashSet是通过“散列表(HashMap)”实现的，
而CopyOnWriteArraySet则是通过“动态数组(CopyOnWriteArrayList)”实现的，并不是散列表

CopyOnWriteArraySet具有以下特性：

    1. 它最适合于具有以下特征的应用程序：Set 大小通常保持很小，只读操作远多于可变操作，需要在遍历期间防止线程间的冲突。
    2. 它是线程安全的。
    3. 因为通常需要复制整个基础数组，所以可变操作（add()、set() 和 remove() 等等）的开销很大。
    4. 迭代器支持hasNext(), next()等不可变操作，但不支持可变 remove()等 操作。
    5. 使用迭代器进行遍历的速度很快，并且不会与其他线程发生冲突。在构造迭代器时，迭代器依赖于不变的数组快照。

 