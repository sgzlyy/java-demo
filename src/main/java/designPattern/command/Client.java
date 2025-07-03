package designPattern.command;

/**
 * @author sby
 * @Title: Client
 * @Description: 命令模式
 * @date 2019/1/29 15:11
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("designPattern.command.FanCommand");
        AbstractCommand command = (AbstractCommand) c.newInstance();

        PowerSwitch powerSwitch = new PowerSwitch(command);
        powerSwitch.on();
    }
}
