package thread.volatiles;

import util.SleepHelper;

/**
 * volatile 可见行
 * 注意jit（即时编译器）的优化
 **/
public class T01_HelloVolatile {
    private static volatile boolean running = true;

    private static void m() {
        System.out.println("m start");
        while (running) {
//            SleepHelper.sleepSeconds(1);
            //System.out.println("hello");
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {

        new Thread(T01_HelloVolatile::m, "t1").start();

        SleepHelper.sleepSeconds(1000);

        running = false;
    }
}
