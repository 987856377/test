package runtime;

import java.util.concurrent.*;

/**
 * @Description
 * @Project test
 * @Package runtime
 * @Author xuzhenkui
 * @Date 2020/5/1 22:54
 */
public class ScheduledThreadPoolOperator {
    private ScheduledExecutorService scheduledExecutorService;

    public ScheduledThreadPoolOperator() {
        scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
    }

//    启动监控服务, 监控内存信息
    public void start(){
        System.out.println(String.format("启动监控服务: %s",Thread.currentThread().getName()));
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("最大内存: %dm  已分配内存: %dm  已分配内存中剩余空间: %dm  最大可用内存: %dm",
                        Runtime.getRuntime().maxMemory() / 1024 / 1024,
                        Runtime.getRuntime().maxMemory() / 1024 / 1024,
                        Runtime.getRuntime().maxMemory() / 1024 / 1024,
                        (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024
                        ));
            }
        },2,2, TimeUnit.SECONDS);

    }

//    释放资源(来源于 flume 源码)
//    主要用于关闭线程池
    public void stop(){
        System.out.println(String.format("开始关闭线程池: %s",Thread.currentThread().getName()));
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            try {
                scheduledExecutorService.awaitTermination(10,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!scheduledExecutorService.isTerminated()){
                scheduledExecutorService.shutdownNow();
                try {
                    while (!scheduledExecutorService.isTerminated()){
                        scheduledExecutorService.awaitTermination(10,TimeUnit.SECONDS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(String.format("关闭线程池完成: %s",Thread.currentThread().getName()));
    }
}
