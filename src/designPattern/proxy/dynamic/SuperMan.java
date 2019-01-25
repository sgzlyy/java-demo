package designPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sby
 * @Title: SuperMan
 * @Description: TODO
 * @date 2019/1/25 14:02
 */
public class SuperMan implements InvocationHandler {

    private Object object;

    public SuperMan(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        preRun();
        method.invoke(object, args);
        afterRun();

        return null;
    }


    private void preRun() {
        System.out.println("我是超人，跑步之前先去拯救下地球～");
    }

    private void afterRun() {
        System.out.println("跑完步，去电话亭换身衣服～");
    }
}
