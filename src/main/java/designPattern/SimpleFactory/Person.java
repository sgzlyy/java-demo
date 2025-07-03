package designPattern.SimpleFactory;

/**
 * @author sby
 * @Title: Person
 * @Description: TODO
 * @date 2019/1/9 17:29
 */
public class Person {

    public static void main(String[] args) {

        FruitJuice fruitJuice = FruitJuiceFactory.getFruitJuice("apple");
        fruitJuice.getOneCupFruitJuice();
    }
}
