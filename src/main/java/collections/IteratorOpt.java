package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Project test
 * @Package collections
 * @Author xuzhenkui
 * @Date 2020/5/17 22:07
 */
public class IteratorOpt {
    public static void main(String[] args) {

//        单线程
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");

//        正确操作
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            String item = (String) iterator.next();
//            if ("2".equals(item)){
//                iterator.remove();
//            }
//        }

//        正确操作
        for (int i = 0; i < list.size(); i++) {
            if ("2".equals(list.get(i))){
                list.remove(i);
                i--;
                continue;
            }
        }

//        错误操作
//        for (String s : list){
//            if ("2".equals(s)){
//                list.remove(s);
//            }
//        };

        list.forEach(System.out::println);
    }
}
