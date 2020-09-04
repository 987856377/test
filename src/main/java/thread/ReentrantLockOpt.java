package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/12 12:31
 */

//    ReentrantLock 和 synchronized 是典型的可重入锁
//    可重入锁(递归锁):
//      同一个线程,在外层方法获得锁后,在进入内层方法会自动获得锁
//      避免死锁


    /*
         Lock 和 synchronized 有什么区别? 用新的 Lock 有什么好处? 举例
         1. 原始构成:
            synchronized 属于JVM层, 是关键字,
                反编译后, 由 monitorenter 和 monitorexit 控制
                monitorenter(底层通过 monitor 对象控制, wait/notify 也依赖于 monitor 对象, 只有在同步块或方法中才能调用 wait/notify 方法)
            Lock 是具体类, api层面的锁

         2. 使用方法:
                synchronize 不需要手动释放, 当 synchronize 代码块执行完成后系统会自动让线程释放对锁的占用
                ReentrantLock 需要手动释放, 如果没有释放, 可能造成死锁, 需要 lock()/unlock() 方法配合 try/catch/finally 语句完成
         3. 等待是否可中断:
                synchronized 不可中断, 除非抛出异常或正常运行完成
                ReentrantLock 可中断, 1. 设置超时方法 trylock(long timeout, TimeUnit unit);
                                      2. lockInterruptibly() 放代码块中, 调用 interrupt() 方法可中断
         4. 加锁是否公平:
                synchronized: 非公平锁
                ReentrantLock: 两者都可以, 默认非公平锁, 可通过构造方法改变
         5. 锁绑定多个 Condition:
                synchronized 没有
                ReentrantLock 用来实现分组唤醒需要唤醒的线程, 可以精确唤醒, 而不是像 synchronized 要么随机唤醒,要么唤醒全部
      */
public class ReentrantLockOpt {

    public static void main(String[] args) {
        Phone phone = new Phone();

        for ( int i = 0; i < 2; i++){
            new Thread(() -> {
                phone.sendSms();
            },"Thread-"+i+": ").start();
        }

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();

        new Thread(phone,"t3").start();
        new Thread(phone,"t4").start();
    }
}

class Phone implements Runnable{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    // 加锁几次, 就解锁几次, 能编译通过,能运行成功;
    // 1. 加锁一次, 解锁两次 IllegalMonitorStateException;
    // 2. 加锁两次, 解锁一次 卡死

    public void get(){
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+": invoke get");
            set();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+": invoke set");
        } finally {
            lock.unlock();
        }
    }

    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName()+": sendSms");
        sendMail();
    }

    public synchronized void sendMail(){
        System.out.println(Thread.currentThread().getName()+": sendMail");
    }
}

