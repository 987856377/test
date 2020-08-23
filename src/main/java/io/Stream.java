package io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Stream {
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        String read = readFile("F:\\乱码启动.txt");
        System.out.println(read);
        System.out.println(((System.currentTimeMillis()) - l) + " ms");
    }

    public static String readFile(String filePath) throws IOException {
        String s = null;
        InputStream inputStream = new FileInputStream(new File(filePath));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        byte[] bytes = new byte[bufferedInputStream.available()];
        if (bufferedInputStream.read(bytes) > 0){
            s = new String(bytes, StandardCharsets.UTF_8);
        }

        bufferedInputStream.close();
        inputStream.close();
        return s;
    }

    public static String readUrl(String urlPath) throws IOException {
        String s = null;
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setConnectTimeout(1000 * 5);
        connection.connect();

        BufferedInputStream bufferedInputStream  = new BufferedInputStream(connection.getInputStream());

        byte[] bytes = new byte[bufferedInputStream.available()];
        if (bufferedInputStream.read(bytes) > 0){
            s = new String(bytes, StandardCharsets.UTF_8);
        }

        bufferedInputStream.close();
        connection.disconnect();
        return s;
    }
}
