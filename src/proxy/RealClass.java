package proxy;

public class RealClass implements RealClassI, RealClass2I {

    @Override
    public void realMethod(String name) {
        System.out.println("真实方法输出name：" + name);
    }

    @Override
    public void realMethod2(String name) {
        System.out.println("真实方法2输出name：" + name);
    }
}
