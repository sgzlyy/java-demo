package designPattern.proxy.staticProxy;

/**
 * @author sby
 * @Title: SuperMan
 * @Description: TODO
 * @date 2019/1/25 14:02
 */
public class SuperMan implements Runner {

    private SuperRunner superRunner = new SuperRunner();

    @Override
    public void run() {
        preRun();
        superRunner.run();
        afterRun();
    }

    private void preRun() {
        System.out.println("我是超人，跑步之前先去拯救下地球～");
    }

    private void afterRun() {
        System.out.println("跑完步，去电话亭换身衣服～");
    }

}
