package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Project test
 * @Package test
 * @Author xuzhenkui
 * @Date 2020/1/2 17:07
 */
public class Test2 {
    public static void main(String[] args) {
        int i = 8 << 2;
        int j = 20 >> 2;

//        int i = 8;
//        i = i * 4;

        System.out.println(i);
        System.out.println(j);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));

        String s = "3X0118";
        System.out.println(s.substring(0,s.length()-2));

    }

}
