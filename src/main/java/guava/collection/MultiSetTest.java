package guava.collection;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetTest {
    // MultiSet: 无序+可重复
    //我们映像中的 Set 应该是无序的，元素不可重复的。MultiSet 颠覆了三观，因为它可以重复。
    public static void main(String[] args) {
        Multiset<Integer> set = HashMultiset.create();
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(4);
    }
}
