package designPattern.Facade;

/**
 * @author sby
 * @Title: MainFrame
 * @Description: 外观模式（门面模式）
 * @date 2019/1/24 15:26
 */
public class MainFrame {

    private CPU cpu;
    private Memory memory;
    private OS os;

    public MainFrame() {
        cpu = new CPU();
        memory = new Memory();
        os = new OS();
    }

    public void start() {
        System.out.println("电脑启动...");
        cpu.run();
        memory.check();
        os.load();
    }


}
