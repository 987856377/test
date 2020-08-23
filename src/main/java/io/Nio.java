package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("F:\\乱码启动.txt"));
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int bytesRead = channel.read(buffer);
        while (bytesRead != -1){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.compact();
            bytesRead = channel.read(buffer);
        }
    }
}
