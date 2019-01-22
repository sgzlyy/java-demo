package designPattern.FactoryMethod;

/**
 * @author sby
 * @Title: HuaWei
 * @Description: TODO
 * @date 2019/1/22 09:39
 */
public class HuaWei extends PhoneProduct {
    @Override
    void producePhone() {
        System.out.println("生产了一台华为手机");
    }
}
