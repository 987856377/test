package guava.collection;

import com.google.common.collect.Sets;

import java.util.HashSet;

public class SetTest {

    // Set 取交集、并集、差集
    public static void main(String[] args) {
        HashSet<Integer> setA = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet<Integer> setB = Sets.newHashSet(4, 5, 6, 7, 8);

        Sets.SetView<Integer> union = Sets.union(setA, setB);
        System.out.println("union:" + union);

        Sets.SetView<Integer> difference = Sets.difference(setA, setB);
        System.out.println("difference:" + difference);

        Sets.SetView<Integer> intersection = Sets.intersection(setA, setB);
        System.out.println("intersection:" + intersection);
    }
}
