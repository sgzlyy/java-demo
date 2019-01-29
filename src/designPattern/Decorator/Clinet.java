package designPattern.Decorator;

/**
 * @author sby
 * @Title: Clinet
 * @Description: 装饰器模式
 * @date 2019/1/24 14:45
 */
public class Clinet {

    public static void main(String[] args) {

        Phone phone = new SimplePhone();

        Phone jarPhone = new JarPhone(phone);

        Phone complexPhone = new ComplexPhone(jarPhone);

        complexPhone.calling();
    }
}
