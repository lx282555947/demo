package com.lixin.dynamicDataSource1.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lixin.dynamicDataSource1.enums.DataSourceKey;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
public class DynamicDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "multiple.datasource.master")//此处的"multiple.datasource.master"需要你在application.properties中配置，详细信息看下面贴出的application.properties文件。
    public DataSource dbMaster() {
        DataSource masterDb = DataSourceBuilder.create().build();
        return masterDb;
    }

    @Bean
    @ConfigurationProperties(prefix = "multiple.datasource.slave")
    public DataSource dbSlave() {
        DataSource slave = DataSourceBuilder.create().build();
        return slave;
    }


    /**
     * 核心动态数据源
     *
     * @return 数据源实例
     */
    @Bean
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setDefaultTargetDataSource(dbMaster());
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(DataSourceKey.DB_MASTER, dbMaster());
        dataSourceMap.put(DataSourceKey.DB_SLAVE1, dbSlave());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

}
