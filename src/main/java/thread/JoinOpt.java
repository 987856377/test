package thread;

/**
 * @program: test
 * @package thread
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-24 10:39
 **/
public class JoinOpt extends Thread {
    volatile int i;
    Thread previousThread; //上一个线程

    public JoinOpt(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }
    /*
    *  //....
       Thread t=new Thread(payService);
       t.start();
       //....
       //其他业务逻辑处理,不需要确定t线程是否执行完
       insertData();
       //后续的处理，需要依赖t线程的执行结果，可以在这里调用join方法等待t线程执行结束
       t.join();
   * */
    @Override
    public void run() {
        try {
            // 在实际使用过程中，我们可以通过join方法来等待线程执行的结果
            // 调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before: " + previousThread.getName() + "  >>>  current: " + Thread.currentThread().getName() + ": num: " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinOpt joinDemo = new JoinOpt(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }

    }

}
