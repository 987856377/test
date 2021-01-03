package function;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description
 * @Project test
 * @Package function
 * @Author xuzhenkui
 * @Date 2020/4/30 17:25
 */
public class Test {
    public static Integer change1(String s, Function<String,Integer> f){
        return f.apply(s);
    }

    public static String change2(String s, Function<String,Integer> f1, Function<Integer,String> f2){
        return f1.andThen(f2).apply(s);
    }

    public static Comparator<String> comparator(){
        return Comparator.comparingInt(String::length);
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(System.out::print);
        System.out.println();
        List<Integer> list1  = list.stream().map(Integer::parseInt).filter(s -> s > 1).collect(Collectors.toList());
        list1.forEach(System.out::print);
        System.out.println();

        String[] arr = {"bbbbbbbbb","ccccccccccccc","aaaa"};
        Arrays.sort(arr, comparator());
        System.out.println(Arrays.toString(arr));

        System.out.println(change1("456",s -> Integer.parseInt(s)));

        System.out.println(change2("789",s -> Integer.parseInt(s) + 321, v -> String.valueOf(v)));

    }
}
