package designPattern.Builder;

/**
 * @author sby
 * @Title: ComputerBuilder
 * @Description: TODO
 * @date 2019/1/22 17:33
 */
public abstract class ComputerBuilder {

    protected Computer computer = new Computer();

    public abstract void buildCPU();

    public abstract void buildMemory();

    public abstract void buildDisplay();

    public Computer createComputer() {

        return computer;
    }
}
