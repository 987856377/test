package java8.reflect;

import java.io.Serializable;

public class UserBuilder implements Serializable {
    private String username;
    private String password;

    public UserBuilder setUsername(String username){
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public User build(){
        return build(this);
    }

    public static User build(UserBuilder userBuilder){
        return new User(userBuilder.username, userBuilder.password);
    }
}
