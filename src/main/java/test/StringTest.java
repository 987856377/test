package test;

import tool.util.DateUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String ip = "http://127.0.0.1:8080";
//        ip = ip.replace("127.0.0.1", "192.168.100.2");
//        System.out.println(ip);
//
//        String result  = "{\"Item\":\"\",\"MsgHeader\":[{\"Sender\":\"MRC\",\"Status\":\"true\",\"Detail\":\"操作成功\",\"ErrCode\":\"\"}";
//
//        System.out.println(StringEscapeUtils.unescapeJavaScript(result));
//
//        String requestNo = "";
//        if (("").equals(requestNo)) {
//            System.out.println("hkajksl");
//        }
//
//        String tableName = "ENR_JL01";
//        String table = "portal56.GY_IDENTITY_"
//                + tableName.substring(0, tableName.indexOf("_"));
//
//        System.out.println(table);
//
//        String price = "17.50";
//        BigDecimal bigDecimal = new BigDecimal("0.00");
//        System.out.println(bigDecimal);
//
//        String s = "hello world";
//        System.out.println("s.replace(\"o\",\"g\") = " + s.replace("o", "g"));
//        System.out.println("s.replace(\"o\",\"g\") = " + s.replaceAll("o", "g"));
//
//        System.out.println(new BigDecimal("0.00"));
//
//
//
//        String string = UUID.randomUUID().toString();
//        string  = string.substring(0,16);
//        System.out.println("UUID.randomUUID().toString() = " +  string + ": " + string.length());
//
//        BigDecimal decimal = new BigDecimal("1.25");
//        BigDecimal decimal1 = new BigDecimal("1.65");
//        int i = decimal1.subtract(decimal).compareTo(BigDecimal.ZERO);
//        System.out.println("i = " + i);
//
//        System.out.println("decimal1.subtract(decimal) = " + decimal.subtract(decimal1).setScale(2, BigDecimal.ROUND_HALF_UP));


//        // 小写字母转大写
//        char c = ip.charAt(0);
//        System.out.println((int)c);
//
//        char c1 = (char) (c - 32);
//        System.out.println(c1);
//
//        // 大写字母转大小写
//        char c3 = (char) (c1 + 32);
//        System.out.println(c3);
//
//        System.out.println("ip = " + ip);
//        String replace = ip.replace(ip.charAt(0), charConvertor(ip.charAt(0)));
//        System.out.println("replace = " + replace);

        String s1 = null;
        String s2 = "";


        System.out.println((s1 == null ? "" : s1).equals(s2 == null ? "" : s2));

        System.out.println("s1.equals(s2) = " + s2.equals(s1));

        String ss = "1-1";
        System.out.println(change(String.valueOf(ss.charAt(0))));
        System.out.println(ss.substring(0, 1));

        String decode = URLDecoder.decode("http://172.31.1.92:9526/hai/HttpEntry//?service=/inspectionreport/listInspectionReport&urid=&pwd=&parameter=%7B%22patientIdentityCardNumber%22%3A%2237070419960322001X%22%2C%22pageSize%22%3A20%2C%22source%22%3A%229%22%2C%22hospitalCode%22%3A%221%22%2C%22pageNo%22%3A1%2C%22hospitalDistId%22%3A%22A73D49255EC8ECD6069839D354A12B79%22%2C%22patientIdentityCardType%22%3A%221%22%2C%22patientCode%22%3A%222973446%22%7D");
        System.out.println(decode);

        Object o = Class.forName("java.lang.Object").newInstance();
        System.out.println("o.toString() = " + o.toString());

        String date = "2021-01-27 17:07:13";
        System.out.println("DateUtils.stringToLocalDateTime(date) = " + DateUtils.stringToLocalDateTime(date));


        String dayAfter = LocalDateTime.now().plusDays(-1).toString();
        String dayBefore = LocalDate.now().plusDays(2).toString();

        System.out.println("dayAfter = " + dayAfter);
        System.out.println("dayBefore = " + dayBefore);

        String[] list = {"dsk", "dsd"};
        Arrays.stream(list).forEach(System.out::println);

    }

    private static String change(String s) {
        return s;
    }

    public static char charConvertor(char c) {
        if ((int) c >= 65 && (int) c <= 90) {
            return (char) (c + 32);
        } else if ((int) c >= 97 && (int) c <= 122) {
            return (char) (c - 32);
        } else {
            return c;
        }
    }

    class A{

    }

}
