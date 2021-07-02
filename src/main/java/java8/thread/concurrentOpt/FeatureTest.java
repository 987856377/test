package java8.thread.concurrentOpt;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Project test
 * @Package test
 * @Author xuzhenkui
 * @Date 2021/6/7 11:18
 */
public class FeatureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return "hello world";
        });
        CompletableFuture<String> future2 = future1.thenApplyAsync(s -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return s + ", better world";
        });
        
        final String[] greet = {"jackson said: "};
        CompletableFuture<String> future3 = future2.whenComplete((s, throwable) -> greet[0] = greet[0] + s);
        future3.join();
        System.out.println(greet[0]);

        System.out.println(future3.get());

//        ------------------------------------------------------------------------------------------------------

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return 1;
        });
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return 2;
        });

        final Integer[] sum = new Integer[1];
        CompletableFuture<Void> voidCompletableFuture = future5.thenAcceptBothAsync(future4, (integer, integer2) -> sum[0] = integer + integer2);
        voidCompletableFuture.join();
        System.out.println(sum[0]);


//        ------------------------------------------------------------------------------------------------------

        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return 100;
        });
        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return 200;
        });

        //两个中任意一个计算完成,那么触发Runnable的执行
        CompletableFuture<String> future8 =  future7.applyToEither(future6, Object::toString);
        future8.join();
        System.out.println(future8.get());

        //两个都计算完成,那么触发Runnable的执行
        CompletableFuture future9 = future7.thenAcceptBoth(future6, (integer, integer2) -> System.out.println(integer + integer2));
        future9.join();

    }
}
