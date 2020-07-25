package test;

import util.ExcelUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class NetFileReadTest {
    public static void main(String[] args) {
        try {
            String jsonStr = "";
            String filePath = "http://weixin.xtsrmyy.com.cn:8084//upload/file/2020/7/22/1595388490811R5376.xlsx";

            URL url1 = new URL(filePath);
            InputStream is1 = new BufferedInputStream(url1.openStream());

//            URL url = new URL(filePath);
//            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//            connection.setDoOutput(true);
//            connection.connect();
//
//            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            while ((jsonStr =  bufferedReader.readLine()) != null){
//                System.out.println(jsonStr);
//            }
//            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
