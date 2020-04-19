package proxy;

/**
 * @Description
 * @Project test
 * @Package proxy
 * @Author xuzhenkui
 * @Date 2019/8/26 19:19
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){}

    @Override
    public String create(User user) {
        System.out.println("传入参数: " + user.toString());
        System.out.println("用户" + user.getName()+": 创建成功!");
        return user.getName();
    }

    @Override
    public void delete(User user) {
        System.out.println("传入参数: " + user.toString());
        System.out.println("用户" + user.getName()+": 删除成功!");
    }
}
