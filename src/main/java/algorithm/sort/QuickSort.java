package algorithm.sort;

import java.util.Arrays;

/**
 * @author sby
 * @Title: QuickSort
 * @Description: 快速排序
 * @date 2018/11/9 15:02
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {43, 6, 67, 78, 45, 234, 7};

        quickSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }


    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }
}
