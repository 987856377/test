package proxy.staticProxy;

/**
 * @Description
 * @Project test
 * @Package proxy
 * @Author xuzhenkui
 * @Date 2019/8/26 19:19
 */
public class User implements UserInterface {
    private String name;
    public User(String name){
        this.name = name;
    }
    @Override
    public void sayHello(Object params) {
        System.out.println(this.name+" say:  hello "+ params);
    }

    @Override
    public void sayBye(Object params) {
        System.out.println(this.name+" say:  bye "+ params);
    }
}
