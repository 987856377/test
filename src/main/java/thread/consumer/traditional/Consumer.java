package thread.consumer.traditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Project test
 * @Package Thread.consumer_provider.traditional
 * @Author xuzhenkui
 * @Date 2020/5/14 11:53
 */
public class Consumer {

    public static void main(String[] args) {
        Resource resource = new Resource();


        for ( int i = 0; i < 10; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "increment");
                for (int j = 0; j < 5; j++) {
                    resource.increment();
                }
            },"Thread- " + i + " increment -Running: ").start();
        }

        for ( int i = 0; i < 10; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "decrement");
                for (int j = 0; j < 5; j++) {
                    resource.decrement();
                }
            },"Thread- " + i + " decrement -Running: ").start();
        }
    }
}

class Resource{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition  = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            //        1. 判断
            while (number != 0){
//            等待,不能生产
                condition.await();
            }

//        2. 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

//        3. 唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            //        1. 判断
            while (number == 0){
//            等待,不能生产
                condition.await();
            }

//        2. 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

//        3. 唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
