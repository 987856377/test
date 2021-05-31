package guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheBuilderTest {

    // Guava Cache 在日常的使用中非常地频繁，甚至都没有意识到这是第三方提供的工具类而是把它当成了 JDK 自带的实现。
    public static void main(String[] args) {
        // LoadingCache是Cache的缓存实现
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                //设置缓存大小
                .maximumSize(1000)
                //设置到期时间
                .expireAfterWrite(10, TimeUnit.MINUTES)
                //设置缓存里的值两分钟刷新一次
                .refreshAfterWrite(2, TimeUnit.MINUTES)
                //开启缓存的统计功能
                .recordStats()
                //构建缓存
                .build(new CacheLoader<String, Object>() {
                    //此处实现如果根据key找不到value需要去如何获取
                    @Override
                    public Object load(String s) throws Exception {
                        return new Object();
                    }

                    //如果批量加载有比反复调用load更优的方法则重写这个方法
                    @Override
                    public Map<String, Object> loadAll(Iterable<? extends String> keys) throws Exception {
                        return super.loadAll(keys);
                    }
                });

        cache.put("a", 1);
        cache.put("b", 2);
    }
}
