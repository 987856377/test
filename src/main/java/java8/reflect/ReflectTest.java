package java8.reflect;

import tool.xml.convert.User;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = A.class;
        Field field = clazz.getField("list");
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Stream.of(type.getActualTypeArguments()).forEach(System.out::println);

        field = clazz.getField("list1");
        type = (ParameterizedType) field.getGenericType();

        Stream.of(type.getActualTypeArguments()).forEach(System.out::println);
        System.out.println("type.getActualTypeArguments()[0].getTypeName() = " + type.getActualTypeArguments()[0].getTypeName());


        field = clazz.getField("list2");
        type = (ParameterizedType) field.getGenericType();

        Stream.of(type.getActualTypeArguments()).forEach(System.out::println);
        System.out.println("type.getActualTypeArguments()[0] = " + type.getActualTypeArguments()[0]);
    }

    class A {
        public List<? extends String> list = new ArrayList<>();

        public List<Integer> list1 = new ArrayList<>();
        public List<User> list2 = new ArrayList<>();
    }
}
