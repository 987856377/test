package proxy.dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

/**
 * @Description
 * @Project test
 * @Package proxy.dynamicProxy
 * @Author xuzhenkui
 * @Date 2020/4/19 10:02
 */
public class CGlibProxy implements MethodInterceptor {
    private Object targetClass;

    public Object getProxyInstance(Object targetClass) {
        this.targetClass = targetClass;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGlib 动态代理, 监听开始!");
        System.out.println("调用方法: "+method.getName());
        Object result = method.invoke(targetClass,objects);
        System.out.println("CGlib 动态代理, 监听结束!");
        return result;
    }
}
