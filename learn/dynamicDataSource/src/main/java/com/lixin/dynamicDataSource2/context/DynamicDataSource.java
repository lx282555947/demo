//package com.lixin.dynamicDataSource2.context;
//
//import com.lixin.dynamicDataSource2.context.DatabaseContextHolder;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//public class DynamicDataSource extends AbstractRoutingDataSource {
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return DatabaseContextHolder.getDatabaseType();
//    }
//}
