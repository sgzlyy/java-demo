package designPattern.Singleton;

/**
 * @author sby
 * @Title: InnerClassSingleton
 * @Description: 静态内部类
 * @date 2019/1/23 11:44
 */
public class InnerClassSingleton {


    private InnerClassSingleton() {

    }

    private static class InnerClassSingletonHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonHolder.instance;
    }

}
