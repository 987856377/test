package java8.collections;

import tool.util.XmlUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterator {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("username","frank");
        map.put("password","123456");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + ": " + next.getValue());
        }

        System.out.println(XmlUtil.mapToXml(map,"root"));
    }
}
