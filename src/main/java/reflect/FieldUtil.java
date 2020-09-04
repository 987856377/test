package reflect;

import reflect.Person;
import reflect.annotation.EnableNull;
import reflect.annotation.NotNull;
import reflect.annotation.Nullable;
import xml.User;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


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
                String fieldName = field.getName();
                Object fieldValue = field.get(clazz);
                if ((fieldValue == null || "".equals(fieldValue) && !field.getType().isPrimitive())){
                    list.add(fieldName);
                } else if (field.getType().getClassLoader() != null){
                    list.add(fieldName + "{");
                    list.addAll(validAllFieldsNotNull(fieldValue));
                    list.add( "}");
                } else if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).size() == 0){
                    list.add(fieldName);
                } else if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).size() == 0){
                    list.add(fieldName);
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
     *                  若成员变量为引用类型，引用类型中的成员变量必须使用相同的注解
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
                String fieldName = field.getName();
                Object fieldValue = field.get(clazz);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if ((fieldValue == null || "".equals(fieldValue) && !field.getType().isPrimitive())){
                        list.add(fieldName);
                    } else if (field.getType().getClassLoader() != null){
                        list.add(fieldName + "{");
                        list.addAll(validAllFieldsNotNull(fieldValue));
                        list.add( "}");
                    } else if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).size() == 0){
                        list.add(fieldName);
                    } else if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).size() == 0){
                        list.add(fieldName);
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
     *                  若成员变量为引用类型，引用类型中的成员变量必须使用相同的注解
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
                String fieldName = field.getName();
                Object fieldValue = field.get(clazz);
                if (!field.isAnnotationPresent(Nullable.class)) {
                    if ((fieldValue == null || "".equals(fieldValue) && !field.getType().isPrimitive())){
                        list.add(fieldName);
                    } else if (field.getType().getClassLoader() != null){
                        list.add(fieldName + "{");
                        list.addAll(validAllFieldsNotNull(fieldValue));
                        list.add( "}");
                    } else if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).size() == 0){
                        list.add(fieldName);
                    } else if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).size() == 0){
                        list.add(fieldName);
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
     * @Description: 判断对象中每个含有EnableNull注解的成员变量,默认可为空，可配置参数值，
     *                  为被该注解标记的成员变量不做判断，
     *                  若成员变量为引用类型，引用类型中的成员变量必须使用相同的注解
     * @Param:  Object clazz                    需要验证的对象
     * @return: List<String>                    数据为空成员变量
     * @Author: Xu Zhenkui
     * @Date: 2020/9/2 20:16
     */
    public static List<String> validFieldsEnableNull(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                Object fieldValue = field.get(clazz);
                if (field.isAnnotationPresent(EnableNull.class) && !field.getAnnotation(EnableNull.class).value()) {
                    if ((fieldValue == null || "".equals(fieldValue) && !field.getType().isPrimitive())){
                        list.add(fieldName);
                    } else if (field.getType().getClassLoader() != null){
                        list.add(fieldName + "{");
                        list.addAll(validAllFieldsNotNull(fieldValue));
                        list.add( "}");
                    } else if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).size() == 0){
                        list.add(fieldName);
                    } else if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).size() == 0){
                        list.add(fieldName);
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
     * @Description: 判断对象中每个含有注解的成员变量,默认可为空，可配置参数值，
     *                  为被该注解标记的成员变量不做判断，
     *                  若成员变量为引用类型，引用类型中的成员变量必须使用相同的注解
     * @Param:  Object clazz                    需要验证的对象
     * @return: List<String>                    数据为空成员变量
     * @Author: Xu Zhenkui
     * @Date: 2020/9/2 20:16
     */
    @Deprecated()
    public static List<String> validFieldsByAnnotation(Object clazz) {
        List<String> list = new ArrayList<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(EnableNull.class)) {
                if (!field.getAnnotation(EnableNull.class).value()){
                    list.addAll(valid(clazz,field));
                }
            } else if (field.isAnnotationPresent(NotNull.class)){
                list.addAll(valid(clazz,field));
            } else if (!field.isAnnotationPresent(Nullable.class)){
                list.addAll(valid(clazz,field));
            }
        }
        return list;
    }

    private static List<String> valid(Object clazz, Field field){
        List<String> list = new ArrayList<>();
        try {
            String fieldName = field.getName();
            Object fieldValue = field.get(clazz);
            if ((fieldValue == null || "".equals(fieldValue) && !field.getType().isPrimitive())){
                list.add(fieldName);
            } else if (field.getType().getClassLoader() != null){
                list.add(fieldName + "{");
                list.addAll(validFieldsByAnnotation(fieldValue));
                list.add( "}");
            } else if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).size() == 0){
                list.add(fieldName);
            } else if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).size() == 0){
                list.add(fieldName);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            list.add("IllegalAccessException");
            return list;
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
                String fieldName = field.getName();
                Object fieldValue = field.get(clazz);
                if (!ignoreFieldList.contains(field.getName())){
                    if ((fieldValue == null || "".equals(fieldValue) && !field.getType().isPrimitive())){
                        list.add(fieldName);
                    } else if (field.getType().getClassLoader() != null){
                        list.add(fieldName + "{");
                        list.addAll(validAllFieldsNotNull(fieldValue));
                        list.add( "}");
                    } else if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).size() == 0){
                        list.add(fieldName);
                    } else if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).size() == 0){
                        list.add(fieldName);
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
        Person person = new Person();
        person.setName("ksdh");
        user.setPerson(person);
        List<String> list = new ArrayList<>();
//        list.add("dsds");
        user.setList(list);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        List<String> ignoreList = new ArrayList<>();
        ignoreList.add("username");
        ignoreList.add("password");

        System.out.println("validAllFieldsNotNull(user) = " + validAllFieldsNotNull(user));

        System.out.println("validFieldsNotNull(user,ignoreList) = " + validFieldsNotNull(user, ignoreList));

        System.out.println("validFieldsNotNull(user) = " + validFieldsNotNull(user));

        System.out.println("validFieldsNullable(user) = " + validFieldsNullable(user));

        System.out.println("validFieldsEnableNull(user) = " + validFieldsEnableNull(user));

        System.out.println("validFieldsByAnnotation(user) = " + validFieldsByAnnotation(user));

        long l = System.currentTimeMillis();
        for ( int i = 0; i < 1000; i++){
            new Thread(() -> {
                try { TimeUnit.MILLISECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "validFieldsNotNull(user,ignoreList) = " + validFieldsNotNull(user, ignoreList));
            },"Thread-"+i+": ").start();
        }

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                Thread.currentThread().join(1000);
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + " join");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread-NIL").start();

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println("耗时：" + (System.currentTimeMillis() - l) + " ms");
    }
}
