package java8.io.encrypt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        String request = "";
        byte[] encode = Base64.getEncoder().encode(request.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(encode));

        String response = "eyJjb2RlIjoyMDAsIm1lc3NhZ2UiOiLor7fmsYLmiJDlip8iLCJkYXRhIjp7ImlkIjoxLCJ1c2VybmFtZSI6Imtra2tra2siLCJwYXNzd29yZCI6IjExMTExMTEiLCJjcmVhdGVUaW1lIjpudWxsLCJ1cGRhdGVUaW1lIjpudWxsfX0=";
        byte[] decode = Base64.getDecoder().decode(response.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(decode));
    }
}
