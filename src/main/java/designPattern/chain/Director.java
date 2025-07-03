package designPattern.chain;

/**
 * @author sby
 * @Title: Director
 * @Description: TODO
 * @date 2019/1/25 15:37
 */
public class Director extends AbstractRole {

    @Override
    public void processProject(Project project) {
        if (project.getFunds() < 10) {
            System.out.println("主任审批通过");
        } else {
            System.out.println("申请经费大于10元，交给校长审批");
            successor.processProject(project);
        }
    }
}
