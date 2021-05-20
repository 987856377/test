package guava.collection;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    // map 取交集、并集、差集
    public static void main(String[] args) {
        HashMap<String, Integer> mapA = Maps.newHashMap();
        mapA.put("a", 1);
        mapA.put("b", 2);
        mapA.put("c", 3);

        HashMap<String, Integer> mapB = Maps.newHashMap();
        mapB.put("b", 20);
        mapB.put("c", 3);
        mapB.put("d", 4);

        MapDifference<String, Integer> differenceMap = Maps.difference(mapA, mapB);
        Map<String, MapDifference.ValueDifference<Integer>> entriesDiffering = differenceMap.entriesDiffering();
//左边差集
        Map<String, Integer> entriesOnlyLeft = differenceMap.entriesOnlyOnLeft();
//右边差集
        Map<String, Integer> entriesOnlyRight = differenceMap.entriesOnlyOnRight();
//交集
        Map<String, Integer> entriesInCommon = differenceMap.entriesInCommon();

        System.out.println(entriesDiffering);   // {b=(2, 20)}
        System.out.println(entriesOnlyLeft);    // {a=1}
        System.out.println(entriesOnlyRight);   // {d=4}
        System.out.println(entriesInCommon);    // {c=3}
    }
}
