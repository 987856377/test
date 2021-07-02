package design.factory.sms;

public interface SmsService {
    Boolean sendSms(String mobile);

    Boolean valid(String mobile);
}
