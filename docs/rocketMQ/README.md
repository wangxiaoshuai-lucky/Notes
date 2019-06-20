## rocketMQ
### 运行模型（kafka大同小异）
![模型](./imgs/1.jpg)  
### 基本概念
![运作](./imgs/2.jpg)
在部署RocketMQ时，会部署两种角色:NameServer和Broker。
NameServer主要做路由服务。生产者发送消息时，首先向NameServer拿到Topic的路由信息，即这个Topic在哪些Broker上有。
Consumer也是一样，需要知道消费队列的路由情况。当然不是每次收发消息都去NameServer查询一遍，简单的说只有第一次初始化，和以后发送或者接收出现问题时需要查询一下。
### 储存结构
![储存](./imgs/3.jpg)
（1）消息主体以及元数据都存储在**CommitLog**当中  
（2）Consume Queue相当于kafka中的partition，是一个逻辑队列，存储了这个Queue在CommiLog中的起始offset，log大小和MessageTag的hashCode。  
（3）每次读取消息队列先读取consumerQueue,然后再通过consumerQueue去commitLog中拿到消息主体。  
### 主要文件
* CommitLog：消息存放物理文件，每台broker上的commitLog被本机器所有queue共享不做区分
* consume queue：消息的逻辑队列，相当于字典的目录用来指定消息在消息的真正的物理文件commitLog上的位置
## 源码解析：
### NameServer
#### 核心属性：RouteInfoManager
~~~
    HashMap<String/* topic */, List<QueueData>> topicQueueTable;
    HashMap<String/* brokerName */, BrokerData> brokerAddrTable;
    HashMap<String/* clusterName */, Set<String/* brokerName */>> clusterAddrTable;
    HashMap<String/* brokerAddr */, BrokerLiveInfo> brokerLiveTable;
    HashMap<String/* brokerAddr */, List<String>/* Filter Server */> filterServerTable;
~~~
* QueueData:topic的broker描述：包括broker名字，读写队列数
* BrokerData:broker集群：包括集群和一个broker地址列表
* BrokerLiveInfo：心跳更新信息，包括更新时间
#### 路由注册
注册的时候携带参数：
* final String clusterName,集群名字
* final String brokerAddr,broker地址IP:PORT
* final String brokerName,broker名字
* final long brokerId,brokerId，确定主从关系
* final String haServerAddr,
* final TopicConfigSerializeWrapper topicConfigWrapper,topic的元数据
* final List<String> filterServerList,过滤服务器列表
* final Channel channel，broker连接通道  

broker启动时向所有NameServer发送一次心跳，之后每30s发送一次心跳包.  
处理流程：
* 将broker加入到集群中
* 更新broker的主从列表
* 如果是master，创建或者更新topic元数据
* 创建topic的queue列表，也就是消息路由
* 更新存活broker表
* 注册broker过滤服务器列表
* 注册完成
#### 路由删除
NameServer每10s遍历一次brokerLiveTable，如果更新时间比较久，删除这个broker相关信息  
需要检查的信息：
* 删除存活broker列表
* 删除此broker的过滤服务器列表
* 删除该broker地址在brokerAddrTable的信息,brokerName的主从集群
* 删除这个broker在集群中的信息
* 删除brokerName相关topic路由信息