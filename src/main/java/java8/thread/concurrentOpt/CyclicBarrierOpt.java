package java8.thread.concurrentOpt;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/12 15:55
 */
/*
CyclicBarrier的await()方法：
        这个方法除了抛出InterruptedException异常外，还会抛出BrokenBarrierException。

        BrokenBarrierException表示当前的CyclicBarrier已经损坏了，可能等不到所有线程都到达栅栏了，所以已经在等待的线程也没必要再等了，可以散伙了。

        出现以下几种情况之一时，当前等待线程会抛出BrokenBarrierException异常：

        其它某个正在await等待的线程被中断了
        其它某个正在await等待的线程超时了
        某个线程重置了CyclicBarrier(调用了reset方法)
        另外，只要正在Barrier上等待的任一线程抛出了异常，那么Barrier就会认为肯定是凑不齐所有线程了，
        就会将栅栏置为损坏（Broken）状态，并传播BrokenBarrierException给其它所有正在等待（await）的线程。

*/

public class CyclicBarrierOpt {

    public static void main(String[] args) {
        final int N = 10;

//        parties就是之前说的需要满足的计数总数; Runnable任务其实就是当最后一个线程到达栅栏时，后续立即要执行的任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("Get Ready");
            }
        });

//        线程到达栅栏时会被阻塞(调用await方法)，直到到达栅栏的线程数满足指定数量要求时，栅栏才会打开放行。
        for ( int i = 0; i < N; i++){
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": 准备完成");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "-InterruptedException: 被中断");
                } catch (BrokenBarrierException e) {
                    System.out.println(Thread.currentThread().getName() + "-BrokenBarrierException: 突破栅栏");
                }
            }, "Thread-" + i + ": ");
            thread.start();
            if (i == 3) {
                thread.interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName() + ": end");
    }
}
