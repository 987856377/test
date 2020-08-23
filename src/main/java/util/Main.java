package util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Project test
 * @Package util
 * @Author xuzhenkui
 * @Date 2020/6/1 14:12
 */
public class Main {
    public static void main(String[] args) {
        String str = "1";
        if ("1".equals(str)){
            System.out.println("1");
        }

        switch (str){
            case "1":
                System.out.println("0.0");
                break;
        }

        int a;
        try {
            try {
                System.out.println(1);
                a = 1/0;
            } catch (ArithmeticException e){
                System.out.println(2);
                a = 1/0;
            }
        }  catch (ArithmeticException e){
            System.out.println(3);
            e.printStackTrace();
        }
    }

}

