package designPattern.command;

/**
 * @author sby
 * @Title: LightCommand
 * @Description: TODO
 * @date 2019/1/29 15:01
 */
public class LightCommand extends AbstractCommand {

    private Light light;

    LightCommand() {
        light = new Light();
    }


    @Override
    public void execute() {
        light.turnOn();
    }
}
