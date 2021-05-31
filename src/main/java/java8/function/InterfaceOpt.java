package java8.function;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description
 * @Project test
 * @Package java8.collections.stream
 * @Author xuzhenkui
 * @Date 2020/5/11 8:48
 */
public class InterfaceOpt {
    public static void main(String[] args) throws Throwable {
//        消费型接口
        Consumer<String> consumer = System.out::println;
        Consumer<Integer> consumer1 = s -> System.out.println(Math.sqrt(s));

        consumer.accept("hello world");
        consumer1.accept(1);

//        供给型接口
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "BANANA";
            }
        };
        System.out.println(supplier.get());

//        函数型接口
        Function<String,Object> function = new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(function.apply("1"));

//        断定型接口
        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return Objects.nonNull(o);
            }
        };
        System.out.println(predicate.test("xzk"));

//      Optional类为了解决null值判断问题
        System.out.println("name: "+getUsername(new Person(new Student("frank"))));
        setUsername(new Person(new Student("lucy")));
        setUsername(new Person(new Student()));

        Student student = new Student();
        student.setName("1.1");

        // 如果 student name 不为空，则将年龄设置为20
        Optional.ofNullable(student).map(Student::getName).ifPresent(s -> student.setAge(20));

        // student name 是否为 null
        boolean present = Optional.ofNullable(student).map(Student::getName).isPresent();
        System.out.println("present = " + present);

        // student name 为 null 时，返回 0.0
        String s = Optional.ofNullable(student).map(Student::getName).orElse("0.0");
        System.out.println("s = " + s);

        // student name 不为 null 时，返回 name; 为 null 时，抛出 NoSuchElementException 异常
        String s1 = Optional.ofNullable(student).map(Student::getName).get();
        System.out.println("s1 = " + s1);

        String s2 = Optional.ofNullable(student).map(Student::getName).orElseThrow((Supplier<Throwable>) RuntimeException::new);
        System.out.println("s2 = " + s2);

    }

    public static String getUsername(Person person){
        return Optional.ofNullable(person).map(Person::getStudent).map(Student::getName).orElse(null);
    }

    public static void setUsername(Person person){
        Optional.ofNullable(person).map(Person::getStudent).map(Student::getName).map(s -> {
            System.out.println("name: "+s);
            return s;
        });
    }
}

class Person{
    private Student student;

    public Person() {
    }

    public Person(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

class Student{
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

