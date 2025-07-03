package designPattern.AbstractFactory;

/**
 * @author sby
 * @Title: SpringSkinFactory
 * @Description: TODO
 * @date 2019/1/22 14:05
 */
public class SummerSkinFactory extends SkinFactory {

    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
}
