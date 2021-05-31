package guava.callback;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * @program: test
 * @package guava.callback
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-04 10:31
 **/
public class ListenableFutureOpt {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println(Runtime.getRuntime().availableProcessors());
//
//        ListeningExecutorService service1 = MoreExecutors.listeningDecorator(ThreadPoolExecutorFactory.getThreadPoolExecutor());
//        ListeningExecutorService service2 = MoreExecutors.newDirectExecutorService();
//        AtomicInteger integer = new AtomicInteger(1);
//
//
//        ListenableFuture<Object> submit = service2.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
//                return integer.incrementAndGet();
//            }
//        });
//
//        Futures.addCallback(submit, new FutureCallback<Object>() {
//            @Override
//            public void onSuccess(@Nullable Object result) {
//                System.out.println(result);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                System.out.println(t.getMessage());
//            }
//        }, MoreExecutors.newDirectExecutorService());
//
//        if (service2 != null) {
//            service2.shutdown();
//            try {
//                service2.awaitTermination(3, TimeUnit.SECONDS);
//                while (!service2.isTerminated()){
//                    service2.awaitTermination(3, TimeUnit.SECONDS);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }

//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("async-pool-%d").build();
//        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(3000), threadFactory);
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println(Thread.currentThread().getName() + "@666");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(Thread.currentThread().getName() + "@888");
//        MoreExecutors.addDelayedShutdownHook(executorService, 3000, TimeUnit.MILLISECONDS);

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("async-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(3000), threadFactory);
        ExecutorService executorService = MoreExecutors.getExitingExecutorService(threadPoolExecutor);
        executorService.submit(() -> {
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "@666");
        });
        System.out.println(Thread.currentThread().getName() + "@888");
    }

}
