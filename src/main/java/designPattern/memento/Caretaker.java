package designPattern.memento;

/**
 * @author sby
 * @Title: Caretaker
 * @Description: 负责人
 * @date 2019/1/30 17:28
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
