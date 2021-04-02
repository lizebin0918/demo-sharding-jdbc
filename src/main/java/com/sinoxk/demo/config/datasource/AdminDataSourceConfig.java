package com.sinoxk.demo.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.sinoxk.demo.common.constant.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * 管理库数据源<br/>
 * Created on : 2021-04-02 11:28
 * @author chenpi 
 */
@Configuration
public class AdminDataSourceConfig {

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
}
