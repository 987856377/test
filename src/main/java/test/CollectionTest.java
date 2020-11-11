package test;

import common.ResultJson;
import proxy.User;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CollectionTest {
    public static void main(String[] args) {
//        Map<String,String> map = new HashMap();
//        map.put("sd","ds");
//
//        System.out.println("map.get(\"ds\") = " + map.get("sd"));
//
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        System.out.println("list.toString() = " + list.toString());
//
//        List<User> userList = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            userList.add(new User("xzk1","1"));
//        }
//
//        Map<String, User> userMap = new HashMap<>();
//
//        long l = System.currentTimeMillis();
//        userList.stream().forEach(user -> {
//            userMap.put(user.getName(),user);
//        });
//        System.out.println("forEach 耗時: = " + (System.currentTimeMillis() - l) + " ms");
//
//        long c = System.currentTimeMillis();
//        for (int i = 0; i < userList.size(); i++) {
//            userMap.put(userList.get(i).getName(), userList.get(i));
//        }
//        System.out.println("fori 耗時: = " + (System.currentTimeMillis() - c) + " ms");
//
//        long d = System.currentTimeMillis();
//        for (User user : userList){
//            userMap.put(user.getName(),user);
//        }
//        System.out.println("for 耗時: = " + (System.currentTimeMillis() - d) + " ms");
//
//        System.out.println("userMap.toString() = " + userMap.toString());

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers1.stream().forEach(num->System.out.println(Thread.currentThread().getName() + ": " + num));

        System.out.println("-------------------------------------------");

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> tmpList = new ArrayList<>();
        numbers2.parallelStream().forEach(num->{
            if (num % 2 == 0){
                tmpList.add(num);
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": " + num);
        });

        System.out.println("tmpList.toString() = " + tmpList.toString());

        Set<Integer> collect = numbers1.stream().collect(Collectors.toSet());
        for (Integer integer : collect) {
            System.out.println(integer);
        }

        ResultJson<List<User>> resultJson1 = new ResultJson<>();
        List<User> list1 = new ArrayList<>();
        list1.add(new User("1","1"));
        list1.add(new User("2","2"));
        list1.add(new User("3","3"));
        resultJson1.setData(list1);

        ResultJson<List<User>> resultJson2 = new ResultJson<>();
        List<User> list2 = new ArrayList<>();
        list2.add(new User("4","4"));
        list2.add(new User("5","5"));
        list2.add(new User("6","6"));
        resultJson2.setData(list2);

//        resultJson1.getData().addAll(resultJson2.getData());

        System.out.println(resultJson1.getData());


        List<User> userList = new ArrayList<>();
        userList.addAll(list1);
        userList.addAll(list2);
        System.out.println(userList);

        Map<String, String> map = new HashMap<>();
        map.put("xz","ds");
        System.out.println(map.get("xz"));
        map.put("xz","ss");
        System.out.println(map.get("xz"));
        System.out.println(map.get("x") == null);
    }
}
