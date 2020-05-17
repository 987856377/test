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
        Comparator comparator = Comparator.comparingInt(o -> (Integer) o);

        System.out.println(comparator.compare(1,2));

    }
}
