package guava.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {
    // BiMap：双向 Map (Bidirectional Map) 键与值都不能重复
    //这个稍稍正常一点。如果 key 重复了则会覆盖 key ，如果 value 重复了则会报错。
    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("key", "haha");
        biMap.put("key", "haha1");
        biMap.put("key1", "haha");

        String value = biMap.get("key");
        System.out.println(value);
    }
}
