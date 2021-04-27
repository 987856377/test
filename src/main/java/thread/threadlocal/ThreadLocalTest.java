package thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 单数据源控制器
 * @Project development
 * @Package com.spring.development.datasource
 * @Author xuzhenkui
 * @Date 2020/2/26 18:27
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> STRING_THREAD_LOCAL = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        for ( int i = 0; i < 10; i++){
             new Thread(() -> {
                 STRING_THREAD_LOCAL.set(String.valueOf(counter.addAndGet(1)));
                 System.out.println(Thread.currentThread().getName() + " value: " + STRING_THREAD_LOCAL.get());
             },"Thread-" + i + ": ").start();
        }
    }
}
