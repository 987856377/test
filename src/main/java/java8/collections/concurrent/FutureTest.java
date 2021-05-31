package java8.collections.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    final static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();
        Future<String> future1 = null;
        Future<String> future2 = null;

        try {
            future1 = service.submit(rpcService::getRpcResult);
            future2 = service.submit(httpService::getHttpResult);
            System.out.println("future1.get(300, TimeUnit.MILLISECONDS) = " + future1.get(300, TimeUnit.MILLISECONDS));
            System.out.println("future2.get(300, TimeUnit.MILLISECONDS) = " + future2.get(300, TimeUnit.MILLISECONDS));

            service.shutdown();
            System.out.println("service.isShutdown() = " + service.isShutdown());
            System.out.println("service.isTerminated() = " + service.isTerminated());

            if(!service.isTerminated()){
                service.shutdownNow();
                try {
                    while (!service.isTerminated()){
                        service.awaitTermination(3,TimeUnit.SECONDS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("service.isShutdown() = " + service.isShutdown());
            System.out.println("service.isTerminated() = " + service.isTerminated());

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
            service.shutdown();
            try {
                service.awaitTermination(3,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!service.isTerminated()){
                service.shutdownNow();
                try {
                    while (!service.isTerminated()){
                        service.awaitTermination(10,TimeUnit.SECONDS);
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
