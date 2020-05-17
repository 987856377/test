package Thread.consumer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Project test
 * @Package Thread.consumerAndProducer.blockqueue
 * @Author xuzhenkui
 * @Date 2020/5/14 13:27
 */

/*
    synchronized ---> ReentrantLock ---> BlockingQueue
* */
public class Consumer {
    public static void main(String[] args) {
        BlockingResource resource = new BlockingResource(new ArrayBlockingQueue(5));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread- produce -Running: ").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                resource.consumer();
                System.out.println();
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread- consumer -Running: ").start();

        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("boss 结束生产");
        resource.stop();
    }
}

class BlockingResource {
    private volatile boolean FLAG = true;
    private AtomicInteger value = new AtomicInteger();
    private BlockingQueue blockingQueue = null;

    public BlockingResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = value.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "插入: " + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "插入: " + data + "失败");
            }
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(Thread.currentThread().getName() + "\t生产结束");
    }

    public void consumer() throws InterruptedException {
        String result;
        while (FLAG){
            result = (String) blockingQueue.poll(2L, TimeUnit.SECONDS);
            if ("".equals(result) || result == null){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t超过两秒没有取到数据, 退出");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t消费"+result+"成功");
            }
        }
    }

    public void stop() {
        FLAG = false;
    }
}
