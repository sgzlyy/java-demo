package designPattern.SimpleFactory;

/**
 * @author sby
 * @Title: AppleJuice
 * @Description: TODO
 * @date 2019/1/9 17:23
 */
public class AppleJuice implements FruitJuice {

    @Override
    public void getFruitJuice() {
        System.out.println("获得一杯苹果汁！");
    }
}
