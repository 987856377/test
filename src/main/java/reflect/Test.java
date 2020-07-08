package reflect;

import java.util.HashMap;
import java.util.Map;

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

        Map<String, Map<String, String>> dictMap = new HashMap<>();

        Map map = new HashMap();
        map.put("是","1");
        map.put("否","0");

        dictMap.put("baseDrugAntibioticFlag",map);

        System.out.println(dictMap.get("baseDrugAntibioticFlag").get("其他"));

    }
}
