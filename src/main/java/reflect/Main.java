package reflect;

import com.sun.deploy.util.StringUtils;
import reflect.annotation.Value;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Project test
 * @Package annotation
 * @Author xuzhenkui
 * @Date 2019/9/6 10:15
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Constructor<User> constructor = User.class.getConstructor();
        User user = constructor.newInstance();

        Field field = User.class.getDeclaredField("username");
        field.setAccessible(true);
        String value = field.getAnnotation(Value.class).value();
        field.set(user,value);

        Method method = User.class.getDeclaredMethod("getUsername");

        System.out.println(method.invoke(user));
        System.out.println(user.getUsername());
    }

}
