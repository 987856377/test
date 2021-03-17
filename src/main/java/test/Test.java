package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-03-12 15:10
 **/
public class Test {
    public static List<Long> list = new ArrayList<>();

    static {
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (list) {
                System.out.println(Thread.currentThread().getName()  + remove());
            }
        },"Thread - put: ").start();

        new Thread(() -> {
            synchronized (list) {
                System.out.println(Thread.currentThread().getName()  + put(8L));
            }
        },"Thread - remove: ").start();
    }

    public static synchronized Long put(Long value) {
        list.add(value);
        return value;
    }

    public static synchronized Long remove() {
        int position = list.size() - 1;
        return list.remove(position);
    }
}
