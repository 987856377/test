package stream;

import java.util.stream.Stream;

/**
 * @Description
 * @Project test
 * @Package stream
 * @Author xuzhenkui
 * @Date 2020/6/6 19:49
 */
public class Main {
    public static void main(String[] args) {
        //T reduce(T identity, BinaryOperator<T> accumulator);
        System.out.println("给定个初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));
        System.out.println("给定个初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (min, item) -> Math.min(min, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::min));
        System.out.println("给定个初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (max, item) -> Math.max(max, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::max));

        //Optional<T> reduce(BinaryOperator<T> accumulator);
        // 注意返回值，上面的返回是T,泛型，传进去啥类型，返回就是啥类型。
        // 下面的返回的则是Optional类型
        System.out.println("无初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).orElse(0));
        System.out.println("无初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::max).orElse(0));
        System.out.println("无初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::min).orElse(0));
    }
}
