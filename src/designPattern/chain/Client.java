package designPattern.chain;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/25 15:44
 */
public class Client {
    public static void main(String[] args) {
        Project project = new Project("买牛奶", 9);

        AbstractRole director = new Director();
        AbstractRole presiden = new Presiden();

        director.setSuccessor(presiden);

        director.processProject(project);
    }
}
