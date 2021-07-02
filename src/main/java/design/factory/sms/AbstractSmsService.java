package design.factory.sms;

/**
 * @Description
 * @Project test
 * @Package design.factory.sms.impl
 * @Author xuzhenkui
 * @Date 2021/7/2 15:22
 */
public abstract class AbstractSmsService {

    public AbstractSmsService() {
        SmsFactory.register(getType(),getThis());
    }

    public abstract String getType();

    public abstract SmsService getThis();

    public Boolean valid(String mobile) {
        System.out.println("AbstractSmsService validate: " + mobile + " success");
        return true;
    }
}
