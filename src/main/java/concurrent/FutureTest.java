package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();
        Future<String> future1 = null;
        Future<String> future2 = null;

        try {
            future1 = EXECUTOR_SERVICE.submit(rpcService::getRpcResult);
            future2 = EXECUTOR_SERVICE.submit(httpService::getHttpResult);
            System.out.println("future1.get(300, TimeUnit.MILLISECONDS) = " + future1.get(300, TimeUnit.MILLISECONDS));
            System.out.println("future2.get(300, TimeUnit.MILLISECONDS) = " + future2.get(300, TimeUnit.MILLISECONDS));

            EXECUTOR_SERVICE.shutdown();
            System.out.println("EXECUTOR_SERVICE.isShutdown() = " + EXECUTOR_SERVICE.isShutdown());
            System.out.println("EXECUTOR_SERVICE.isTerminated() = " + EXECUTOR_SERVICE.isTerminated());

            if(!EXECUTOR_SERVICE.isTerminated()){
                EXECUTOR_SERVICE.shutdownNow();
                try {
                    while (!EXECUTOR_SERVICE.isTerminated()){
                        EXECUTOR_SERVICE.awaitTermination(3,TimeUnit.SECONDS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("EXECUTOR_SERVICE.isShutdown() = " + EXECUTOR_SERVICE.isShutdown());
            System.out.println("EXECUTOR_SERVICE.isTerminated() = " + EXECUTOR_SERVICE.isTerminated());

            System.out.println("future1.get(300, TimeUnit.MILLISECONDS) = " + future1.get(300, TimeUnit.MILLISECONDS));
            System.out.println("future2.get(300, TimeUnit.MILLISECONDS) = " + future2.get(300, TimeUnit.MILLISECONDS));

        } catch (Exception e){
            if (future1 == null) {
                future1.cancel(true);
            }
            if (future2 == null) {
                future2.cancel(true);
            }
            throw new RuntimeException(e);
        } finally {
            EXECUTOR_SERVICE.shutdown();
            try {
                EXECUTOR_SERVICE.awaitTermination(3,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!EXECUTOR_SERVICE.isTerminated()){
                EXECUTOR_SERVICE.shutdownNow();
                try {
                    while (!EXECUTOR_SERVICE.isTerminated()){
                        EXECUTOR_SERVICE.awaitTermination(10,TimeUnit.SECONDS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class RpcService{
        String getRpcResult() throws Exception{
            return "RPC";
        }
    }

    static class HttpService{
        String getHttpResult() throws Exception {
            return "HTTP";
        }
    }
}
