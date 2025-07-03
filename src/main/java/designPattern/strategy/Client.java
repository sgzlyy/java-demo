package designPattern.strategy;

/**
 * @author sby
 * @Title: Client
 * @Description: 策略模式
 * @date 2019/1/31 15:52
 */
public class Client {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setPassword("123456");

        System.out.println("原始密码：" + user.getPassword());

        Class c = Class.forName("designPattern.strategy.SHA");
        Encryption encryption = (Encryption) c.newInstance();

        user.setEncryption(encryption);

        System.out.println("加密后密码：" + user.encrypt());
    }
}
