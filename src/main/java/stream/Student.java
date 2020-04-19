package stream;

import java.io.Serializable;

/**
 * @Description
 * @Project test
 * @Package stream
 * @Author xuzhenkui
 * @Date 2020/4/5 17:53
 */
public class Student implements Serializable {
    private String name;
    private Integer age;
    private Integer flag;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age, Integer flag) {
        this.name = name;
        this.age = age;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
