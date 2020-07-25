package test;

import util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
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

        String  s = "20200721240059";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        formatter.setLenient(false);
        Date newDate = formatter.parse(s);
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(formatter.format(newDate));
    }
}
