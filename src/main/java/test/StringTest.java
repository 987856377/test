package test;

import org.apache.commons.lang.StringEscapeUtils;
import proxy.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        BigDecimal bigDecimal = new BigDecimal(price);
        System.out.println(bigDecimal);
    }

}
