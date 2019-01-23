package designPattern.bridge;

/**
 * @author sby
 * @Title: Apple
 * @Description: TODO
 * @date 2019/1/23 15:33
 */
public class Apple extends Firm {

    @Override
    public void say() {
        System.out.print("苹果公司");
        phone.desc();
    }
}
