package java8.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Project test
 * @Package java8.collections
 * @Author xuzhenkui
 * @Date 2020/5/14 10:13
 */
public class BlockingQueueOpt {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

    /*    System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());


        System.out.println(queue.offer("d"));
        System.out.println(queue.offer("d"));
        System.out.println(queue.offer("f"));

        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/

//        同步队列: 不存储元素, 产生一个消费一个
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": 1");
                synchronousQueue.put("1");

                System.out.println(Thread.currentThread().getName() + ": 2");
                synchronousQueue.put("2");

                System.out.println(Thread.currentThread().getName() + ": 3");
                synchronousQueue.put("3");

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Thread-put-Running-1").start();

        new Thread(() -> {
            try {
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + ": " + synchronousQueue.take());

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + ": " + synchronousQueue.take());

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + ": " + synchronousQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"Thread-take-Running-2").start();
    }
}
