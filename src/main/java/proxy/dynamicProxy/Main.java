package proxy.dynamicProxy;

import proxy.User;
import proxy.UserService;
import proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Project test
 * @Package proxy.dynamicProxy
 * @Author xuzhenkui
 * @Date 2019/9/6 11:31
 */
public class Main {
    public static void main(String[] args) {

        User user = new User("xzk","123");
        UserService userService = (UserService) new JdkProxy().getProxyInstance(new UserServiceImpl());
        String name = userService.create(user);
        System.out.println(name + " 已创建");

        UserService userService1 = (UserService) new CGlibProxy().getProxyInstance(new UserServiceImpl());
        userService1.delete(user);

        UserService userService2 = getProxy();
        userService2.create(user);
    }

    public static UserService getProxy(){
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        UserService userService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class<?>[]{UserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("create")){
                    System.out.println("INVOKE ---create--- METHOD");
                    return method.invoke(userServiceImpl,args);
                }
                if (method.getName().equals("delete")){
                    System.out.println("INVOKE ---delete--- METHOD");
                    return method.invoke(userServiceImpl, args);
                }
                System.out.println("调用方法: "+method.getName());
                return method.invoke(userServiceImpl,args);
            }
        });
        return userService;
    }
}
