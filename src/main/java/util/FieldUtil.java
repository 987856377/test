package util;

import reflect.annotation.NotNull;
import xml.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
* @Description:   判断对象中每个成员变量都不为空
* @Param:
* @return:
* @Author: Xu Zhenkui
* @Date: 2020/8/31 14:41
*/
public class FieldUtil {
    //    判断对象中每个成员变量都不为空
    public static List<String> validFieldsNonNull(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(clazz) == null || "".equals(field.get(clazz))){
                    list.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                list.add("IllegalAccessException");
                return list;
            }
        }
        return list;
    }

    public static List<String> validFieldsNonNull(Object clazz, List<String> ignoreFieldSList) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!ignoreFieldSList.contains(field.getName())){
                    if (field.get(clazz) == null || "".equals(field.get(clazz))){
                        list.add(field.getName());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                list.add("IllegalAccessException");
                return list;
            }
        }
        return list;
    }

    public static List<String> validFieldsNonNullByAnnotations(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class)) {
                    continue;
                } else {
                    if (field.get(clazz) == null || "".equals(field.get(clazz))){
                        list.add(field.getName());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                list.add("IllegalAccessException");
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        User user = new User();

        System.out.println("validFieldsNonNull(user) = " + validFieldsNonNullByAnnotations(user));
    }
}
