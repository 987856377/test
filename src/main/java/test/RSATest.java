package test;


import util.RSAUtil;

import java.util.Map;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-29 14:17
 **/
public class RSATest {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = RSAUtil.generateKeyPair();
        String publicKey = map.get("publicKey");
        String privateKey = map.get("privateKey");

        System.out.println("publicKey = " + publicKey);
        System.out.println("privateKey = " + privateKey);

        String data = "hello world";

        System.out.println("data = " + data);
        String encryptData = RSAUtil.encrypt(data, publicKey);
        System.out.println("encryptData = " + encryptData);

        String decryptData = RSAUtil.decrypt(encryptData, privateKey);
        System.out.println("decryptData = " + decryptData);
    }
}
