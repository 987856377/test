package Thread.threadpool;

import java.util.concurrent.*;

/**
 * @Description
 * @Project test
 * @Package Thread.threadpool
 * @Author xuzhenkui
 * @Date 2020/5/14 16:19
 */
public class ExecutorsOpt {

    /*
        (1) newFixedThreadPool 和 newSingleThreadExecutor
            允许的请求队列长度为Integer.MAX_VALUE, 可能会堆积大量的请求, 从而导致OOM
        (2) newCachedThreadPool 和 newScheduledThreadPool
            允许的创建线程数量为Integer.MAX_VALUE, 可能会创建大量线程, 从而导致OOM
    */
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);  // 一池五线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();// 一池一线程
//        ExecutorService executorService = Executors.newCachedThreadPool();  // 一池N线程
//        ExecutorService executorService = Executors.newScheduledThreadPool(5);  // 带有定时器的线程池
        ExecutorService executorService = new ThreadPoolExecutor(2,5,30L,TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

//        for (int i = 0; i < 100000; i++) {
//            ThreadPoolExecutorFactory.getThreadPoolExecutor().execute(() -> {
//                System.out.println(Thread.currentThread().getName() + "新建业务");
//            });
//        }


        try {
            for ( int i = 0; i < 6; i++){
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "处理业务");
                });
//                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
