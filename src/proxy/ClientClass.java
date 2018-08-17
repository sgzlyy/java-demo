package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class ClientClass {

    public static void main(String[] args) {
 
        RealClass2I realCLass = new RealClass();

        InvocationHandler handler = new ProxyClass(realCLass);

        RealClass2I proxyRealCLass = (RealClass2I) Proxy.newProxyInstance(ProxyClass.class.getClassLoader(), RealClass.class.getInterfaces(), handler);

        proxyRealCLass.realMethod2("xxx");

        System.out.println(proxyRealCLass.getClass().getName());
    }

}
