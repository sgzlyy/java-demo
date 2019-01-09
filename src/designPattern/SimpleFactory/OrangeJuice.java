package designPattern.SimpleFactory;

/**
 * @author sby
 * @Title: OrangeJuice
 * @Description: TODO
 * @date 2019/1/9 17:26
 */
public class OrangeJuice implements FruitJuice {

    @Override
    public void getFruitJuice() {
        System.out.println("获得一杯橙子！");
    }
}
