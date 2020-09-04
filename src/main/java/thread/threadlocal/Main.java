package thread.threadlocal;

/**
 * @Description
 * @Project test
 * @Package Thread.ThreadLocal
 * @Author xuzhenkui
 * @Date 2020/1/17 10:09
 */
public class Main {
    public static void main(String[] args) {
        DataSourceContextHolder.setDataSource(DataSource.EMR);
        System.out.println(DataSourceContextHolder.getDataSource());
    }
}
