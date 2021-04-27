package reflect;

import reflect.annotation.EnableNull;
import reflect.annotation.NotNull;
import reflect.annotation.Nullable;

public class Person {
    @EnableNull(value = false)
    private Boolean alive;
    private String name;
    private int age;
    @EnableNull
    @Nullable
    @NotNull
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{"
                + "\"alive\":"
                + alive
                + ",\"name\":\""
                + name + '\"'
                + ",\"age\":"
                + age
                + ",\"sex\":\""
                + sex + '\"'
                + "}";
    }
}
