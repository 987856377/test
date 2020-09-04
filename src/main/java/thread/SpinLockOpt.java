package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/12 13:05
 */
public class SpinLockOpt {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        System.out.println(Thread.currentThread().getName()+": invoke lock");

        while (!atomicReference.compareAndSet(null,Thread.currentThread())){
            System.out.println(Thread.currentThread().getName()+": retry CAS");
        }
    }

    public void unlock(){
        System.out.println(Thread.currentThread().getName()+": invoke unlock");
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }

    public static void main(String[] args) {
        SpinLockOpt spinLockOpt = new SpinLockOpt();

        new Thread(() -> {
            spinLockOpt.lock();
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockOpt.unlock();
        },"Thread-1").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            spinLockOpt.lock();
            spinLockOpt.unlock();
        },"Thread-2").start();
    }
}
