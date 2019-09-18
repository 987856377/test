package proxy.staticProxy;

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
                    "frank"
            };
            ProxyHandler proxyHandler = new ProxyHandler();
            proxyHandler.invoke(new User("frank"),User.class.getMethod("sayHello", Object.class),params);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
