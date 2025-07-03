package designPattern.command;

/**
 * @author sby
 * @Title: PowerSwitch
 * @Description: TODO
 * @date 2019/1/29 15:10
 */
public class PowerSwitch {

    private AbstractCommand cmd;

    PowerSwitch(AbstractCommand cmd) {
        this.cmd = cmd;
    }

    public void on() {
        cmd.execute();
    }
}
