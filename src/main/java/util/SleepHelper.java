package util;

/**
 * TODO
 * @author sby
 * @date 2022/3/17 11:02
 */
public class SleepHelper {
    public static void sleepSeconds(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
