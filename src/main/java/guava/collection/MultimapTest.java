package guava.collection;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

public class MultimapTest {
    // Multimap ：key 可以重复的 map
    //这个 map 也很有意思。正常的 map 为了区分不同的 key，它倒好，直接给你来一样的 key 。
    public static void main(String[] args) {
        Multimap<String, String> map = LinkedHashMultimap.create();
        map.put("key", "haha");
        map.put("key", "haha1");

        Collection<String> key = map.get("key");
        System.out.println(key);
    }
}
