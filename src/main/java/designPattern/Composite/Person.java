package designPattern.Composite;

/**
 * @author sby
 * @Title: Person
 * @Description: TODO
 * @date 2019/1/23 17:04
 */
public class Person extends AbstractModel {

    private String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public void sendMsg() {
        System.out.println("发送消息给：" + name);
    }
}
