package io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Stream {
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        String read = readFile("D:\\txt\\NationAreaDictionary.txt");
        System.out.println(read);
        System.out.println(((System.currentTimeMillis()) - l) + " ms");
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] bytes = new byte[bufferedInputStream.available()];
        if (bufferedInputStream.read(bytes) > 0){
            stringBuilder.append(new String(bytes, StandardCharsets.UTF_8));
        }

        bufferedInputStream.close();

//        byte[] bytes = new byte[1024];
//        int n = 0;
//        while ((n = fileInputStream.read(bytes)) != -1)
//        {
//            stringBuilder.append(new String(bytes, 0, n));
//        }

        fileInputStream.close();
        return stringBuilder.toString();

    }

    public static String readUrl(String urlPath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setConnectTimeout(1000 * 5);
        connection.connect();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());

        byte[] bytes = new byte[bufferedInputStream.available()];
        if (bufferedInputStream.read(bytes) > 0) {
            stringBuilder.append(new String(bytes, StandardCharsets.UTF_8));
        }

        bufferedInputStream.close();
        connection.disconnect();
        return stringBuilder.toString();
    }
}
