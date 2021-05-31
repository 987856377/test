package java8.io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Reader {
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        String read = readFile("D:\\txt\\NationAreaDictionary.txt");
        System.out.println(read);
        System.out.println(((System.currentTimeMillis()) - l) + " ms");
    }

    public static String readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(new File(filePath));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuilder.append(temp);
        }

        bufferedReader.close();
        fileReader.close();
        return stringBuilder.toString();
    }

    public static String readUrl(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.connect();

        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuilder.append(temp).append("\n");
        }
        bufferedReader.close();
        connection.disconnect();
        return stringBuilder.toString();
    }
}
