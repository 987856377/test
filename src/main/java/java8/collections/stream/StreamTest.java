package java8.collections.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

//        1、分组
//        List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起：
//        List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.err.println("groupBy:" + groupBy);

//        2、List转Map
//        id为key，apple对象为value，可以这么做：
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
        System.out.println(appleMap);

//        3、过滤Filter
//        从集合中过滤出来符合条件的元素：
        //过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.err.println("filterList:" + filterList);

//        4.求和
//        将集合中的数据按照某个属性求和:
        //计算 总金额
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:" + totalMoney);  //totalMoney:17.48

//        5.查找流中最大 最小值
//        Collectors.maxBy 和 Collectors.minBy 来计算流中的最大或最小值。
        Optional<Apple> maxDish = appleList.stream().collect(Collectors.maxBy(Comparator.comparing(Apple::getMoney)));
        maxDish.ifPresent(System.out::println);

        Optional<Apple> minDish = appleList.stream().min(Comparator.comparing(Apple::getMoney));
        minDish.ifPresent(System.out::println);

//        6.去重
        List<Apple> unique = appleList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparingLong(Apple::getId))), ArrayList::new
                )
        );
        System.out.println(unique);
    }
}
