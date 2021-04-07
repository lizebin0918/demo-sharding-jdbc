package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import com.sinoxk.demo.cache.AdminCache;
import com.sinoxk.demo.common.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

import static com.sinoxk.demo.common.constant.Constant.LOGIC_TABLE_ORDER;


/**
 * 数据库路由
 */
@Slf4j
public class DatabaseSharding implements ComplexKeysShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Integer> complexKeysShardingValue) {

        log.info("DatabaseSharding.complexKeysShardingValue --> " + JSON.toJSONString(complexKeysShardingValue));

        List<String> database = new LinkedList<>();
        String logicTable = complexKeysShardingValue.getLogicTableName();
        if (!LOGIC_TABLE_ORDER.equalsIgnoreCase(logicTable)) {
            return Collections.emptyList();
        }
        Collection<Integer> customerIds = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get(Constant.SHARDING_COMPLEXKEY_FIRST_CUSTOMER_ID);
        Collection<Integer> years = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get(Constant.SHARDING_COMPLEXKEY_SECOND_YEAR);
        //可以映射多个库
        AdminCache.Key key;
        for (int customerId : customerIds) {
            for (int year : years) {
                key = new AdminCache.Key(customerId, year);
                database.add(AdminCache.getDbName(key));
            }
        }
        return database;
    }
}