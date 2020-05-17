package function;

/**
 * @Description
 * @Project test
 * @Package function
 * @Author xuzhenkui
 * @Date 2020/5/11 9:09
 */
public class Project implements Builder{
    @Override
    public void build() {
        System.out.println("Project build success");
    }

}
