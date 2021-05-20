package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class JoinerTest {
    public static void main(String[] args) {

        // List
        List<Integer> list = Lists.newArrayList();
        list.add(34);
        list.add(64);
        list.add(267);
        list.add(865);
        String result = Joiner.on("-").join(list);
        System.out.println(result);

        // Map
        Map<String, Integer> map = Maps.newHashMap();
        map.put("key1", 45);
        map.put("key2",234);
        String result1 = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(result1);

    }
}
