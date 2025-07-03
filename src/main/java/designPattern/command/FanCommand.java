package designPattern.command;

/**
 * @author sby
 * @Title: FanCommand
 * @Description: TODO
 * @date 2019/1/29 15:03
 */
public class FanCommand extends AbstractCommand {

    private Fan fan;

    FanCommand() {
        fan = new Fan();
    }


    @Override
    public void execute() {
        fan.turnOn();
    }
}
