package designPattern.Singleton;

/**
 * @author sby
 * @Title: LazySingleton
 * @Description: 懒汉式单例模式
 * @date 2019/1/23 11:11
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {

        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}
