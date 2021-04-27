package collections.stream;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
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
//        userList.collections.stream().forEach(user -> {
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
//
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers1.collections.stream().forEach(num->System.out.println(Thread.currentThread().getName() + ": " + num));
//
//        System.out.println("-------------------------------------------");
//
//        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<Integer> tmpList = new ArrayList<>();
//        numbers2.parallelStream().forEach(num->{
//            if (num % 2 == 0){
//                tmpList.add(num);
//                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
//                return;
//            }
//            System.out.println(Thread.currentThread().getName() + ": " + num);
//        });
//
//        System.out.println("tmpList.toString() = " + tmpList.toString());
//
//        Set<Integer> collect = numbers1.collections.stream().collect(Collectors.toSet());
//        for (Integer integer : collect) {
//            System.out.println(integer);
//        }
//
//        ResultJson<List<User>> resultJson1 = new ResultJson<>();
//        List<User> list1 = new ArrayList<>();
//        list1.add(new User("1","2"));
//        list1.add(new User("2","2"));
//        list1.add(new User("3","3"));
//        resultJson1.setData(list1);
//
//        ResultJson<List<User>> resultJson2 = new ResultJson<>();
//        List<User> list2 = new ArrayList<>();
//        list2.add(new User("4","4"));
//        list2.add(new User("5","5"));
//        list2.add(new User("6","6"));
//        resultJson2.setData(list2);
//
//        if (list1.size() > 0){
//            Optional.ofNullable(list1.get(0)).map(User::getPassword).ifPresent(s -> {
//                int i = Integer.parseInt(s);
//                if (i == 1 ){
//                    System.out.println(i);
//                }
//            });
//        }
//
//        resultJson1.getData().addAll(resultJson2.getData());
//
//        System.out.println(resultJson1.getData());
//
//
//        List<User> userList1 = new ArrayList<>();
//        userList1.addAll(list1);
//        userList1.addAll(list2);
//        System.out.println(userList1);
//
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("xz","ds");
//        System.out.println(map.get("xz"));
//        map1.put("xz","ss");
//        System.out.println(map1.get("xz"));
//        System.out.println(map1.get("x") == null);


//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            numbers.add(i);
//        }
//
//        System.out.println("-----------------");
//
//        Set<Integer> numSet1 = Collections.synchronizedSet(new HashSet<>());
//        Set<Integer> numSet2 = new CopyOnWriteArraySet(new HashSet<>());

//        new Thread(() -> {
//            for ( int i = 0; i < 3; i++){
//                new Thread(() -> {
//                    Integer integer = numbers.get(new Random().nextInt(9));
//                    numSet1.add(integer);
//                    numSet2.add(integer);
//                    System.out.println(Thread.currentThread().getName() + integer + "---numSet1" + numSet1+ "---numSet2" + numSet2);
//                },"------------------------------------------------------------------------------------------------------Add1 Thread- " + i + " -Running: ").start();
//            }
//            System.out.println(Thread.currentThread().getName());
//        },"Thread- local add1 -Running: ").start();
//
//        new Thread(() -> {
//            for ( int i = 0; i < 3; i++){
//                new Thread(() -> {
//                    Integer integer = numbers.get(new Random().nextInt(9));
//                    numSet1.remove(integer);
//                    numSet2.remove(integer);
//                    System.out.println(Thread.currentThread().getName() + integer + "---numSet1" + numSet1+ "---numSet2" + numSet2);
//                },"Remove1 Thread- " + i + " -Running: ").start();
//            }
//            System.out.println(Thread.currentThread().getName());
//        },"Thread- local del1 -Running: ").start();
//
//        new Thread(() -> {
//            for ( int i = 0; i < 3; i++){
//                new Thread(() -> {
//                    Integer integer = numbers.get(new Random().nextInt(9));
//                    numSet1.add(integer);
//                    numSet2.add(integer);
//                    System.out.println(Thread.currentThread().getName() + integer + "---numSet1" + numSet1+ "---numSet2" + numSet2);
//                },"------------------------------------------------------------------------------------------------------Add2 Thread- " + i + " -Running: ").start();
//            }
//            System.out.println(Thread.currentThread().getName());
//        },"Thread- local add2 -Running: ").start();
//
//
//        new Thread(() -> {
//            for ( int i = 0; i < 3; i++){
//                new Thread(() -> {
//                    Integer integer = numbers.get(new Random().nextInt(9));
//                    numSet1.remove(integer);
//                    numSet2.remove(integer);
//                    System.out.println(Thread.currentThread().getName() + integer + "---numSet1" + numSet1+ "---numSet2" + numSet2);
//                },"Remove2 Thread- " + i + " -Running: ").start();
//            }
//            System.out.println(Thread.currentThread().getName());
//        },"Thread- local del2 -Running: ").start();
//        long t1;
//        long l = System.currentTimeMillis();
//        for (int i = 0; i < 300; i++) {
//            new Thread(() -> {
//                System.out.println("A begin >>> " + Thread.currentThread().getName() + " numSet1 : " + numSet1 + " numSet2 : " + numSet2);
//                int i1 = numbers.get(new Random().nextInt(10000));
//                numSet1.add(i1);
//                numSet2.add(i1);
//                System.out.println("A end <<< " + Thread.currentThread().getName() + "add: " + i1 + " numSet1 : " + numSet1 + " numSet2 : " + numSet2);
//            },"A Thread- local -Running: ").start();
//
//            new Thread(() -> {
//                System.out.println("R begin >>> " + Thread.currentThread().getName() + " numSet1 : " + numSet1 + " numSet2 : " + numSet2);
//                int i2 = numbers.get(new Random().nextInt(10000));
//                numSet1.remove(i2);
//                numSet2.remove(i2);
//                System.out.println("R end <<< " + Thread.currentThread().getName() + "remove: " + i2 + " numSet1 : " + numSet1 + " numSet2 : " + numSet2);
//            },"R Thread- local -Running: ").start();
//        }
//
//        while (Thread.activeCount() > 2){
//            Thread.yield();
//        }
//        t1 = System.currentTimeMillis() - l;
//
//        System.out.println("Time: " + t1 + "ms");
////        System.out.println("CopyOnWriteArraySet Time: " + t2 + "ms");
//        System.out.println("numSet1 = " + numSet1);
//        System.out.println("numSet2 = " + numSet2);
//
//        System.out.println("numSet1.containsAll(numSet2) = " + numSet1.containsAll(numSet2));
//
//        numSet1.removeIf(next -> next % 2 == 0);
//        System.out.println("numSet1 = " + numSet1);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integers1 = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> collect = integers.stream().filter(integer -> !integers1.contains(integer)).collect(Collectors.toSet());
        Set<Integer> collect1 = integers.stream().filter(integer -> integers1.contains(integer)).collect(Collectors.toSet());
        System.out.println("collect = " + collect);
        System.out.println("collect1 = " + collect1);

        Set<Integer> collect2 = integers1.stream().filter(integer -> !integers.contains(integer)).collect(Collectors.toSet());
        Set<Integer> collect3 = integers1.stream().filter(integer -> integers.contains(integer)).collect(Collectors.toSet());
        System.out.println("collect2 = " + collect2);
        System.out.println("collect3 = " + collect3);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
//        String[] strings1 = (String[]) strings.toArray(); // java.lang.ClassCastException
        String[] strings1 = strings.toArray(new String[0]);

        System.out.println("strings1 = " + strings1[0]);


    }
}
