package comparator;

import java.util.Comparator;

/**
 * @Description
 * @Project test
 * @Package comparator
 * @Author xuzhenkui
 * @Date 2020/5/11 8:27
 */
public class Main {
    public static void main(String[] args) {
        Comparator comparator = Comparator.comparingInt(Integer.class::cast);

        System.out.println(comparator.compare(1,2));

        String s1 = "obj";
        String s2 = "arg";
        String s = Assert.notNull(s1, s2);
        System.out.println(s);

    }


    static class Assert {
        public static <T> T notNull(final T argument, final String name) {
            if (argument == null) {
                throw new IllegalArgumentException(name + " may not be null");
            }
            return argument;
        }
    }
}
