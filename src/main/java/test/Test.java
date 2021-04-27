package test;


import com.alipay.api.kms.aliyun.utils.Base64Utils;
import io.Stream;
import org.apache.commons.lang3.CharSetUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-03-12 15:10
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add("1");
        stringJoiner.add("2");
        stringJoiner.add("3");
        StringJoiner stringJoiner1 = new StringJoiner(",");
        stringJoiner1.add("4");
        stringJoiner1.add("5");
        stringJoiner1.add("6");
        System.out.println(stringJoiner.toString());
        System.out.println(stringJoiner.merge(stringJoiner1).toString());


    }
}
