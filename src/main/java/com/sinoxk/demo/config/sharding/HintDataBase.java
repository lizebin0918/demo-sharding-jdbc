package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.ShardingValue;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;


public class HintDataBase implements HintShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection collection, HintShardingValue hintShardingValue) {
        System.out.println(">>>>>>>>>>>>>>HintDataBase");
        System.out.println(JSON.toJSONString(collection));
        System.out.println(JSON.toJSONString(hintShardingValue));
        System.out.println(">>>>>>>>>>>>>>HintDataBase");
        return collection;
    }
}