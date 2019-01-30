package designPattern.memento;

/**
 * @author sby
 * @Title: Client
 * @Description: 备忘录模式
 * @date 2019/1/30 17:29
 */
public class Client {
    public static void main(String[] args) {

        // 创建原发器
        Originator originator = new Originator();
        originator.setState("状态1");
        System.out.println(originator.getState());

        // 创建备忘录
        Memento memento = originator.createMemeto();

        // 把备忘录交给负责人（原则上只有负责人能操作备忘录）
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);


        // 修改原发器状态
        originator.setState("状态2");
        System.out.println(originator.getState());

        // 恢复原发器状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
