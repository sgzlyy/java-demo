package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyClass implements InvocationHandler {

    Object realClass = null;

    public ProxyClass(Object realClass) {
        this.realClass = realClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法前织入的内容");

        method.invoke(realClass, args);

        System.out.println("方法后织入的内容");

        return null;
    }
}
