package test;

import org.apache.commons.lang.StringEscapeUtils;
import proxy.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class StringTest {
    public static void main(String[] args) {
        String ip = "http://127.0.0.1:8080";
        ip = ip.replace("127.0.0.1", "192.168.100.2");
        System.out.println(ip);

        String result  = "{\"Item\":\"\",\"MsgHeader\":[{\"Sender\":\"MRC\",\"Status\":\"true\",\"Detail\":\"操作成功\",\"ErrCode\":\"\"}";

        System.out.println(StringEscapeUtils.unescapeJavaScript(result));

        String requestNo = "";
        if (("").equals(requestNo)) {
            System.out.println("hkajksl");
        }

        String tableName = "ENR_JL01";
        String table = "portal56.GY_IDENTITY_"
                + tableName.substring(0, tableName.indexOf("_"));

        System.out.println(table);

        String price = "17.50";
        BigDecimal bigDecimal = new BigDecimal("0.00");
        System.out.println(bigDecimal);

        String s = "hello world";
        System.out.println("s.replace(\"o\",\"g\") = " + s.replace("o", "g"));
        System.out.println("s.replace(\"o\",\"g\") = " + s.replaceAll("o", "g"));

        System.out.println(new BigDecimal("0.00"));



        String string = UUID.randomUUID().toString();
        string  = string.substring(0,16);
        System.out.println("UUID.randomUUID().toString() = " +  string + ": " + string.length());

        BigDecimal decimal = new BigDecimal("1.25");
        BigDecimal decimal1 = new BigDecimal("1.65");
        int i = decimal1.subtract(decimal).compareTo(BigDecimal.ZERO);
        System.out.println("i = " + i);

        System.out.println("decimal1.subtract(decimal) = " + decimal.subtract(decimal1).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
