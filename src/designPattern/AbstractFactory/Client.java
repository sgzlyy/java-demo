package designPattern.AbstractFactory;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/22 14:07
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("designPattern.AbstractFactory.SummerSkinFactory");
        SkinFactory skinFactory = (SkinFactory) c.newInstance();

        Button button = skinFactory.createButton();
        button.display();

        TextField textField = skinFactory.createTextField();
        textField.display();
    }
}
