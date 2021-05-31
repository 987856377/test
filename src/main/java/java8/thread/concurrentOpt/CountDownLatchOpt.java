package java8.thread.concurrentOpt;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/12 15:37
 */

//  做减法
public class CountDownLatchOpt {

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(100);
//        Set<Long> set = Collections.synchronizedSet(new HashSet<>());
//
//        for ( int i = 0; i < 10; i++){
//            new Thread(() -> {
//                for (int j = 0; j < 10; j++) {
//                    if (countDownLatch.getCount()>0){
//                        countDownLatch.countDown();
//                        System.out.println(Thread.currentThread().getName() + ": out " + countDownLatch.getCount());
//                        set.add(countDownLatch.getCount());
//                    }
//                }
//            },"Thread-"+i+": ").start();
//        }
//
//        countDownLatch.await();
//
//        while (Thread.activeCount() > 2){
//            Thread.yield();
//        }
//        System.out.println(Thread.currentThread().getName() + ": end");
//
//        System.out.println(set.size());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 10, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(10));
        List<String> dates = new ArrayList<>();
        dates.add("18530320214");
        dates.add("13783939562");
        dates.add("13721768911");
        dates.add("13578185922");
        dates.add("13671526988");

        //多线程查询
        CountDownLatch cdl = new CountDownLatch(dates.size());
        dates.forEach(d -> {
            executor.submit(() -> {
                try {
                    doSend(d);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            });
        });

        try {
            //保证线程池中的所有的线程任务都完成后，主线程才会继续向下执行；
            cdl.await();
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> " + cdl.getCount());
    }

    public static void doSend(String d) {
        System.out.println("send sms to: " + d + " success");
    }

}
