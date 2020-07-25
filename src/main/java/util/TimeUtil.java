package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhushouming
 * @Date: 2018/6/15 10:13
 * @Description:
 */
public class TimeUtil {
    public static final String YTD = "yyyy-MM-dd";
    public static final String YTDMS = "yyyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat dateFormat;
    static {
        dateFormat = new SimpleDateFormat(YTD);
    }

    /**
     * 当前日期加上指定分钟
     * @param minute
     * @return 返回增加指定分钟后的时间
     */
    public static String addAppointMinute(long minute){
        dateFormat = new SimpleDateFormat(YTDMS);
        Date date = new Date();
        long time = date.getTime();//指定日期毫秒数
        time = time+(minute * 60 * 1000);
        Date newDate = new Date(time);
        return dateFormat.format(newDate);
    }

    /**
     * 当前时间加上指定天数
     * @param days
     * @return 指定天数后的时间
     */
    public static String addAppointDay(long days){
        dateFormat = new SimpleDateFormat(YTDMS);
        Date date = new Date();
        long time = date.getTime();//指定日期毫秒数
        time = time+(days * 24 * 60 * 60 * 1000);
        Date newDate = new Date(time);
        return dateFormat.format(newDate);
    }
    /**
     * 指定时间加上指定分钟
     * @param minute
     * @param date
     * @return 指定天数后的时间
     */
    public static String addAppointMinuteNew(long minute,Date date){
      dateFormat = new SimpleDateFormat(YTDMS);
      long time = date.getTime();//指定日期毫秒数
      time = time+(minute * 60 * 1000);
      Date newDate = new Date(time);
      return dateFormat.format(newDate);
    }
    
    public static Date addMinute(long minute,Date date){
        dateFormat = new SimpleDateFormat(YTDMS);
        long time = date.getTime();//指定日期毫秒数
        time = time+(minute * 60 * 1000);
        Date newDate = new Date(time);
        return newDate;
    }
}
