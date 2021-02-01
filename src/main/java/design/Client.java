package design;

import design.args.Input;

/**
 * @program: test
 * @package design
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-01 14:27
 **/
public class Client {
    public static void main(String[] args) {
        Input input = new Input();
        input.setServiceId("1");
        input.setServiceName("run");
        input.setArgs(".....");

        Invoker invoker = new Invoker(new RunCommand(new Receiver()));
        invoker.execute();
    }
}
