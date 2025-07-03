package designPattern.Builder;

/**
 * @author sby
 * @Title: ComputerController
 * @Description: TODO
 * @date 2019/1/22 17:41
 */
public class ComputerController {

    public Computer construct(ComputerBuilder cb) {

        cb.buildCPU();
        cb.buildDisplay();
        cb.buildMemory();

        return cb.createComputer();
    }
}
