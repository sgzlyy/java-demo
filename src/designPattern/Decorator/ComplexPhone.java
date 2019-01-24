package designPattern.Decorator;

/**
 * @author sby
 * @Title: ComplexPhone
 * @Description: TODO
 * @date 2019/1/24 14:43
 */
public class ComplexPhone extends PhoneDecorator {

    public ComplexPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void calling() {
        super.calling();
        blingbling();
    }

    private void blingbling() {
        System.out.println("来电-闪光");
    }
}
