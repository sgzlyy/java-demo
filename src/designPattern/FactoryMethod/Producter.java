package designPattern.FactoryMethod;

/**
 * @author sby
 * @Title: Producter
 * @Description: 工厂方法
 * @date 2019/1/22 09:43
 */
public class Producter {

    public static void main(String[] args) throws Exception {
        // 此处可通过配置文件和反射完成，更好的适应开闭原则
        Class c = Class.forName("designPattern.FactoryMethod.AppleFactory");
        PhoneFactory phoneFactory = (PhoneFactory) c.newInstance();

        //PhoneFactory phoneFactory = new HuaWeiFactory();

        PhoneProduct phoneProduct = phoneFactory.createProduct();
        phoneProduct.producePhone();
    }
}
