package function;

/**
 * @Description
 * @Project test
 * @Package function
 * @Author xuzhenkui
 * @Date 2020/5/11 9:08
 */
@FunctionalInterface
public interface Builder {
    public abstract void build();

    default void compat() {
        System.out.println("FunctionalInterface");
    }
}
