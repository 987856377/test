package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description
 * @Project test
 * @Package collections
 * @Author xuzhenkui
 * @Date 2020/5/12 10:07
 */
public class ContainerNotSafe {

    public static void main(String[] args) {
//        线程不安全,使用  new Vector(); Collections.synchronizedList(new ArrayList<>()); new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();

//        线程不安全,使用  Collections.synchronizedSet(new HashSet<>()); new CopyOnWriteArraySet<>();
        Set<String> set = new HashSet<>();

//        线程不安全,使用  new ConcurrentHashMap<>();  Collections.synchronizedMap(new HashMap<>()); new CopyOnWriteArrayMap<>();
        Map<Object,Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+map.toString());
            },"Thread-" + i +": ").start();
        }
    }

    /*
        1.  故障现象： 30 个线程: Exception in thread "Thread-23: " java.util.ConcurrentModificationException

        2.  原因：
                线程并发使用add方法, 导致当前对象被修改

        3.  解决方案：
                1.  new Vector();   ArrayList 线程不安全, 并发性下降; Vector 线程安全, 并发性上升
                2.  Collections.synchronizedList(new ArrayList<>());
                3.  new CopyOnWriteArrayList<>();

        4.  优化建议：

        */
}
