package java8.proxy.staticProxy;

import java8.proxy.UserService;
import java8.proxy.UserServiceImpl;
import java8.proxy.User;

/**
 * @Description
 * @Project test
 * @Package proxy
 * @Author xuzhenkui
 * @Date 2019/8/26 23:59
 */
public class Main {
    public static void main(String[] args) {
        try {
            Object[] params = new Object [] {
                    new User("frank","123")
            };
            ProxyHandler proxyHandler = new ProxyHandler();
            proxyHandler.invoke(new UserServiceImpl(), UserService.class.getMethod("create", User.class),params);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
