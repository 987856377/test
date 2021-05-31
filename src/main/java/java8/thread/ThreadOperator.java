package java8.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/5/2 14:17
 */
public class ThreadOperator {

    public static void main(String[] args) {
        System.out.println("begin");
        output("Hello World");


//        new Thread("Thread_1"){
//            int count = 10000;
//            @Override
//            public void run() {
//                while (count > 0){
//                    synchronized (this){
//                        System.out.println("第 "+ count-- +" 张");
//                    }
//                }
//            }
//        }.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"hello word");
        },"Thread-Running: "){}.start();

        System.out.println("end");
    }

    public static void output(String s){
        System.out.println(Thread.currentThread().getName() + ": " +s);

//        1. 运行于主线程
        new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " --->  !!!!!!!!! " + i);
                }
            }
        }.run();
//        2. 运行于主线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " --->  @@@@@@@@@ " + i);
                }
            }
        },"T2: ").run();
//        3. 运行于 T3 线程
        new Thread("Thread_3_" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " --->  ######### " + i);
                }
            }
        }.start();
//        4. 运行于 T4 线程
        new Thread("Thread_4_" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " --->  $$$$$$$$$ " + i);
                }
            }
        }.start();

        System.out.println(Thread.currentThread().getName() + ": " +s);
    }
}
