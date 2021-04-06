package com.sinoxk.demo.config.sharding;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Arrays;
import java.util.Collection;


/**
 *
 */
@Slf4j
public class DatabaseSharding implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
        System.out.println("DatabaseSharding>>>>>>>>>>>");
        System.out.println(JSON.toJSONString(collection));
        System.out.println(JSON.toJSONString(complexKeysShardingValue));
        System.out.println("DatabaseSharding>>>>>>>>>>>");
        return Arrays.asList("db0");
    }
}
