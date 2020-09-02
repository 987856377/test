package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("sd","ds");

        System.out.println("map.get(\"ds\") = " + map.get("sd"));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list.toString() = " + list.toString());
    }
}
