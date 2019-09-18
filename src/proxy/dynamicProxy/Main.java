package proxy.dynamicProxy;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
        User user = new User();

        UserInterface user1 = (UserInterface) Proxy.newProxyInstance(UserInterface.class.getClassLoader(), new Class<?>[]{UserInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*if (method.getName().equals("sayHello")){
                    System.out.println("INVOKE ---sayHello--- METHOD");
                    return method.invoke(user,args);
                }
                if (method.getName().equals("sayBye")){
                    System.out.println("INVOKE ---sayBye--- METHOD");
                    return method.invoke(user, args);
                }*/
                /*switch (method.getName()){
                    case "sayHello":
                        System.out.println("INVOKE ---sayHello--- METHOD");
                        return method.invoke(user,args);

                    case "sayBye":
                        System.out.println("INVOKE ---sayBye--- METHOD");
                        return method.invoke(user, args);
                    default:
                        System.out.println("INVOKE ---"+user.getClass().getSimpleName()+"--- METHOD");
                        break;
                }
                return null;*/

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("方法: "+method.getName()+", 参数: ");
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters){
                    stringBuilder.append(parameter.getName());
                }
                System.out.println(stringBuilder.toString());
                return method.invoke(user,args);
            }
        });

        user.setName("Frank");
        user1.sayHello("C++");
        user1.sayBye("Java");
    }
}
