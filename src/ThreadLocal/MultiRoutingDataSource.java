//package ThreadLocal;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
///**
// * 多数据源路由
// * @author admin
// */
//public class MultiRoutingDataSource extends AbstractRoutingDataSource {
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//
//        DataSource db = DataSourceContextHolder.getDataSource();
//        return db;
//    }
//
//}
