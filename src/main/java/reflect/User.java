package reflect;

import reflect.annotation.Value;

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

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
