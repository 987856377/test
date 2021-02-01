package design;

/**
 * @program: test
 * @package design
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-01 14:28
 **/
public class RunCommand implements Command {
    private Receiver receiver;

    public RunCommand() {
    }

    public RunCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doAction();
    }
}
