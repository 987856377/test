package tool.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;

public class DateTest {
    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException {
//        Date date = new Date();
//        System.out.println(date.getTime());
//        System.out.println(date.getTime()+120*1000*60);
//
//        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.get(Calendar.MONTH));
//
//        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
//        System.out.println(uuid);
//
//
////        java 8 推荐使用 Instant 来操作时间
//        System.out.println(Instant.now());
//
//
//        LocalDateTime now = LocalDateTime.now();
//        Date startDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
//        Date endDate = Date.from(now.plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(startDate.toString());
//        System.out.println(endDate.toString());
//
////        Date 转 LocalDateTime
//        Date date1 = new Date();
//        LocalDateTime localDateTime1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
////        LocalDateTime 转 Date
//        LocalDateTime localDateTime2 = LocalDateTime.now();
//        Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
//
//        System.out.println("Date 转 LocalDateTime:  " + localDateTime1);
//        System.out.println("LocalDateTime 转 Date:  " + date2);
//
////        LocalDateTime 转 String
//        String s = LocalDateTime.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
//        System.out.println("LocalDateTime 转 String:  " + s);
////        String 转 LocalDateTime
//        LocalDateTime parse = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
//        System.out.println("String 转 LocalDateTime:  " + parse);
//
////        LocalDateTime 转 long
//        long epochMilli = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println("LocalDateTime 转 long:  " + epochMilli);
////        long 转 LocalDateTime
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
//        System.out.println("long 转 LocalDateTime:  " + localDateTime);
//
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
//
//
//        System.out.println("now.getDayOfWeek().getValue() = " + now.getDayOfWeek().getValue());
//
//
//        Calendar instance = Calendar.getInstance();
//        System.out.println("instance.get(Calendar.MONTH) = " + instance.get(Calendar.MONTH));
//
//        String test = "2020-11-06 10:22:29";
//
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
//
//        Date endTime = null;
//        Integer acceptMaxMinute = 0;
//        Date expiretime = null;
//        acceptMaxMinute = 60 * Integer.valueOf(24);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
//        Date date = simpleDateFormat.parse("2020-07-11 09:15:09");
//        endTime = TimeUtil.addMinute(acceptMaxMinute,date);
//        expiretime = endTime;
//
//        System.out.println(simpleDateFormat.format(expiretime));

//        String  s = "20200721240059";
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        formatter.setLenient(false);
//        Date newDate = formatter.parse(s);
//        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        System.out.println(formatter.format(newDate));

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter1.format(new Date());
        System.out.println(format);

        System.out.println(DateUtils.dateToLocalDateTime(new Date()));

        DateUtils.localDateTimeToString(LocalDateTime.now(), "yyyy-MM-dd HH:ss:mm");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
        Date date = simpleDateFormat.parse("2020-07-11 09:15:09");
        System.out.println(date.getMonth());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1 = new Date();
        String format1 = sdf.format(date1);
        System.out.println(format1);

        // 医保跨月不可退
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date feeDateTime = simpleDateFormat1.parse("20201211091509");
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int feeMonth = feeDateTime.getMonth() + 1;
        System.out.println("currentMonth = " + currentMonth);
        System.out.println("feeMonth = " + feeMonth);
        if (currentMonth != feeMonth) {
            System.out.println(currentMonth + ": " + feeMonth);
        }

        System.out.println(date.getTime() + 10 * 1000 * 60);
        System.out.println(System.currentTimeMillis());

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        System.out.println("now.plusDays(1) = " + now.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:ss:mm")));

        System.out.println("now.plus(1, ChronoUnit.DAYS) = " + now.plus(1, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:ss:mm")));

        String dt = "2021-02-03 08:04:20";
        if (dt.length() == 19) {
            System.out.println(dt.replace(" ", "T").replace("-","").replace(":",""));
        }

        String nowDateTime = "2021-02-03 08:04:20";

        System.out.println(formatter(nowDateTime));

        String before = "2021-02-03 08:04:20";
        String after = "2021-02-03 23:04:20";

        LocalDateTime parseBefore = LocalDateTime.parse(before, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
        LocalDateTime parseAfter = LocalDateTime.parse(after, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));

        System.out.println(parseAfter.isAfter(parseBefore));

    }

    public static String formatter(String dateTime) {
        if (dateTime.length() == 19) {
            if (" ".equals(String.valueOf(dateTime.charAt(10)))){
                dateTime = dateTime.replace(" ", "T");
            }
            return dateTime.replace("-", "").replace(":", "");
        } else {
            return dateTime;
        }
    }
}
