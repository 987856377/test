package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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

        for ( int i = 0; i < 10000; i++){
            new Thread(() -> {
                if (countDownLatch.getCount()>0){
                    System.out.println(Thread.currentThread().getName() + ": out " + countDownLatch.getCount());
                    countDownLatch.countDown();
                }
            },"Thread-"+i+": ").start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + ": end");
    }
}
