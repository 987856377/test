package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

/**
 * @Description
 * @Project test
 * @Package proxy.dynamicProxy
 * @Author xuzhenkui
 * @Date 2020/4/19 9:55
 */
public class JdkProxy implements InvocationHandler {
    private Object targetClass;

    public Object getProxyInstance(Object targetClass) {
        this.targetClass = targetClass;
        return Proxy.newProxyInstance(targetClass.getClass().getClassLoader(), targetClass.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK 动态代理, 监听开始");
        System.out.println("调用方法: "+method.getName());
        Object result = method.invoke(targetClass,args);
        System.out.println("JDK 动态代理, 监听结束!");
        return result;
    }
}
