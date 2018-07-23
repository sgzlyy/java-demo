package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 用非线程安全的HashMap和读写锁，实现线程安全的缓存
 */
public abstract class ReadWriteLockCache {

    static Map<String, Object> map = new HashMap<>();
    static ReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock r = lock.readLock();
    static Lock w = lock.writeLock();

    /**
     * 取一条记录
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    /**
     * 保存一条记录
     *
     * @param key
     * @param obj
     */
    public static void put(String key, Object obj) {
        w.lock();
        try {
            map.put(key, obj);
        } finally {
            w.unlock();
        }
    }

    /**
     * 清空所有记录
     */
    public static void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
