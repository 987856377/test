package test;

import cn.hutool.http.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-01-01 11:29
 **/
public class HttpTest {
    public static void main(String[] args) throws InterruptedException {
        String hostUrl = "http://192.168.254.25:9526/hai/HttpEntry";
        String serviceUrl = "QueryPatientData";
        String param = "{\"hospitalCode\":\"1-1\",\"patientMedicalCardNumber\":\"372421193308154878\",\"patientMedicalCardType\":\"10\",\"patientType\":\"\",\"hospitalDistId\":\"BF2B50241B45B8C174B2C86D964BCD2F\"}";

        long start = System.currentTimeMillis();

        for ( int i = 0; i < 100; i++){
            Thread thread = new Thread(() -> {

                StringBuffer sb = new StringBuffer();
                try {
                    sb.append(hostUrl).append("/?").append("service=" + serviceUrl).append("&urid=").append("&pwd=").append("&parameter=" + URLEncoder.encode(param, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                String post = HttpUtil.post(sb.toString(), (String) null);

                System.out.println(Thread.currentThread().getName() + post);
            }, "Thread- " + i + " -Running: ");
            thread.start();
//            thread.join(); // 使线程顺序执行
        }


        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
