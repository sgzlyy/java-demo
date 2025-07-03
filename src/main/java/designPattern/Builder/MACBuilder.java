package designPattern.Builder;

/**
 * @author sby
 * @Title: PCBuilder
 * @Description: TODO
 * @date 2019/1/22 17:37
 */
public class MACBuilder extends ComputerBuilder {

    @Override
    public void buildCPU() {
        computer.setCPU("英特尔I5");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("8G固态");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("三星");
    }
}
