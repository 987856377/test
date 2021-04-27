package util;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-01-28 15:53
 **/
public class RateLimiterTest {
    public static void main (String[] args) {
//        RateLimiter rateLimiter = RateLimiter.create(10);
//        for (int i=0; i<100; i++) {
//            new Thread(() -> {
//                rateLimiter.acquire();
//                System.out.println("ok");
//            }).start();
//        }

        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        RateLimiter limiter = RateLimiter.create(1.0); // 这里的1表示每秒允许处理的量为1个
        for (int i = 1; i <= 10; i++) {
            double waitTime = limiter.acquire(i);// 请求RateLimiter, 超过permits会被阻塞
            System.out.println("cutTime=" + System.currentTimeMillis() + " call execute:" + i + " waitTime:" + waitTime);
        }
        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("start time:" + start);
        System.out.println("end time:" + end);

    }

}
