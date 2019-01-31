package designPattern.Observer;

/**
 * @author sby
 * @Title: TomCat
 * @Description: 被观察者实现类
 * @date 2019/1/31 11:29
 */
public class TomCat extends Cat {

    @Override
    public void call() {
        System.out.println("tom猫叫了");
        for (Mouse mouse : mouses) {
            mouse.run();
        }
    }
}
