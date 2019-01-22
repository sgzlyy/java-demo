package designPattern.FactoryMethod;

/**
 * @author sby
 * @Title: Apple
 * @Description: TODO
 * @date 2019/1/22 09:38
 */
public class Apple extends Phone {

    @Override
    void producePhone() {
        System.out.println("生产了一台苹果手机");
    }
}
