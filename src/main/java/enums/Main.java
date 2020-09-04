package enums;

/**
 * @Description
 * @Project test
 * @Package Enum
 * @Author xuzhenkui
 * @Date 2020/4/24 10:06
 */
public class Main {
    private static String f;
    static {
        f = "qwwq";
    }
    public static void main(String[] args) {
        System.out.println(f);
        System.out.println(ColorEnum.RED);
        System.out.println(ColorEnum.GREEN.getValue());
    }
}
