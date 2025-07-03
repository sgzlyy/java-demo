package designPattern.FactoryMethod;

/**
 * @author sby
 * @Title: AppleFactory
 * @Description: TODO
 * @date 2019/1/22 09:41
 */
public class AppleFactory extends PhoneFactory {
    @Override
    PhoneProduct createProduct() {
        return new Apple();
    }
}
