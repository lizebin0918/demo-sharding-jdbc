# sharding-jdbc 实现分库分表，可动态配置（需重启）

## 官网地址
* https://shardingsphere.apache.org/document/current/cn/overview/

### 常见问题
* 表连接（join）
* group by 性能较差
* 如何避免热点数据（hash/range/预定义）
* 根据业务设计好路由库->路由表

### 基础概念

* 基于JDBC封装，工作在客户端
* 优点：性能相对较好，支持跨库
* 缺点：SQL语句兼容性较差
* 功能点
    * 分库分表
    * 读写分离
    * 分片策略定制化
    * 无中心化分布式主键
* `LogicTable`:逻辑表
* `ShardingColumn`:分片键
* `ActualTable`:物理表
* `DataNode`:数据节点（DB1.t_user）
* 全局表（广播表），我们业务所说的字典表，每一个库冗余一份
* 绑定表（从属关系）：order/order_detail

### 核心概念
* 分片键：分片字段
* 分片算法：精确分片算法（每一行数据到对应分片）、范围分片算法、复合分片算法、
* 分片策略：分片键 + 分片算法
* SQL Hint
    
### 使用
* 引入相关依赖，当前项目基于3.0
* 配置多个数据源
* 指定默认数据库，并建立逻辑表（是否必须？）
* 自定义分库策略
* 自定义分表策略
* `ShardingDataSourceFactory.createDataSource()`创建对外的DataSource
