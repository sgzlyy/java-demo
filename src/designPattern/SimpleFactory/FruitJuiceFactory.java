package designPattern.SimpleFactory;

/**
 * @author sby
 * @Title: FruitFactory
 * @Description: 简单工厂模式
 * @date 2019/1/9 17:15
 */
public abstract class FruitJuiceFactory {

    public static FruitJuice getFruitJuice(String fruitName) {

        FruitJuice fruitJuice = null;

        if ("orange".equals(fruitName)) {
            fruitJuice = new OrangeJuice();
        } else if ("apple".equals(fruitName)) {
            fruitJuice = new AppleJuice();
        }

        return fruitJuice;
    }
}
