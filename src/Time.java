
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @Description
 * @Project test
 * @Package PACKAGE_NAME
 * @Author xuzhenkui
 * @Date 2019/8/17 11:50
 */
public class Time {
    public static void main(String[] args) throws ParseException {
/*        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(date1.getTime());
        System.out.println(date1.getTime()+120*1000*60);

        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);*/

        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        System.out.println(uuid);

    }
}
