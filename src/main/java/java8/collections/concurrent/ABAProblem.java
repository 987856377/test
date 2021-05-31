package java8.collections.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description
 * @Project test
 * @Package java8.collections.concurrent
 * @Author xuzhenkui
 * @Date 2020/5/11 19:28
 */
public class ABAProblem {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
//        ABAProblem.testAtomicReference();
        ABAProblem.AtomicStampedReference();
    }

    public static void testAtomicReference() {
        System.out.println("*********************** ABA ***********************");
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(100, 2020);
            System.out.println(Thread.currentThread().getName() + ": " + atomicReference.get());
        }, "Thread-1").start();

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
            System.out.println(Thread.currentThread().getName() + ": " + atomicReference.get());
        }, "Thread-2").start();
        System.out.println("*********************** ABA ***********************");
    }

    public static void AtomicStampedReference() {
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + ": 第一次版本号: " + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + ": 第二次版本号: " + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + ": 第三次版本号: " + atomicStampedReference.getStamp() + " 当前值: " + atomicStampedReference.getReference());
        }, "Thread-3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + ": 第一次版本号: " + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2020, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + ": 第二次版本号: " + atomicStampedReference.getStamp() + " 当前值: " + atomicStampedReference.getReference() + " 修改成功: " + result);
        }, "Thread-4").start();
    }
}
