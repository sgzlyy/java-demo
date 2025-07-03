package algorithm;

import java.util.BitSet;

/**
 * @author sby
 * @Title: BitSetTest
 * @Description: 判断大数量下一个整数是否存在
 * @date 2018/9/610:08
 */
public class BitSetTest {

    public static void main(String[] args) {
        // 1.定义int数组
        int[] array = new int[]{1, 3, 5, 7, 9, 88, 100};

        // 2.定义一个BitSet
        BitSet bitSet = new BitSet(100);

        // 3.把int数，通过bit位的索引位置存储
        // （例如：100这个数，放在BitSet的第100索引位上，由于bit只能存0和1，所以100存在就存true，不存在就存false）
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }

        System.out.println(bitSet.size());
        System.out.println(bitSet.get(5));
        System.out.println(bitSet.get(100));
        System.out.println(bitSet.get(6));
    }


}
