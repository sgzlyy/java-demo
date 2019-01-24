package designPattern.Decorator;

/**
 * @author sby
 * @Title: SimplePhone
 * @Description: TODO
 * @date 2019/1/24 14:34
 */
public class SimplePhone extends Phone {

    @Override
    public void calling() {
        System.out.println("来电-铃声响起-叮叮叮");
    }
}
