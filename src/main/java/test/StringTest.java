package test;

public class StringTest {
    public static void main(String[] args) {
        String ip = "http://127.0.0.1:8080";
        ip = ip.replace("127.0.0.1", "192.168.100.2");
        System.out.println(ip);
    }
}
