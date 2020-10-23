package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\omen\\桌面\\ssr.txt";
        System.out.println("readFile(filePath) = " + readFile(filePath));
    }

    public static String readFile(String filePath) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (channel.read(buffer) != -1){
            buffer.flip();
            while (buffer.hasRemaining()){
                stringBuffer.append((char) buffer.get());
            }
            buffer.compact();
            buffer.clear();
        }
        channel.close();
        fileInputStream.close();
        return stringBuffer.toString();
    }
}
