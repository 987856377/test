package annotation;

/**
 * @Description
 * @Project test
 * @Package annotation
 * @Author xuzhenkui
 * @Date 2019/9/6 10:13
 */
public class User {
    @Value(value = "frank")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
