package designPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sby
 * @Title: Cat
 * @Description: 被观察者
 * @date 2019/1/31 11:26
 */
public abstract class Cat {

    protected static List<Mouse> mouses = new ArrayList<>();

    public void join(Mouse mouse) {
        mouses.add(mouse);
    }

    public void quit(Mouse mouse) {
        mouses.remove(mouse);
    }

    public abstract void call();
}
