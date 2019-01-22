package designPattern.AbstractFactory;

/**
 * @author sby
 * @Title: SpringSkinFactory
 * @Description: TODO
 * @date 2019/1/22 14:05
 */
public class SpringSkinFactory extends SkinFactory {

    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
}
