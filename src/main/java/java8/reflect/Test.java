package java8.reflect;

import cn.hutool.core.util.ReflectUtil;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student();
        student.setName("xzk");
        student.setAge(22);
        student.setSex("男");
        student.setScore(91);
        student.setAlive(true);
        student.setTitle("");
        student.setLa(true);

        User user = new User();
        user.setUsername("\t\t\tasda");
        student.setUser(user);

        System.out.println(student);
        ExcelToFieldValueUtil.handleExcelTableCharacter(student);
        System.out.println(student);

        Person person = new Person();
        person.setAge(12);

        System.out.println(person);
        ExcelToFieldValueUtil.handleExcelTableCharacter(person);
        System.out.println(person);

        System.out.println(String.class.getClassLoader());
        System.out.println(Person.class.getClassLoader());

        ReflectUtil.setFieldValue(person, "name", "cl");
        System.out.println(person);

        System.out.println(Object.class.getClassLoader());

    }
}
