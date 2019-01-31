//package com.lixin.dynamicDataSource2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration // 该注解类似于spring配置文件
//public class MyBatisConfig {
//    /**
//     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
//     */
//    @Bean
//    public DataSource myTestDbDataSource() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
//        props.put("url", env.getProperty("jdbc.url"));
//        props.put("username", env.getProperty("jdbc.username"));
//        props.put("password", env.getProperty("jdbc.password"));
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//    @Bean
//    public DataSource myTestDb2DataSource() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", env.getProperty("jdbc2.driverClassName"));
//        props.put("url", env.getProperty("jdbc2.url"));
//        props.put("username", env.getProperty("jdbc2.username"));
//        props.put("password", env.getProperty("jdbc2.password"));
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//    /**
//     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
//     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
//     */
//    @Bean
//    @Primary
//    public DynamicDataSource dataSource(@Qualifier("myTestDbDataSource") DataSource myTestDbDataSource,
//                                        @Qualifier("myTestDb2DataSource") DataSource myTestDb2DataSource) {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(DatabaseType.mytestdb, myTestDbDataSource);
//        targetDataSources.put(DatabaseType.mytestdb2, myTestDb2DataSource);
//
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
//        dataSource.setDefaultTargetDataSource(myTestDbDataSource);// 默认的datasource设置为myTestDbDataSource
//
//        return dataSource;
//    }
//
//    /**
//     * 根据数据源创建SqlSessionFactory
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
//        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
//        fb.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//
//
//        return fb.getObject();
//    }
//
//    /**
//     * 配置事务管理器
//     */
//    @Bean
//    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
