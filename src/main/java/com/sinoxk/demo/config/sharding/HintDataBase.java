package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;

import java.util.Collection;

public class HintDataBase implements HintShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, ShardingValue shardingValue) {
        System.out.println(">>>>>>>>>>>>>>HintDataBase");
        System.out.println(JSON.toJSONString(collection));
        System.out.println(JSON.toJSONString(shardingValue));
        System.out.println(">>>>>>>>>>>>>>HintDataBase");
        return collection;
    }
}