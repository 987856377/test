package thread.callback;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class CallbackThreadTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        ListeningExecutorService threadPoolExecutor = CallbackThreadPoolExecutorHolder.getThreadPoolExecutor();
        ListenableFuture<Object> submit = threadPoolExecutor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            throw new RuntimeException("error");

            return "success";
        });

        Futures.addCallback(submit, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object result) {
                System.out.println(result);
                threadPoolExecutor.shutdown();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        }, MoreExecutors.directExecutor());

        System.out.println("threadPoolExecutor.isTerminated() = " + threadPoolExecutor.isTerminated());
    }
}
