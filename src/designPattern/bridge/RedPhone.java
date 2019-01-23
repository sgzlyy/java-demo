package designPattern.bridge;

/**
 * @author sby
 * @Title: IPhone
 * @Description: TODO
 * @date 2019/1/23 15:25
 */
public class RedPhone implements Phone {

    @Override
    public void desc() {
        System.out.println("生产红色手机");
    }
}
