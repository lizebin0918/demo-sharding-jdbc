package com.sinoxk.demo.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.sinoxk.demo.common.constant.Constant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 管理库数据源<br/>
 * Created on : 2021-04-02 11:28
 * @author chenpi 
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.jdbc.datasource.admin.username}")
    private String username;

    @Value("${spring.jdbc.datasource.admin.driver-class-name}")
    private String driverName;

    @Value("${spring.jdbc.datasource.admin.password}")
    private String password;

    @Value("${spring.jdbc.datasource.admin.url}")
    private String url;

    @Value("${spring.jdbc.datasource.admin.type}")
    private String type;

    @Value("${spring.jdbc.datasource.admin.max-wait:3000}")
    private long maxWait;

    @Bean(name = Constant.ADMIN_DATA_SOURCE)
    public DataSource adminDataSource() throws Exception {
        Class classes = Class.forName(type);
        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder.create().driverClassName(driverName)
            .type(classes)
            .url(url).username(username).password(password).build();
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }

    /*------------------------------放在这里实例化不会报错，放在ShardingMybatisConfig加载会报错-------------------*/

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier(Constant.SHARDING_DATA_SOURCE) DataSource shardingDataSource) throws Exception {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(shardingDataSource);
        factory.setTypeAliasesPackage("com.sinoxk.demo.dao.entity");
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        resolver.getResources("classpath:mapper/*.xml");
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory.getObject();
    }

}
