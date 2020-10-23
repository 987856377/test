package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapOpt {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1","zhangsan");
        map.put("2","lisi");
        System.out.println("map.get(\"2\") = " + map.get("2"));

        map.putIfAbsent("2","wangwu");
        System.out.println("map.get(\"2\") = " + map.get("2"));

        map.compute("3",(key, value) -> {
            System.out.println("key = " + key);
            System.out.println("value = " + value);
            return String.valueOf(3);
        });

        System.out.println("map.get(\"3\") = " + map.get("3"));

        map.computeIfAbsent("4", value -> {
            System.out.println("value = " + value);
            return String.valueOf(4);
        });

        System.out.println("map.get(\"4\") = " + map.get("4"));
    }
}
