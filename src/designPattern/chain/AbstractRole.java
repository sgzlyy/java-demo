package designPattern.chain;

/**
 * @author sby
 * @Title: AbstractRole
 * @Description: TODO
 * @date 2019/1/25 15:33
 */
public abstract class AbstractRole {

    protected AbstractRole successor;

    public AbstractRole() {
    }

    public void setSuccessor(AbstractRole successor) {
        this.successor = successor;
    }

    public abstract void processProject(Project project);
}
