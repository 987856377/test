package function;

/**
 * @Description
 * @Project test
 * @Package function
 * @Author xuzhenkui
 * @Date 2020/5/11 9:10
 */
public class Main {
    public static void main(String[] args) {
        Project project = new Project();
        project.build();
        project.compat();

        Builder builder = new Builder() {
            @Override
            public void build() {
                System.out.println("Builder build success");
            }
        };

        builder.build();
        builder.compat();
    }
}
