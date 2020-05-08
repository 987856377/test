package operator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Project test
 * @Package test
 * @Author xuzhenkui
 * @Date 2019/11/29 15:26
 */
public class DatetimeOperator {

    public static int getAgeByBirthDay(String birthDay){
        if (birthDay == null || birthDay.length()<4) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //得到当前的年份
        String cYear = sdf.format(new Date()).substring(0,4);
        String cMouth = sdf.format(new Date()).substring(5,7);
        String cDay = sdf.format(new Date()).substring(8,10);
        //得到生日年份
        String birth_Year = birthDay.substring(0,4);
        String birth_Mouth = birthDay.substring(5,7);
        String birth_Day = birthDay.substring(8,10);
        //年月日比较后得到年龄
        int age = Integer.parseInt(cYear) - Integer.parseInt(birth_Year);
        if ((Integer.parseInt(cMouth) - Integer.parseInt(birth_Mouth))<0) {
            age=age-1;
        }else if ((Integer.parseInt(cMouth) - Integer.parseInt(birth_Mouth))==0) {
            if ( (Integer.parseInt(cDay) - Integer.parseInt(birth_Day))>0) {
                age=age-1;
            }else {
                age = Integer.parseInt(cYear) - Integer.parseInt(birth_Year);
            }
        }else if ((Integer.parseInt(cMouth) - Integer.parseInt(birth_Mouth))>0) {
            age = Integer.parseInt(cYear) - Integer.parseInt(birth_Year);
        }
        return age;
    }


    public static void main(String[] args) {
//        String str = "helloword";
//        System.out.println(str.substring(0,2)+str.substring(str.length()-2));
//
//        String time = "2019-11-28 12:30:25";
//        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//
//        try {
//            date = simpleDateFormat.parse(time);
//            System.out.println(date.getDay());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
//
//        Date date1 = new Date(System.currentTimeMillis());
//        System.out.println(simpleDateFormat.format(date1));
        System.out.println(getAgeByBirthDay("2019-01-29"));


        SimpleDateFormat before=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar beforeCalendar = Calendar.getInstance();
        beforeCalendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(before.format(beforeCalendar.getTime()));

        SimpleDateFormat after=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar afterCalendar = Calendar.getInstance();
        afterCalendar.add(Calendar.DAY_OF_MONTH, +2);
        System.out.println(after.format(afterCalendar.getTime()));

        Calendar sendTime = Calendar.getInstance();
        Calendar verifyTime = Calendar.getInstance();
        sendTime.add(Calendar.MINUTE,30);
//        verifyTime.add(Calendar.DAY_OF_MONTH, +2);
        System.out.println(verifyTime.after(sendTime));

        String str = "";
        System.out.println("a".equals(str));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(Calendar.getInstance().getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,3);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
