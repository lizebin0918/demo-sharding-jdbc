package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import com.sinoxk.demo.common.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

import static com.sinoxk.demo.common.constant.Constant.LOGIC_TABLE_ORDER;

/**
 * 表分片
 */
@Slf4j
public class TableSharding implements ComplexKeysShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> tables, ComplexKeysShardingValue<Integer> complexKeysShardingValue) {

        log.info("TableSharding.complexKeysShardingValue --> " + JSON.toJSONString(complexKeysShardingValue));

        List<String> returnTables = new LinkedList<>();
        String logicTable = complexKeysShardingValue.getLogicTableName();
        if (!LOGIC_TABLE_ORDER.equalsIgnoreCase(logicTable)) {
            return Collections.emptyList();
        }

        List<String> tablePart = new ArrayList<>(3);
        Collection<Integer> customerIds = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get(Constant.SHARDING_COMPLEXKEY_FIRST_CUSTOMER_ID);
        Collection<Integer> years = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get(Constant.SHARDING_COMPLEXKEY_SECOND_YEAR);
        for (int customerId : customerIds) {
            for (int year : years) {
                tablePart.add(logicTable);
                tablePart.add(Objects.toString(customerId));
                tablePart.add(Objects.toString(year));
                returnTables.add(String.join("_", tablePart));
                tablePart.clear();
            }
        }
        return returnTables;
    }
}
