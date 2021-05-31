package java8.proxy.staticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Project test
 * @Package PACKAGE_NAME
 * @Author xuzhenkui
 * @Date 2019/8/26 19:17
 */
public class ProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object object = method.invoke(proxy,args);
        System.out.println("after invoke");
        return object;
    }
}
