package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.*;
import com.sinoxk.demo.common.constant.Constant;
import io.shardingsphere.api.algorithm.sharding.*;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;

import java.time.LocalDate;
import java.util.*;

/**
 * 表分片
 */
public class TableSharding implements ComplexKeysShardingAlgorithm {

    /**
     * @param tables 表
     * @param columns [{"columnName":"customer_id","logicTableName":"t_order","values":[2]},{"columnName":"year","logicTableName":"t_order","values":[2020]}]
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> tables, Collection<ShardingValue> columns) {

        //没有任何分片键
        if(columns.size()==0){
            throw new UnsupportedOperationException();
        }
        Collection<String> result = new LinkedHashSet<>(tables.size());
        Integer customerId = null;
        String table=null;
        Set<Integer> years = Sets.newLinkedHashSet();
        for (ShardingValue item:columns){
            table = item.getLogicTableName();
            //连锁
            if(item.getColumnName().equals(Constant.SHARDING_COMPLEXKEY_FIRST_CUSTOMER_ID)){
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

            if(item.getColumnName().equals(Constant.SHARDING_COMPLEXKEY_SECOND_YEAR)){
                if(item instanceof PreciseShardingValue){
                    int year = ((PreciseShardingValue<Integer>) item).getValue();
                    years.add((year));
                }
                if(item instanceof RangeShardingValue){
                    Range<Integer> range = ((RangeShardingValue) item).getValueRange();
                    int lower = range.lowerEndpoint();
                    int upper =  range.upperEndpoint();
                    for (int i=lower;i<=upper;i++){
                        years.add(i);
                    }
                }
                if(item instanceof ListShardingValue){
                    ((ListShardingValue<Integer>) item).getValues().forEach(v-> years.add(v));
                }
            }
        }
        if(Objects.isNull(customerId)){
            throw new RuntimeException("未命中相对应连锁");
        }

        //构造表
        //如果没有命中时间
        if(years.isEmpty()){
            int now = LocalDate.now().getYear();
            while (now>= Constant.MIN_START_YEAR){
                years.add(now--);
            }
        }
        for (int y:years){
            result.add(table+"_"+customerId+"_"+y);
        }
        return result;
    }
}
