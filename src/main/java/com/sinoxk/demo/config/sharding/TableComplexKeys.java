package com.sinoxk.demo.config.sharding;

import com.google.common.collect.*;
import com.sinoxk.demo.common.constant.Constant;
import io.shardingsphere.api.algorithm.sharding.*;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;

import java.time.LocalDate;
import java.util.*;

/**
 */
public class TableComplexKeys implements ComplexKeysShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> tables, Collection<ShardingValue> columns) {
        //没有任何分片键
        if(columns.size()==0){
            throw new UnsupportedOperationException();
        }
        Collection<String> result = new LinkedHashSet<>(tables.size());
        //具体表名称（连锁编号+时间）
        //获取连锁(不支持多连锁查询)
        Integer customerId = null;
        String table=null;
        Set<Integer> years = Sets.newLinkedHashSet();
        for (ShardingValue item:columns){
            table = item.getLogicTableName();
            //连锁
            if(item.getColumnName().equals(Constant.SHARDING_COMPLEXKEY_FIRST)){
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

            if(item.getColumnName().equals(Constant.SHARDING_COMPLEXKEY_SECOND)){
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
