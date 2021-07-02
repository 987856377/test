package design.factory.sms.impl;

import design.factory.sms.AbstractSmsService;
import design.factory.sms.SmsFactory;
import design.factory.sms.SmsService;

public class UMS86SmsServiceImpl extends AbstractSmsService implements SmsService {

//    public UMS86SmsServiceImpl() {
//        SmsFactory.register("ums86", this);
//    }

    @Override
    public String getType() {
        return "ums86";
    }

    @Override
    public SmsService getThis() {
        return this;
    }

    @Override
    public Boolean sendSms(String mobile) {
        if (valid(mobile)){
            System.out.println("UMS86SmsServiceImpl send to: " + mobile);
            return true;
        } else {
            return false;
        }
    }
}
