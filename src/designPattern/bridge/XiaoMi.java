package designPattern.bridge;

/**
 * @author sby
 * @Title: XiaoMi
 * @Description: TODO
 * @date 2019/1/23 15:35
 */
public class XiaoMi extends Firm {

    @Override
    public void say() {
        System.out.print("小米公司");
        phone.desc();
    }
}
