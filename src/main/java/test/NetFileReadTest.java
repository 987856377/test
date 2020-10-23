package test;

import io.Reader;
import io.Stream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class NetFileReadTest {
    public static void main(String[] args) {
        try {
            String jsonStr = "";
            String filePath = "http://weixin.xtsrmyy.com.cn:8084//upload/file/2020/7/22/1595388490811R5376.xlsx";

//            URL url1 = new URL(filePath);
//            InputStream is1 = new BufferedInputStream(url1.openStream());

            String urlPath = "https://www.baidu.com/";
            String read = Stream.readUrl(urlPath);
            System.out.println(read);

//            String s = Stream.readFile("E:\\Software\\1595388490811R5376.xlsx");
//            System.out.println(s);

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
