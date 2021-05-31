package tool.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @program: test
 * @description
 * @author: XuZhenkui
 * @create: 2020-11-05 17:31
 **/
public class DateUtils {

    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String localDateTimeToString(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:ss:mm"));
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, String pattern){
        return localDateTime.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime dateToLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime stringToLocalDateTime(String s){
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
    }

    public static LocalDateTime stringToLocalDateTime(String s, String pattern){
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime longToLocalDateTime(Long epochMilli){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
    }

    public static void main(String[] args) {
        System.out.println(localDateTimeToString(LocalDateTime.now()));
    }
}
