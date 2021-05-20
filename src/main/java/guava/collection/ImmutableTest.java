package guava.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class ImmutableTest {
    // 不可变集合的特性有：
    //
    //在多线程操作下，是线程安全的；
    //所有不可变集合会比可变集合更有效的利用资源；
    //中途不可改变。
    //如果你的需求是想创建一个一经初始化后就不能再被改变的集合那么它适合你，因为这些工具类根本就没给你提供修改的 API，这意味着你连犯错误的机会都没有。
    public static void main(String[] args) {
        ImmutableList<Integer> iList = ImmutableList.of(12,54,87);
        ImmutableSet<Integer> iSet = ImmutableSet.of(354,54,764,354);
        ImmutableMap<String, Integer> iMap = ImmutableMap.of("k1", 453, "k2", 534);
    }
}
