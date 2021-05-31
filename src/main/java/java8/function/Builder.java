package java8.function;

/**
 * @Description
 * @Project test
 * @Package java8.function
 * @Author xuzhenkui
 * @Date 2020/5/11 9:08
 */
@FunctionalInterface
public interface Builder {
    void build();

    default void compat() {
        System.out.println("FunctionalInterface");
    }
}
