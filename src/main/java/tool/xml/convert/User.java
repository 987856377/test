package tool.xml.convert;

import java8.reflect.Person;
import java8.reflect.annotation.EnableNull;
import java8.reflect.annotation.NotNull;
import java8.reflect.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    @NotNull
    private String username;

    @Nullable
    private String password;

    @EnableNull(value = false)
    private Boolean flag;

    @EnableNull
    private List<String> list;

    @NotNull
    private List<Person> personList;

    @Nullable
    @NotNull
    @EnableNull(value = false)
    private Person person;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "{"
                + "\"username\":\""
                + username + '\"'
                + ",\"password\":\""
                + password + '\"'
                + ",\"flag\":"
                + flag
                + ",\"list\":"
                + list
                + ",\"personList\":"
                + personList
                + ",\"person\":"
                + person
                + "}";
    }
}
