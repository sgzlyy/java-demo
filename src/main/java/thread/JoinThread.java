package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sby
 * @Title: JoinThread
 * @Description: TODO
 * @date 2018/12/15 17:27
 */
public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread preThread = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Join(preThread), "Thread-" + (i + 1));
            thread.start();
            preThread = thread;
        }

        System.out.println("main start");

        TimeUnit.SECONDS.sleep(10);

        System.out.println("main done !");
    }

    static class Join implements Runnable {

        Thread thread;

        Join(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(Thread.currentThread().getName() + " is done !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
