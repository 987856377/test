package Thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/1/17 10:40
 */
public class Main {

    public static void main(String[] args) {
//        TestNum sn = new TestNum();
//        new Thread(new Client(sn)).start();
//        new Thread(new Client(sn)).start();
//        new Thread(new Client(sn)).start();

        TicketCenter center = new TicketCenter("CHINA");
        new Thread(center).start();
        new Thread(center).start();

    }
}
