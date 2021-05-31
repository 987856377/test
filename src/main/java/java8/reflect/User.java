package java8.reflect;

import java8.reflect.annotation.Value;

/**
 * @Description
 * @Project test
 * @Package annotation
 * @Author xuzhenkui
 * @Date 2019/9/6 10:13
 */
public class User {
    @Value(value = "XuZhenkui")
    private String username;

    private String password;

    public User(){}

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
