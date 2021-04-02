package com.sinoxk.demo.config.sharding;

import com.google.common.collect.Lists;
import io.shardingsphere.api.algorithm.sharding.*;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;

import java.util.*;

/**
 */
public class TableSimpleKeys implements ComplexKeysShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> tables, Collection<ShardingValue> columns) {
        //没有任何分片键
        if(columns.size()==0){
            throw new UnsupportedOperationException();
        }
        Collection<String> result = new LinkedHashSet<>(tables.size());
        //获取连锁(不支持多连锁查询)
        Integer customerId = null;
        String table=null;
        for (ShardingValue item:columns){
            table = item.getLogicTableName();
            //连锁
            if(item.getColumnName().equals("customer_id")){
                if(item instanceof PreciseShardingValue){
                    customerId = ((PreciseShardingValue<Integer>) item).getValue();
                }
                if(item instanceof RangeShardingValue){
                    customerId = ((RangeShardingValue<Integer>) item).getValueRange().lowerEndpoint();
                }
                if(item instanceof ListShardingValue){
                    customerId = Lists.newArrayList(((ListShardingValue<Integer>) item).getValues()).get(0);
                }
            }
            result.add(table+"_"+customerId);
        }

        if(Objects.isNull(customerId)){
            throw new RuntimeException("未命中相对应连锁");
        }
        return result;
    }
}
