package java8.thread.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ForkJoinRecursiveAction {
    //最大计算数
    private static final int MAX_THRESHOLD = 5;
    private static final AtomicInteger SUM = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        //创建ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        //异步提交RecursiveAction任务
        pool.submit(new CalculatedRecursiveTask(0, 10));
        //等待3秒后输出结果，因为计算需要时间
        pool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("结果为：" + SUM);
        pool.shutdown();
    }

    private static class CalculatedRecursiveTask extends RecursiveAction {
        private int start;
        private int end;

        public CalculatedRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            //判断计算范围，如果小于等于5，那么一个线程计算就够了，否则进行分割
            if ((end - start) <= 5) {
                //因为没有返回值，所有这里如果我们要获取结果，需要存入公共的变量中
                SUM.addAndGet(IntStream.rangeClosed(start, end).sum());
            } else {
                //任务分割
                int middle = (end + start) / 2;
                CalculatedRecursiveTask task1 = new CalculatedRecursiveTask(start, middle);
                CalculatedRecursiveTask task2 = new CalculatedRecursiveTask(middle + 1, end);
                //执行
                task1.fork();
                task2.fork();
            }
        }
    }
}
