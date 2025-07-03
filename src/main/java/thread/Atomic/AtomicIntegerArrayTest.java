package thread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author sby
 * @Title: AtomicIntegerArrayTest
 * @Description: TODO
 * @date 2018/12/16 15:52
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[]{1, 2};

    static AtomicIntegerArray aia = new AtomicIntegerArray(value);

    public static void main(String[] args) {

        aia.addAndGet(0, 3);
        System.out.println(aia.get(0));
        System.out.println(value[0]);

    }
}
