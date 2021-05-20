package guava;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-01-28 15:53
 **/
public class RateLimiterTest {

    /*
    * 常用的限流算法有 漏桶算法、令牌桶算法。这两种算法各有侧重点：

    漏桶算法：漏桶的意思就像一个漏斗一样，水一滴一滴的滴下去，流出是匀速的。当访问量过大的时候这个漏斗就会积水。漏桶算法的实现依赖队列，一个处理器从队头依照固定频率取出数据进行处理。如果请求量过大导致队列堆满那么新来的请求就会被抛弃。漏桶一般按照固定的速率流出。
    令牌桶则是存放固定容量的令牌，按照固定速率从桶中取出令牌。初始给桶中添加固定容量令牌，当桶中令牌不够取出的时候则拒绝新的请求。令牌桶不限制取出令牌的速度，只要有令牌就能处理。所以令牌桶允许一定程度的突发，而漏桶主要目的是平滑流出。
        RateLimiter 使用了令牌桶算法，提供两种限流的实现方案：

        平滑突发限流(SmoothBursty)
        平滑预热限流(SmoothWarmingUp)

    * */

    public static void main (String[] args) {
        // 实现平滑突发限流通过 RateLimiter 提供的静态方法来创建：
        RateLimiter r = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            System.out.println("get 1 tokens: " + r.acquire() + "s");
        }


        // 设置每秒放置的令牌数为 5 个，基本 0.2s 一次符合每秒 5 个的设置。保证每秒不超过 5 个达到了平滑输出的效果。
        //在没有请求使用令牌桶的时候，令牌会先创建好放在桶中，所以此时如果突然有突发流量进来，由于桶中有足够的令牌可以快速响应。RateLimiter 在没有足够令牌发放时采用滞后处理的方式，前一个请求获取令牌所需等待的时间由下一次请求来承受。
        //平滑预热限流并不会像平滑突发限流一样先将所有的令牌创建好，它启动后会有一段预热期，逐步将分发频率提升到配置的速率。
        //比如下面例子创建一个平均分发令牌速率为 2，预热期为 3 分钟。由于设置了预热时间是 3 秒，令牌桶一开始并不会 0.5 秒发一个令牌，而是形成一个平滑线性下降的坡度，频率越来越高，在 3 秒钟之内达到原本设置的频率，以后就以固定的频率输出。这种功能适合系统刚启动需要一点时间来“热身”的场景。
        RateLimiter r1 = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.println("get 1 tokens: " + r1.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r1.acquire(1) + "s");
            System.out.println("end");
        }


//        RateLimiter rateLimiter = RateLimiter.create(10);
//        for (int i=0; i<100; i++) {
//            new Thread(() -> {
//                rateLimiter.acquire();
//                System.out.println("ok");
//            }).start();
//        }

//        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        RateLimiter limiter = RateLimiter.create(1.0); // 这里的1表示每秒允许处理的量为1个
//        for (int i = 1; i <= 10; i++) {
//            double waitTime = limiter.acquire(i);// 请求RateLimiter, 超过permits会被阻塞
//            System.out.println("cutTime=" + System.currentTimeMillis() + " call execute:" + i + " waitTime:" + waitTime);
//        }
//        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        System.out.println("start time:" + start);
//        System.out.println("end time:" + end);

    }

}
