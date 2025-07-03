package designPattern.memento;

/**
 * @author sby
 * @Title: Memento
 * @Description: 备忘录
 * @date 2019/1/30 17:24
 */
public class Memento {

    private String state;

    public Memento(Originator originator) {
        this.state = originator.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
