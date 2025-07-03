package designPattern.memento;

/**
 * @author sby
 * @Title: Originator
 * @Description: 原发器
 * @date 2019/1/30 17:23
 */
public class Originator {

    private String state;

    public Memento createMemeto() {
        return new Memento(this);
    }

    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
