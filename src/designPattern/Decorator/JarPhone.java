package designPattern.Decorator;

/**
 * @author sby
 * @Title: JarPhone
 * @Description: TODO
 * @date 2019/1/24 14:39
 */
public class JarPhone extends PhoneDecorator {

    public JarPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void calling() {
        super.calling();
        shake();
    }

    private void shake() {
        System.out.println("来电-震动");
    }
}
