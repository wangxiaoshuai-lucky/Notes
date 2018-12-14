# 春招知识点准备  
## Java基础： 
* 集合容器以及底层实现原理  
    * List
        * ArrayList
        * Vector
        * Stack
        * queue
    * Set
        * HashSet
        * LinkedHashSet
        * TreeSet
    * Map
        * HashMap
        * LinkedHashMap
        * TreeMap
* String类相关知识点
    * 存储方式
    * 正则表达式
* 初始化顺序的执行顺序
* 接口和类的理解
    * 抽象类和接口的区别
* 反射机制和内省机制  
* java的序列化

## JVM相关知识点
* java内存模型：工作内存和主内存
* 内存结构及其作用
* GC的算法
    * 新生代、老年代、永久代
* 类加载机制
    * 各个阶段（7个阶段）的工作流程
    * 双亲委派模式  

## 多线程、锁
* 线程池
    * 使用好处
    * 实现原理（线程复用、管理线程）
    * 拒绝策略
* 锁分类
    * 悲观锁/乐观锁
    * 公平锁/非公平锁
    * 独享锁/共享锁
    * 自旋锁/自适应自旋锁
    * 偏向锁/轻量级锁/重量级锁
* volatile关键字
* synchronized关键字和Lock的使用区别
* synchronized的锁
    * 对象头信息中有关标志位
    * 锁升级过程
        * 偏向锁 =\> 轻量级锁
        * 轻量级锁 =\> 重量级锁
* AQS的实现原理
* 独占锁（ReentrantLock）的实现原理
* 共享锁（ReentrantReadWriteLock）的实现原理

## spring框架的理解
* IOC和DI的原理和源码分析
* AOP的实现原理
* Autowired的注入过程

## springMvc的实现原理
* 接口地址和方法的映射过程
* @ResponseBody的处理
* @RequestMapping的处理

## Mybatis
* sql语句和方法的映射原理
* \#｛｝ 和 \$｛｝的区别

## mysql（InnoDB）
* 存储方式
    * .frm文件
    * .idb文件
* 数据类型及其区别
    * varchar和char的区别
    * text和BLOB的区别
* 索引分类
    * 主键
    * 唯一索引
    * 普通索引
    * 复合索引
    * 全文索引
* 索引实现原理（B+树）
    * 聚集索引
    * 非聚集索引（辅助索引）
* 存储的物理结构和逻辑结构