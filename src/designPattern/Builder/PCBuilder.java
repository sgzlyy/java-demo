package designPattern.Builder;

/**
 * @author sby
 * @Title: PCBuilder
 * @Description: TODO
 * @date 2019/1/22 17:37
 */
public class PCBuilder extends ComputerBuilder {

    @Override
    public void buildCPU() {
        computer.setCPU("英特尔I7");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("DELL");
    }
}
