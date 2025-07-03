package designPattern.chain;

/**
 * @author sby
 * @Title: Presiden
 * @Description: TODO
 * @date 2019/1/25 15:43
 */
public class Presiden extends AbstractRole {

    @Override
    public void processProject(Project project) {

        if (project.getFunds() >= 10) {
            System.out.println("校长审批结束");
        } else {
            System.out.println("主任为什么不审批？这点钱还找我？？？？");
        }

    }
}
