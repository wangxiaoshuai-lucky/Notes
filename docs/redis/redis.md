## redis知识点
### 5中数据结构(string, list, set, hash, zset)
* string： 字符串类型
* list：链表类型
* set：哈希表
* hash：字典（哈希表）
* zset：跳跃表实现
### redis持久化（RDB、AOF）
* RDB：把当前内存中的数据集快照写入磁盘，也就是 Snapshot 快照（数据库中所有键值对数据）。恢复时是将快照文件直接读到内存里。
* AOF：redis会将每一个收到的写命令都通过write函数追加到文件中(默认是 appendonly.aof)，当redis重启时会通过重新执行文件中保存的写命令来在内存中重建整个数据库的内容。
### zset的数据结构
跳跃表实现
### setnx实现分布式锁
加锁时只有一个线程能设置成功，其他线程设置失败自旋等待，解锁时删除该键。
### 相邻运行（不保证原子性）
jedis的事务，multi开启事务，最后执行操作。