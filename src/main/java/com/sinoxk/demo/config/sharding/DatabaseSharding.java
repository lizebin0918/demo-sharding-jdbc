package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import com.sinoxk.demo.cache.AdminCache;
import com.sinoxk.demo.common.constant.Constant;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static com.sinoxk.demo.common.constant.Constant.LOGIC_TABLE_ORDER;


/**
 * 数据库路由
 */
@Slf4j
public class DatabaseSharding implements ComplexKeysShardingAlgorithm {

    /**
     * @param availableTargetNames 数据库列表
     * @param shardingValues [{"columnName":"customer_id","logicTableName":"t_order","values":[2]},{"columnName":"year","logicTableName":"t_order","values":[2016]}]
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        List<String> database = new LinkedList<>();
        AdminCache.Key key = new AdminCache.Key();
        for (ShardingValue sv : shardingValues) {
            String columnName = sv.getColumnName(), logicTableName = sv.getLogicTableName();
            Collection<Integer> values = ((ListShardingValue<Integer>)sv).getValues();
            if (values.isEmpty() || !LOGIC_TABLE_ORDER.equalsIgnoreCase(logicTableName)) {
                continue;
            }
            if (Constant.SHARDING_COMPLEXKEY_FIRST_CUSTOMER_ID.equals(columnName)) {
                key.setCustomerId(values.stream().findFirst().get());
            }
            if (Constant.SHARDING_COMPLEXKEY_SECOND_YEAR.equals(columnName)) {
                key.setYear(values.stream().findFirst().get());
            }
        }
        database.add(AdminCache.getDbName(key));
        System.out.println(database);
        return database;
    }
}
