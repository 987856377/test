package design;

import design.args.Input;
import design.args.Output;

/**
 * @program: test
 * @package design
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-01 14:24
 **/
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
