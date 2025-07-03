package designPattern.Adapter;

/**
 * @author sby
 * @Title: Toy
 * @Description: TODO
 * @date 2019/1/23 14:16
 */
public abstract class Toy {

    public void move() {
        System.out.println("玩具动了");
    }

    public abstract void lightOn();

    public abstract void soundOn();
}
