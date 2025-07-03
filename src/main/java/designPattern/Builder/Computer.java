package designPattern.Builder;

/**
 * @author sby
 * @Title: Computer
 * @Description: TODO
 * @date 2019/1/22 17:26
 */
public class Computer {

    private String CPU;
    private String memory;
    private String display;


    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {

        return "CPU：" + this.CPU + " ； memory：" + this.memory + " ； display：" + this.display;
    }
}
