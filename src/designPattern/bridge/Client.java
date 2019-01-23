package designPattern.bridge;

/**
 * @author sby
 * @Title: Client
 * @Description: 桥接模式
 * @date 2019/1/23 15:36
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Class c1 = Class.forName("designPattern.bridge.Apple");
        Firm firm = (Firm) c1.newInstance();

        Class c2 = Class.forName("designPattern.bridge.RedPhone");
        Phone phone = (Phone) c2.newInstance();

        firm.setPhone(phone);
        firm.say();
    }
}
