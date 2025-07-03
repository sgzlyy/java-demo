package designPattern.Decorator;

/**
 * @author sby
 * @Title: PhoneDecorator
 * @Description: 装饰器类
 * @date 2019/1/24 14:36
 */
public class PhoneDecorator extends Phone {

    private Phone phone;

    public PhoneDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void calling() {
        phone.calling();
    }
}
