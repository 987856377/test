package java8.proxy.dynamicProxy;

import java8.proxy.UserService;
import java8.proxy.User;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Project test
 * @Package proxy.dynamicProxy
 * @Author xuzhenkui
 * @Date 2019/9/6 11:31
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        User user = new User("xzk", "123");;

        UserService userService = (UserService) new JdkProxy().getProxyInstance(Thread.currentThread().getContextClassLoader().loadClass("java8.proxy.UserServiceImpl").newInstance());
        String name = userService.create(user);

        UserService userService1 = (UserService) new CGlibProxy().getProxyInstance(Thread.currentThread().getContextClassLoader().loadClass("java8.proxy.UserServiceImpl").newInstance());
        System.out.println(userService1.create(user));

        UserService userService2 = getProxy(Thread.currentThread().getContextClassLoader().loadClass("java8.proxy.UserServiceImpl").newInstance());
        System.out.println(userService2.create(user));

    }

    public static UserService getProxy(Object object) {

        UserService userService = (UserService) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), (proxy, method, args) -> {
            if (method.getName().equals("create")) {
                System.out.println("INVOKE ---create--- METHOD");
                return method.invoke(object, args);
            }
            if (method.getName().equals("delete")) {
                System.out.println("INVOKE ---delete--- METHOD");
                return method.invoke(object, args);
            }
            System.out.println("调用方法: " + method.getName());
            return method.invoke(object, args);
        });
        return userService;
    }
}
