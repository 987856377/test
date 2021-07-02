package test;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java8.proxy.User;

import java.io.*;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-03-12 15:10
 **/
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("1");
        stringJoiner.add("2");
        stringJoiner.add("3");
        StringJoiner stringJoiner1 = new StringJoiner(",");
        stringJoiner1.add("4");
        stringJoiner1.add("5");
        stringJoiner1.add("6");
        System.out.println(stringJoiner.toString());
        System.out.println(stringJoiner.merge(stringJoiner1).toString());

        String str = "select * from user where id = ?";
        AtomicReference<String> sql = new AtomicReference<>("");
        sql.set(str);
        sql.updateAndGet(s -> s.replaceFirst("\\?", "'" + Matcher.quoteReplacement("{bcrypt}$2a$10$LcSejpbWjN1NSs5limJhReAe8URw1CgXEGMwKOgBWz6wTqCptt5H.") + "'"));

        sql.accumulateAndGet(";", (s, s2) -> s + s2);

        System.out.println(sql.get());

        Matcher matcher = Pattern.compile("").matcher("");


        Animal animal = ((Animal) Thread.currentThread().getContextClassLoader().loadClass("test.Animal").newInstance());
        System.out.println(animal.toString());


        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setPassword("dadsfa");
        user.setName("dfhalks");

        User user1 = new User();
        user1.setPassword("dadsfa");
        user1.setName("dfhalks");

        userList.add(user);
        userList.add(user1);
        String s1 = objectMapper.writeValueAsString(userList);
        System.out.println(s1);

        List<User> list = objectMapper.readValue(s1, new TypeReference<List<User>>() {

        });
        System.out.println(list.get(0).getName());

        User newInstance = (User) Class.forName("java8.proxy.User").newInstance();
        newInstance.setName("hahahaha");
        System.out.println(newInstance);

        System.out.println("com%002ebsoft%002eplatform%002edao%002e%0041ccount%004dapper.data".replace("%002e", "."));
    }

}
