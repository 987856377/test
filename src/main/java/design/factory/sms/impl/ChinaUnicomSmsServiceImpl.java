package design.factory.sms.impl;

import design.factory.sms.SmsFactory;
import design.factory.sms.SmsService;

public class ChinaUnicomSmsServiceImpl implements SmsService {

    public ChinaUnicomSmsServiceImpl() {
        SmsFactory.register("unicom", this);
    }

    @Override
    public Boolean sendSms(String mobile) {
        System.out.println("ChinaUnicomSmsServiceImpl send to: " + mobile);
        return true;
    }
}
