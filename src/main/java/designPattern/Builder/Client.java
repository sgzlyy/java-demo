package designPattern.Builder;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/22 17:43
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("designPattern.Builder.MACBuilder");
        ComputerBuilder computerBuilder = (ComputerBuilder) c.newInstance();

        ComputerController computerController = new ComputerController();
        Computer computer = computerController.construct(computerBuilder);

        System.out.println(computer.toString());
    }
}
