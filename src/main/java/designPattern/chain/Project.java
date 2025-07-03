package designPattern.chain;

/**
 * @author sby
 * @Title: Project
 * @Description: TODO
 * @date 2019/1/25 15:30
 */
public class Project {

    private String name;
    private int funds;

    public Project(String name, int funds) {
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
}
