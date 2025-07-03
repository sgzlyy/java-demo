package designPattern.FactoryMethod;

/**
 * @author sby
 * @Title: HuaWeiFactory
 * @Description: TODO
 * @date 2019/1/22 09:42
 */
public class HuaWeiFactory extends PhoneFactory {
    @Override
    PhoneProduct createProduct() {
        return new HuaWei();
    }
}
