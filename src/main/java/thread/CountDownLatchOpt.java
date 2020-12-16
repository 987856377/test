package thread;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Set<Long> set = Collections.synchronizedSet(new HashSet<>());

        for ( int i = 0; i < 10; i++){
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    if (countDownLatch.getCount()>0){
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + ": out " + countDownLatch.getCount());
                        set.add(countDownLatch.getCount());
                    }
                }
            },"Thread-"+i+": ").start();
        }

        countDownLatch.await();

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ": end");

        System.out.println(set.size());
    }
}
