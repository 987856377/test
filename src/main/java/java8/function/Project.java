package java8.function;

/**
 * @Description
 * @Project test
 * @Package java8.function
 * @Author xuzhenkui
 * @Date 2020/5/11 9:09
 */
public class Project implements Builder{
    @Override
    public void build() {
        System.out.println("Project build success");
    }

}
