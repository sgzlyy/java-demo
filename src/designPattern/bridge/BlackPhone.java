package designPattern.bridge;

/**
 * @author sby
 * @Title: MIPhone
 * @Description: TODO
 * @date 2019/1/23 15:26
 */
public class BlackPhone implements Phone {

    @Override
    public void desc() {
        System.out.println("生产黑色手机");
    }
}
