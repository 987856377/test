package java8.thread.concurrentOpt;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/12 13:37
 */
public class ReentrantReadWriteLockOpt {
    public static void main(String[] args) {

        Resource resource = new Resource();

        for ( int i = 0; i < 5; i++){
            final int tmp = i;
            new Thread(() -> {
                resource.write(tmp+"",tmp+"");
            },"Thread-write-"+i+": ").start();
        }

        for ( int i = 0; i < 50; i++){
            final int tmp = i;
            new Thread(() -> {
                resource.read(tmp+"");
            },"Thread-read-"+i+": ").start();
        }


//        AtomicInteger integer = new AtomicInteger(10);
//
//        for ( int i = 0; i < 200; i++){
//            new Thread(() -> {
////                System.out.println("before: " + integer.get());
//                if (integer.getAndDecrement() > 0){
//                    System.out.println("after: " + integer.get());
//                }
//            },"Thread-"+i+": ").start();
//        }

    }
}

class Resource{
    private volatile Map map = new HashMap();
//    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write(Object key, Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "is writing: " + key);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "write success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void read(Object key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "is reading: " + key);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "read success " + o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}

