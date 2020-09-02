package xml;

import reflect.Person;
import reflect.annotation.EnableNull;
import reflect.annotation.NotNull;
import reflect.annotation.Nullable;

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

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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
}
