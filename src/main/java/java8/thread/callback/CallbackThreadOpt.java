package java8.thread.callback;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CallbackThreadOpt {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        System.out.println("main: " + fileRead());
    }

    public static String addListener(){
        ListeningExecutorService listeningExecutorService = CallbackThreadPoolExecutorHolder.getThreadPoolExecutor();

        final String[] result = {null};
        ListenableFuture<Object> future = listeningExecutorService.submit(() -> {
            System.out.println("submit:   " + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });

        future.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    result[0] = (String) future.get();
                    System.out.println("addListener: " + Thread.currentThread().getName());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                listeningExecutorService.shutdown();
            }
        }, MoreExecutors.directExecutor());

        return result[0];
    }

    public static String addCallback(){
        ListeningExecutorService listeningExecutorService = CallbackThreadPoolExecutorHolder.getThreadPoolExecutor();

        ListenableFuture<Object> future = listeningExecutorService.submit(() -> {
            System.out.println("submit:   " + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });

        Futures.addCallback(future, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object result) {
                System.out.println("guava.callback: " + result);
                listeningExecutorService.shutdown();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        }, MoreExecutors.directExecutor());

        return Thread.currentThread().getName();
    }

    public static List<String> addCallbackForEveryFuture(){
        ListeningExecutorService listeningExecutorService = CallbackThreadPoolExecutorHolder.getThreadPoolExecutor();

        final List<String> value = Collections.synchronizedList(new ArrayList<>());
        try {
            List<ListenableFuture<String>> futureList = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                ListenableFuture<String> future = listeningExecutorService.submit(() -> {
                    System.out.println("submit:   " + Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                });

                Futures.addCallback(future, new FutureCallback<String>() {
                    @Override
                    public void onSuccess(@Nullable String result) {
                        System.out.println("guava.callback: " + result);
                        value.add(result);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        System.out.println(t.getMessage());
                    }
                }, MoreExecutors.directExecutor());
                futureList.add(future);
            }

            // 等待所有异步任务执行完
            ListenableFuture<List<String>> allAsList = Futures.allAsList(futureList);
            allAsList.get();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            listeningExecutorService.shutdown();
        }
        return value;
    }

    public static List<String> addCallbackForFutures(){
        ListeningExecutorService listeningExecutorService = CallbackThreadPoolExecutorHolder.getThreadPoolExecutor();

        final List<String> value = Collections.synchronizedList(new ArrayList<>());
        try {
            List<ListenableFuture<String>> futureList = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                ListenableFuture<String> future = listeningExecutorService.submit(() -> {
                    System.out.println("submit:   " + Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                });
                futureList.add(future);
            }

            Futures.addCallback(Futures.allAsList(futureList), new FutureCallback<List<String>>() {
                @Override
                public void onSuccess(@Nullable List<String> result) {
                    System.out.println("guava.callback: " + result);
                    assert result != null;
                    value.addAll(result);
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.println(t.getMessage());
                }
            }, MoreExecutors.directExecutor());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            listeningExecutorService.shutdown();
        }
        return value;
    }

    public static Map<String, String> fileRead() {
         final Map<String, String> map = new ConcurrentHashMap<>();
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2 + 1));

        final List<String> fileList = Arrays.asList("NationDictionary", "NationAreaDictionary","MarriedDictionary",
                "PatientNatureDictionary","InHospitalTypeDictionary","RelationDictionary","PayTypeDictionary","JobDictionary","NationalDictionary");

        long start = System.currentTimeMillis();

        List<ListenableFuture<String>> futureList = new ArrayList<>();

        fileList.forEach(file -> {
            ListenableFuture<String> future = listeningExecutorService.submit(() -> {
                map.put(file, file + " ready");
                return file;
            });
            futureList.add(future);
        });

        Futures.addCallback(Futures.allAsList(futureList), new FutureCallback<List<String>>() {

            @Override
            public void onSuccess(@Nullable List<String> result) {
                assert result != null;
                System.out.println("JSONDateUtil init Dictionary " + result.size() + " files : " + result);
                System.out.println("JSONDateUtil init Dictionary success, cost: " + (System.currentTimeMillis() - start) + "ms");
                listeningExecutorService.shutdown();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("JSONDateUtil init Dictionary failure: " + t.getMessage());
                listeningExecutorService.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return map;
    }
}
