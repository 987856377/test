package design.factory.sms.impl;

import design.factory.sms.SmsFactory;
import design.factory.sms.SmsService;

public class UMS86SmsServiceImpl implements SmsService {

    public UMS86SmsServiceImpl() {
        SmsFactory.register("ums86", this);
    }

    @Override
    public Boolean sendSms(String mobile) {
        System.out.println("UMS86SmsServiceImpl send to: " + mobile);
        return true;
    }
}
