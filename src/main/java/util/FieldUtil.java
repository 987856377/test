package util;

import reflect.Person;
import reflect.annotation.NotNull;
import reflect.annotation.Nullable;
import xml.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
* @Description:   判断对象中每个成员变量都不为空
* @Param:
* @return:
* @Author: Xu Zhenkui
* @Date: 2020/8/31 14:41
*/
public class FieldUtil {

    /**
     * @Description: 判断对象中的成员变量都不为空
     * @Param:  Object clazz,                    需要验证的对象
     *          List<String> ignoreFieldSList   忽略验证的成员变量
     * @return:  List<String>                    数据为空成员变量
     * @Author: Xu Zhenkui
     * @Date: 2020/9/2 20:14
     */
    public static List<String> validAllFieldsNotNull(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(clazz) == null || "".equals(field.get(clazz))){
                    list.add(field.getName());
                } else if (field.get(clazz) instanceof Collection && ((Collection<?>) field.get(clazz)).size() == 0){
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


    /**
    * @Description: 判断对象中每个含有NotNull注解的成员变量都不为空，其他可为空
    * @Param:  Object clazz                    需要验证的对象
    * @return: List<String>                    数据为空成员变量
    * @Author: Xu Zhenkui
    * @Date: 2020/9/2 20:16
    */
    public static List<String> validFieldsNotNull(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(clazz) == null || "".equals(field.get(clazz))){
                        list.add(field.getName());
                    } else if (field.get(clazz) instanceof Collection && ((Collection<?>) field.get(clazz)).size() == 0){
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

    /**
     * @Description: 判断对象中每个含有Nullable注解的成员变量可为空，其他都不为空
     * @Param:  Object clazz                    需要验证的对象
     * @return: List<String>                    数据为空成员变量
     * @Author: Xu Zhenkui
     * @Date: 2020/9/2 20:16
     */
    public static List<String> validFieldsNullable(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!field.isAnnotationPresent(Nullable.class)) {
                    if (field.get(clazz) == null || "".equals(field.get(clazz))){
                        list.add(field.getName());
                    } else if (field.get(clazz) instanceof Collection && ((Collection<?>) field.get(clazz)).size() == 0){
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

    /**
    * @Description: 判断对象中不包含在ignoreFieldSList中的成员变量都不为空
    * @Param:  Object clazz,                    需要验证的对象
     *          List<String> ignoreFieldSList   忽略验证的成员变量
    * @return:  List<String>                    数据为空成员变量
    * @Author: Xu Zhenkui
    * @Date: 2020/9/2 20:14
    */
    public static List<String> validFieldsNotNull(Object clazz, List<String> ignoreFieldList) {
        if (ignoreFieldList == null || ignoreFieldList.size() == 0){
            return validAllFieldsNotNull(clazz);
        }

        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!ignoreFieldList.contains(field.getName())){
                    if (field.get(clazz) == null || "".equals(field.get(clazz))){
                        list.add(field.getName());
                    } else if (field.get(clazz) instanceof Collection && ((Collection<?>) field.get(clazz)).size() == 0){
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
        user.setUsername("dksld");
        List<String> list = new ArrayList<>();
//        list.add("dsds");
        user.setList(list);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        System.out.println("validAllFieldsNotNull(user) = " + validAllFieldsNotNull(user));

        List<String> ignoreList = new ArrayList<>();
        ignoreList.add("username");
        ignoreList.add("password");
        System.out.println("validFieldsNotNull(user,ignoreList) = " + validFieldsNotNull(user, ignoreList));

        System.out.println("validFieldsNonNull(user) = " + validFieldsNotNull(user));

        System.out.println("validFieldsNullable(user) = " + validFieldsNullable(user));
    }
}
