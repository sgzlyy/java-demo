package designPattern.Adapter;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/23 14:21
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("designPattern.Adapter.ToyAdapter");
        Toy toy = (Toy) c.newInstance();

        toy.lightOn();
        toy.soundOn();
        toy.move();
    }
}
