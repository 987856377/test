package util;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @Description
 * @Project test
 * @Package PACKAGE_NAME
 * @Author xuzhenkui
 * @Date 2019/8/17 11:50
 */
public class Time {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.getTime()+120*1000*60);

        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        System.out.println(uuid);


//        java 8 推荐使用 Instant 来操作时间
        System.out.println(Instant.now());


        LocalDateTime now = LocalDateTime.now();
        Date startDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(now.plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(startDate.toString());
        System.out.println(endDate.toString());

//        Date 转 LocalDateTime
        Date date1 = new Date();
        LocalDateTime localDateTime1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        LocalDateTime 转 Date
        LocalDateTime localDateTime2 = LocalDateTime.now();
        Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("Date 转 LocalDateTime:  " + localDateTime1);
        System.out.println("LocalDateTime 转 Date:  " + date2);

//        LocalDateTime 转 String
        String s = LocalDateTime.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
        System.out.println("LocalDateTime 转 String:  " + s);
//        String 转 LocalDateTime
        LocalDateTime parse = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
        System.out.println("String 转 LocalDateTime:  " + parse);

//        LocalDateTime 转 long
        long epochMilli = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("LocalDateTime 转 long:  " + epochMilli);
//        long 转 LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
        System.out.println("long 转 LocalDateTime:  " + localDateTime);

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));


        System.out.println("now.getDayOfWeek().getValue() = " + now.getDayOfWeek().getValue());
    }
}
