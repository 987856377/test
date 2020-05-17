package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Project test
 * @Package keyword
 * @Author xuzhenkui
 * @Date 2020/5/11 13:57
 */

class Data {
    volatile int num = 0;
    AtomicInteger integer = new AtomicInteger();

    public void setNum(int num){
        this.num = num;
    }

    public void addBy(){
        this.num++;
    }

    public void addAtomic(){
        this.integer.getAndIncrement();
    }
}

public class VolatileOpt {
    public static void main(String[] args) {
        VolatileOpt opt = new VolatileOpt();
//        opt.validVolatileVisible();
        opt.validVolatileAtomic();
    }

    /*
        验证 volatile 可见性
        volatile 可以保证可见性,及时通知其他线程主物理内存的值已修改
        */
    public void validVolatileVisible(){
        Data data = new Data();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": begin");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            data.setNum(56);
            System.out.println(Thread.currentThread().getName() + " num: " + data.num);
        },"Thread-validVolatileVisible-Running").start();

        while (data.num == 0){}

        System.out.println(Thread.currentThread().getName() + ": end");
    }

    /*
        验证 volatile 原子性

        */
    public void validVolatileAtomic(){
        Data data = new Data();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.addBy();
                    data.addAtomic();
                }
            },"Thread-Running-" + String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + ": final value: " + data.num);
        System.out.println(Thread.currentThread().getName() + ": final value: " + data.integer);
    }
}

