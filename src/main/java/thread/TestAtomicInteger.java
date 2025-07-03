package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sby
 * @Title: TestAtomicInteger
 * @Description: TODO
 * @date 2018/9/11 09:48
 */
public class TestAtomicInteger {


    public static void main(String[] args) throws InterruptedException {

        // 线程计数器，初始值为线程的数量
        CountDownLatch countDownLatch = new CountDownLatch(100);

        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    atomicInteger.getAndIncrement();

                    countDownLatch.countDown();
                }
            }.start();
        }

        // 主线程会等待其他线程执行完毕再执行
        countDownLatch.await();

        System.out.println(atomicInteger.get());

    }
}
