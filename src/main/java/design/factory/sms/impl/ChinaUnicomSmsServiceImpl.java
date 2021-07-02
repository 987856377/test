package design.factory.sms.impl;

import design.factory.sms.AbstractSmsService;
import design.factory.sms.SmsFactory;
import design.factory.sms.SmsService;

public class ChinaUnicomSmsServiceImpl extends AbstractSmsService implements SmsService {

//    public ChinaUnicomSmsServiceImpl() {
//        SmsFactory.register("unicom", this);
//    }

    @Override
    public String getType() {
        return "unicom";
    }

    @Override
    public SmsService getThis() {
        return this;
    }

    @Override
    public Boolean sendSms(String mobile) {
        if (valid(mobile)) {
            System.out.println("ChinaUnicomSmsServiceImpl send to: " + mobile);
            return true;
        } else {
            return false;
        }
    }
}
