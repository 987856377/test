package reflect.impl;

import reflect.annotation.Value;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description
 * @Project test
 * @Package annotation.impl
 * @Author xuzhenkui
 * @Date 2019/9/29 13:42
 */

public class AnnotationParse {
    /**
     * 解析注解
     * @param targetClassName 目标类（Class形式）
     * @param methodName 目标方法（在客户端调用哪个方法，methodName就代表哪个方法）
     * @return
     * @throws Exception
    */
    public static String parse(Class targetClassName,String methodName,String fieldName) throws Exception{
        //获得目标方法
        Method method = targetClassName.getMethod(methodName);
        Field field = targetClassName.getField(fieldName);

        String methodAccess = "";
        //判断目标方法上面是否存在@PrivilegeInfo注解
        //@Privilege（name="savePerson"）
        if(method.isAnnotationPresent(Value.class) || field.isAnnotationPresent(Value.class)){
            //得到方法上的注解
            Value value = method.getAnnotation(Value.class);
            //得到注解中的name值
            methodAccess = value.value();
        }
        return methodAccess;
    }
}
