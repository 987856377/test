package java8.io.net;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONConverter;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Description
 * @Project development
 * @Package com.spring.development.tools.util
 * @Author xuzhenkui
 * @Date 2020/3/7 20:06
 */
public class HttpUtil {

    public static JSONObject doPostJSONRequest(String url, String token, JSONObject param) {
        JSONObject jsonObject;
        HttpURLConnection connection = null;
        PrintWriter printWriter = null;
        BufferedReader bReader = null;

        try {
            // 1.URL类封装了大量复杂的实现细节，这里将一个字符串构造成一个URL对象
            URL request = new URL(url);

            // 2.获取HttpURRLConnection对象
            connection = (HttpURLConnection) request.openConnection();

            // 3.调用connect方法连接远程资源
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Length", "" + param.size());
            connection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            connection.setRequestProperty("Authorization",token);
            connection.connect();

            // 4.将json数据写入到输出流中以提交数据
            printWriter = new PrintWriter(connection.getOutputStream(),true);
            printWriter.print(param.toString());
            printWriter.flush();

            //获取响应状态
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            // 5.访问资源数据，使用getInputStream方法获取一个输入流用以读取信息
            bReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8"));

            // 对数据进行访问
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String str = StringEscapeUtils.unescapeJavaScript(stringBuilder.toString());
            System.out.println(str);
            jsonObject = JSONObject.parseObject(StringEscapeUtils.unescapeJavaScript(stringBuilder.toString()));
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (printWriter != null){
                    printWriter.close();
                }
                if (bReader != null){
                    bReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 关闭链接
            connection.disconnect();
        }
        return null;
    }

    public static String doPostHbi(String hostUrl, String serviceUrl,String urid , String pwd,  JSONObject requestString) {
        String result = "";

        DataOutputStream out = null;

        BufferedReader reader = null;
        HttpURLConnection connection = null;
        try {
            Date start=new Date();
            String  host = hostUrl + "/?";
            StringBuffer sb = new StringBuffer();
            sb.append("service=" + serviceUrl);
            sb.append("&urid="+urid);
            sb.append("&pwd="+pwd);
            sb.append("&parameter=" + URLEncoder.encode(requestString.toJSONString(),"utf-8"));

//			logger.info("平台组装后的url:{}", host+sb.toString());
            URL postUrl = new URL(hostUrl+"/");
            connection = (HttpURLConnection) postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;Charset=UTF-8");
            connection.connect();
            out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(sb.toString());
            out.flush();
            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (SocketException e){
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            System.out.println("结果==============" + result);
            result = result.replace("\\","");
            Date end=new Date();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (connection != null) {
                connection.disconnect();
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;

    }


    public static void main(String[] args) {
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("hospitalCode","12312");
//        jsonObject.put("patientCode","6484618");
//        String token ="";
//        jsonObject.put("hospitalDistId","A73D49255EC8ECD6069839D354A12B79");
//        HttpUtil.doPostJSONRequest("http://10.80.5.38:9335/register/queryBusCards",token, jsonObject);

//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("code","3C151659");
//        String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZXMiOlsiQURNSU4iLCJEQkEiLCJBVURJVCJdLCJpc3MiOiJQcmVzY3JpcHRpb24gQ2lyY3VsYXRpb24gUGxhdGZvcm0iLCJzdWIiOiJBdXRob3JpemF0aW9uIFRva2VuIiwiYXVkIjoiYWRtaW4iLCJpYXQiOjE1OTA0ODYxNjQsImV4cCI6MTU5MTA5MDk2NH0.Rb1KfHtJEALoGKATnLvBwZIjOHvUFU2KhY8mZ6UXfZl24R0i_QLstaJM6Ts-W6vIcBzey5qLT4_8qVmzyPxnOw";
//        JSONObject object = HttpUtil.doPostJSONRequest("http://127.0.0.1:8090/pcp/organization/getOrgIntroductionByCode", token , jsonObject);
//        System.out.println(object);


        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("organizationId","1-1");
        jsonObject1.put("count","1");
        String s = doPostHbi("http://192.168.100.2:53509/hai/HttpEntry", "/webCloudClinic/getApplyNo", "", "", jsonObject1);
        System.out.println(s);
    }
}
