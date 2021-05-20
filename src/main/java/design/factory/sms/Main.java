package design.factory.sms;

import design.factory.sms.impl.ChinaUnicomSmsServiceImpl;
import design.factory.sms.impl.UMS86SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        UMS86SmsServiceImpl ums86SmsService = new UMS86SmsServiceImpl();
        ChinaUnicomSmsServiceImpl chinaUnicomSmsService = new ChinaUnicomSmsServiceImpl();

//        SmsFactory.register("ums86", ums86SmsService);
//        SmsFactory.register("unicom", chinaUnicomSmsService);
        SmsFactory.get("ums86").sendSms("1850320215");
    }
}
