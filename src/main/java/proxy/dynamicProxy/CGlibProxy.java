package proxy.dynamicProxy;

import net.sf.cglib.proxy.*;
import proxy.UserServiceImpl;

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

//        使用 MethodInterceptor 做回调
        enhancer.setCallback(this);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                long l = System.currentTimeMillis();
//                System.out.println("CGlib 动态代理, 监听开始!");
//                System.out.println("调用方法: "+method.getName());
//                Object result = method.invoke(targetClass,objects);
//                System.out.println("CGlib 动态代理, 监听结束!");
//                System.out.println(method.getName() + "调用耗时: " + (System.currentTimeMillis() - l) + " ms");
//                return result;
//            }
//        });

//        使用 InvocationHandler 做回调
//        enhancer.setCallback(new InvocationHandler() {
//            @Override
//            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                long l = System.currentTimeMillis();
//                System.out.println("CGlib 动态代理, 监听开始!");
//                System.out.println("调用方法: "+method.getName());
//                Object result = method.invoke(targetClass,objects);
//                System.out.println("CGlib 动态代理, 监听结束!");
//                System.out.println(method.getName() + "调用耗时: " + (System.currentTimeMillis() - l) + " ms");
//                return result;
//            }
//        });

//        使用 Dispatcher 做回调，返回要加载并返回的实例
//        enhancer.setCallback(new Dispatcher() {
//            @Override
//            public Object loadObject() throws Exception {
//                return new UserServiceImpl();
//            }
//        });

//        使用 FixedValue 做回调，返回固定值
//        enhancer.setCallback(new FixedValue() {
//            @Override
//            public Object loadObject() throws Exception {
//                return "MethodInterceptor is Running! Method is Denied";
//            }
//        });

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long l = System.currentTimeMillis();
        System.out.println("CGlib 动态代理, 监听开始!");
        System.out.println("调用方法: "+method.getName());
        Object result = method.invoke(targetClass,objects);
        System.out.println("CGlib 动态代理, 监听结束!");
        System.out.println(method.getName() + "调用耗时: " + (System.currentTimeMillis() - l) + " ms");
        return result;
    }
}
