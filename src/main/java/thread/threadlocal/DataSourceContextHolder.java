package thread.threadlocal;


/**
 * 配制多数据库
 * @author admin
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSource> contextHolder = new ThreadLocal<DataSource>();

    public static void setDataSource(DataSource datasource) {
        contextHolder.set(datasource);
    }

    public static DataSource getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }

}
