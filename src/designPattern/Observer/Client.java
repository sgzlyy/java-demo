package designPattern.Observer;

/**
 * @author sby
 * @Title: Client
 * @Description: 观察者模式
 * @date 2019/1/31 11:43
 */
public class Client {

    public static void main(String[] args) {

        Cat cat = new TomCat();
        cat.join(new JerryMouse("Jerry1号"));
        cat.join(new JerryMouse("Jerry2号"));
        cat.join(new JerryMouse("Jerry3号"));
        cat.join(new JerryMouse("Jerry4号"));

        cat.call();
    }
}
