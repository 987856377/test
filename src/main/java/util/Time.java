package util;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        Date date1 = new Date();
        System.out.println(date1.getTime());
        System.out.println(date1.getTime()+120*1000*60);

        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        System.out.println(uuid);

        String saveFileName = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"@"+"fileName";
        System.out.println(saveFileName);

        Map map = new ConcurrentHashMap();
        map.put("hospitalCode","1-1");
        if (map.get("hospitalCode")!=null){
            map.put("hospitalCode","9857");
        }
        System.out.println(map.get("hospitalCode"));

        String name = "frank";
        System.out.println(name.replace("f","from"));

    }
}
