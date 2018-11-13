package algorithm.sort;

import java.util.Arrays;

/**
 * @author sby
 * @Title: CountingSort
 * @Description: 计数排序
 * @date 2018/11/13 14:03
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {43, 6, 67, 78, 45, 67, 78, 234, 7};

        countingSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    // 计数排序，a 是数组，n 是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        // 查找数组中的最大值
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 定义一个最大值长度的数组
        int[] c = new int[max + 1];

        // 计算需要排序的数组a中每个值的个数，放到c数组对应的索引位置上
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        // 把数组c做累加（用于记录比当前索引值小的数据个数）
        for (int i = 1; i < max + 1; i++) {
            c[i] = c[i] + c[i - 1];
        }

        // 用临时数组记录数据
        int[] r = new int[n];

        // 根据c数组累加后的个数，计算数据应在排序后的位置，放入到临时数组中
        for (int i = 0; i < n; i++) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 拷贝临时数据到原数组中
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

}
