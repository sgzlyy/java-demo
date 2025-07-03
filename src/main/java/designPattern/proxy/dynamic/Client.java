package designPattern.proxy.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author sby
 * @Title: Client
 * @Description: TODO
 * @date 2019/1/25 14:06
 */
public class Client {
    public static void main(String[] args) {

        Runner superRunner = new SuperRunner();
        InvocationHandler hander = new SuperMan(superRunner);

        Runner runner = (Runner) Proxy.newProxyInstance(Runner.class.getClassLoader(), SuperRunner.class.getInterfaces(), hander);
        runner.run();

    }
}
