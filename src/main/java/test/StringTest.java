package test;

import java.io.IOException;

public class StringTest {
    public static void main(String[] args) throws IOException {
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

    }

    private static String change(String s){
        return s;
    }

    public static char charConvertor(char c){
        if ((int)c >= 65 && (int)c <= 90 ){
            return (char) (c + 32);
        } else if ((int)c >= 97 && (int)c <= 122 ){
            return (char) (c - 32);
        } else {
            return c;
        }
    }

}
