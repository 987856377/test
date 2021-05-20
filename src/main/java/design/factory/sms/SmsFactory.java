package design.factory.sms;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SmsFactory {
    private static final Map<String, SmsService> SMS_SERVICE_MAP = new ConcurrentHashMap<>();

    public static void register(String type, SmsService smsService) {
        if (type != null) {
            SMS_SERVICE_MAP.putIfAbsent(type, smsService);
        }
    }

    public static SmsService get(String type){
        return SMS_SERVICE_MAP.get(type);
    }
}
