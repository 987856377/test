package guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class CacheTest {
    public static void main(String[] args) throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        cache.put("username","frank");
        cache.put("password","123456");

        Object username = cache.get("username1", new Callable() {
            @Override
            public Object call() throws Exception {
                return "jackson";
            }
        });
        System.out.println(username);

        String password = cache.getIfPresent("password");
        System.out.println(password);
    }
}
