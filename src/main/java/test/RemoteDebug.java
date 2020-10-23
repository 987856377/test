package test;

import java.util.Map;

public class RemoteDebug {
    public static void main(String[] args) {
        System.out.println("------------------start------------------");
        Map<String, String> envs = System.getenv();
        envs.entrySet().stream().filter(env -> env.getKey().contains("HOME")).forEach(env -> {
            System.out.println(env.getKey() + ":" + env.getValue());
        });

        String s = "{bcrypt}$2a$10$mZgEyqiKVBmzIGYML29Ei.6HOyDM10Vqciqpy14/R0jQHZqc1p9JS";
        System.out.println(s.length());
    }
}
