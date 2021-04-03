# sharding-jdbc 实现分库分表，可动态配置（需重启）

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
    * 分片算法（用于分库、分表都可以
    * 全局表（广播表），我们业务所说的字典表，每一个库冗余一份
    * ER表（从属关系）：order/order_detail
    
     
