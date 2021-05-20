package guava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class StopwatchTest {

    // Stopwatch 类提供了时间统计的功能，相当于帮你封装了调用 System.currentTimeMillis() 的逻辑。
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            //TODO 模拟业务逻辑
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long nanos = stopwatch.elapsed(TimeUnit.SECONDS);
        System.out.println(nanos);
    }
}
