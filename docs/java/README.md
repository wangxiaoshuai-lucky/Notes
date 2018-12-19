## Java基础： 
### 集合容器以及底层实现原理  
* ArrayList、Vector（线程安全）底层数组实现，使用数据的移动位置来增删元素  
* Stack继承vector，加在最后，弹出最后  
* queue队列先进先出
* HashMap  
计算方法：hashcode和本身右移16位的异或运算,再用结果与数组大小&运算得到最终到达的槽位  
***数组大小设置为2的n次幂***：这样 n - 1 全为每位全为1，&的结果就冲突小
如果这个槽位中节点的个数多于8个，那么将这个槽位的链表转换成红黑树 
* HashSet  
内部有一个HashMap，只是每次put同一个value占位  
* LinkedHashMap  
重写newNode方法：新建节点是继承map的节点，多了前后的指针属性  
在新建节点的时候把此节点连接到链表后面  
***访问顺序排序***：accessOrder设置为true按照访问顺序输出，最近访问的会换到链尾  
* LinkedHashSet  
初始化一个LinkedHashMap，跟HashSet一样存储  
* TreeMap  
红黑树存储节点  
* TreeSet 
内部有一个TreeMap
### String类相关知识点
* 存储方式  
new String("abc")数据存到堆内存  
String a = "abc";字符串是存到方法区  
* 正则表达式
### 初始化顺序的执行顺序
1先类层次的，父类到子类的所有类层次的初始化完毕；    
2再执行父类到子类的所有实例层次上的初始化；  
3先执行初始化块，再执行构造函数  
### 接口和类的理解  
* 抽象类和接口的区别  
接口方法是public abstract,变量为public static final 
### 反射机制和内省机制  
反射机制运行时获取class参数，变量之类的  
内省机制获取变量的getter&setter方法  
### java的序列化  
将实例对象（内存对象）保存到磁盘静态对象字节序列，可以用于网络传输实例对象。  