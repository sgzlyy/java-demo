package designPattern.Singleton;

/**
 * @author sby
 * @Title: EagerSingleton
 * @Description: 饿汉式单例模式
 * @date 2019/1/23 11:04
 */
public class EagerSingleton {

    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }

}
