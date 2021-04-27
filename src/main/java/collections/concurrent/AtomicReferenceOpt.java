package collections.concurrent;

import proxy.User;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description
 * @Project test
 * @Package collections.concurrent
 * @Author xuzhenkui
 * @Date 2020/5/11 18:56
 */
public class AtomicReferenceOpt {

    public static void main(String[] args) {

//        原子引用
        User user1 = new User("frank","123");
        User user2 = new User("nick","123456");

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);

        System.out.println(atomicReference.compareAndSet(user1,user2)+"\t"+atomicReference.get());
        System.out.println(atomicReference.compareAndSet(user1,user2)+"\t"+atomicReference.get());

//        带有时间戳的原子引用
        User user3 = new User("franklin","123");
        User user4 = new User("nickless","123456");

        AtomicStampedReference<User> atomicStampedReference = new AtomicStampedReference<>(user3,1);
        atomicStampedReference.set(user3,1);

        System.out.println(atomicStampedReference.compareAndSet(user3,user4,1,2)+"\t"+atomicReference.get());
        System.out.println(atomicStampedReference.compareAndSet(user3,user4,1,2)+"\t"+atomicReference.get());
    }


}
