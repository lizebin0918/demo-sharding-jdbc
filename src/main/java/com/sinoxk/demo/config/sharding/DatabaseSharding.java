package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collection;


/**
 *
 */
@Slf4j
public class DatabaseSharding implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        System.out.println("DatabaseSharding>>>>>>>>>>>");
        System.out.println(JSON.toJSONString(availableTargetNames));
        System.out.println(JSON.toJSONString(shardingValues));
        System.out.println("DatabaseSharding>>>>>>>>>>>");
        return Arrays.asList("db0", "db1");
    }
}
