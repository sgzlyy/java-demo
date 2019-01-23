package designPattern.Singleton;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/23 11:06
 */
public class Client {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        System.out.println("eagerSingleton1 == eagerSingleton2 ？" + (eagerSingleton1 == eagerSingleton2));

        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println("lazySingleton1 == lazySingleton2 ？" + (lazySingleton1 == lazySingleton2));

        InnerClassSingleton innerClassSingleton1 = InnerClassSingleton.getInstance();
        InnerClassSingleton innerClassSingleton2 = InnerClassSingleton.getInstance();
        System.out.println("innerClassSingleton1 == innerClassSingleton2 ？" + (innerClassSingleton1 == innerClassSingleton2));
    }
}
