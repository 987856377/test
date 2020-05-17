package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/14 12:56
 */
public class SyncAndReentrantLockOpt {

    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "decrement");
            for (int j = 0; j < 10; j++) {
                resource.print();
                System.out.println(j + " time");
            }
        },"Thread- " + " decrement -Running: ").start();
    }
}
class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1  = lock.newCondition();
    private Condition condition2  = lock.newCondition();
    private Condition condition3  = lock.newCondition();

    public void print() {
        lock.lock();
        int N = 0;

        try {
            //        1. 判断
            if (number == 1){
                N = 5;
                while (number != 1){
                    condition1.await();
                }
            } else if (number == 2){
                N = 10;
                while (number != 2){
                    condition2.await();
                }
            } else if (number == 3){
                N = 15;
                while (number != 3){
                    condition3.await();
                }
            }

//        2. 干活
            for (int i = 0; i < N; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i );
            }

//        3. 唤醒
            if (N == 5){
                number = 2;
                condition2.signal();
            } else if (N == 10) {
                number = 3;
                condition3.signal();
            } else if (N == 15) {
                number = 1;
                condition1.signal();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

