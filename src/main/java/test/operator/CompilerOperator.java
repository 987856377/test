package test.operator;

/**
 * @Description
 * @Project test
 * @Package test
 * @Author xuzhenkui
 * @Date 2020/1/2 17:07
 */
public class CompilerOperator {
    public static void main(String[] args) {
//        int i = 8 << 2;
//        int j = 20 >> 2;
//
////        int i = 8;
////        i = i * 4;
//
//        System.out.println(i);
//        System.out.println(j);


        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        Integer result = flag ? a*b : c;
        System.out.println(result);

        System.out.println(c.intValue());       //  ----> NullPointerException
//        System.out.println(Integer.valueOf(c));
    }

}
