package tool.util;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import tool.util.RSAUtil;

import java.nio.charset.StandardCharsets;
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

        String content1 = "{\n" +
                "    \"id\":1\n" +
                "}";
//        String content = "{\"code\":200,\"data\":{\"id\":1,\"password\":\"1111111\",\"username\":\"kkkkkkk\"},\"message\":\"请求成功\"}";
        SymmetricCrypto sm4 = SmUtil.sm4("spring-framework".getBytes(StandardCharsets.UTF_8));

        String encryptHex1 = sm4.encryptHex(content1);
        String decryptStr1 = sm4.decryptStr(encryptHex1, CharsetUtil.CHARSET_UTF_8);
        System.out.println(encryptHex1+"\r\n"+decryptStr1);


        String content2 = "{\"code\":200,\"message\":\"请求成功\",\"data\":{\"id\":1,\"username\":\"kkkkkkk\",\"password\":\"1111111\",\"createTime\":null,\"updateTime\":null}}";
        String encryptHex2 = sm4.encryptHex(content2);
        String decryptStr2 = sm4.decryptStr(encryptHex2, CharsetUtil.CHARSET_UTF_8);
        System.out.println(encryptHex2+"\r\n"+decryptStr2);

        System.out.println(sm4.decryptStr("otZjYlYxPyqQgTh+Uk0KE4DAJTXQaI623iwzxBi6hEbUSezEAnPD4Gu7j1cnV0twcYxYHz7BaounlS1Tgo/deA==", StandardCharsets.UTF_8));
    }
}
