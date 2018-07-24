package thread.boundedQueue;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界队列练习
 */
public class BoundedQueue<T> {

    private Object[] items;

    // 下标
    private int addIndex, removeIndex, count;

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        items = new Integer[size];
    }


    /**
     * 添加元素
     *
     * @param t
     */
    public void add(T t) throws InterruptedException {

        lock.lock();

        try {

            // 此处不用if判断，是防止假唤醒
            while (items.length == count) {
                notFull.await();
            }

            items[addIndex] = t;

            //自增并判断
            if (++addIndex == items.length) {
                addIndex = 0;
            }

            ++count;

            System.out.println(Thread.currentThread() + " 插入一个元素，数组为：" + Arrays.toString(items));

            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    /**
     * 由头部删除一个元素
     */
    public T remove() throws InterruptedException {

        lock.lock();

        try {

            // 此处不用if判断，是防止假唤醒
            while (count == 0) {
                notEmpty.await();
            }

            // 此处没有写具体的删除方法
            Object x = items[removeIndex];
            items[removeIndex] = null;
            System.out.println(Thread.currentThread() + " 移除一个元素，数组为：" + Arrays.toString(items));

            //自增并判断
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }

            --count;

            notFull.signal();

            return (T) x;

        } finally {
            lock.unlock();
        }
    }

}
