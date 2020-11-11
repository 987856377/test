package test;

import util.DateUtils;
import util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
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
        Date feeDateTime = simpleDateFormat1.parse("20200711091509");
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int feeMonth = feeDateTime.getMonth() + 1;
        if (currentMonth != feeMonth) {
            System.out.println(currentMonth + ": " + feeMonth);
        }
    }
}
