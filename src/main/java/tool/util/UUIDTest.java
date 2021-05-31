package tool.util;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class UUIDTest {
    public static void main(String[] args) {
        Set<String> copySet = new CopyOnWriteArraySet<>();

        Set<String> synSet = Collections.synchronizedSet(new HashSet<>(250000));

        for ( int i = 0; i < 25; i++){
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    String string = UUID.randomUUID().toString();
                    string  = string.substring(0,16);
                    synSet.add(string);
                }
            },"Thread- " + i + " -Running: ").start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("synSet.size() = " + synSet.size());

    }
}
