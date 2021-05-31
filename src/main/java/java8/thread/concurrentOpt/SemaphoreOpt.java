package java8.thread.concurrentOpt;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/12 16:16
 */

//  Semaphore 是 synchronized 的加强版，作用是控制线程的并发数量。
public class SemaphoreOpt {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3); // 模拟三个停车位

        for ( int i = 0; i < 9; i++){     // 模拟九部汽车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ": 抢到车位");
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + ": 离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            },"Thread-"+i+": ").start();
        }
    }
}
