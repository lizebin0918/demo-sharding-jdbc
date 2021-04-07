package com.sinoxk.demo.common.constant;
/**
 * 常量<br/>
 * Created on : 2020-05-22 15:25
 * @author chenpi 
 */
public class Constant {

    /**
     * sharding dataSource:必须是这个名字
     */
    public static final String SHARDING_DATA_SOURCE = "shardingDataSource";

    /**
     * sharding 事务相关
     */
    public static final String SHARDING_TRANSACTION_MANAGER = "ShardingTransactionManager";

    /**
     * admin dataSource
     */
    public static final String ADMIN_DATA_SOURCE = "adminDataSource";

    /**
     * sharding-jdbc复合分片键
     */
    public static final String SHARDING_COMPLEXKEY_FIRST_CUSTOMER_ID = "customer_id";

    /**
     * sharding-jdbc复合分片键
     */
    public static final String SHARDING_COMPLEXKEY_SECOND_YEAR = "year";

    /**
     * 逻辑表
     */
    public static final String LOGIC_TABLE_ORDER = "t_order";

    /**
     * 系统支持最小的年份
     */
    public static final int MIN_START_YEAR = 2016;

}
