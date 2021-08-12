package algorithm.sort;

import java.util.Arrays;

/**
 * @author sby
 * @Title: QuickSort
 * @Description: 快速排序
 * @date 2018/11/9 15:02
 */
public class Quick1Sort {

    public static void main(String[] args) {
        int[] arr = {43, 6, 67, 78, 45, 234, 7};

        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     * @author sby
     * @date 2021/7/30 11:11
     * @param arr
     * @return void
     **/
    private static void quickSort(int[] arr) {
        quickSortMethod(arr, 0, arr.length - 1);
    }

    private static void quickSortMethod(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int partition = partition(arr, startIndex, endIndex);
        quickSortMethod(arr, startIndex, partition - 1);
        quickSortMethod(arr, partition, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int i = startIndex;
        for (int j = i; j < endIndex; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }

        int tmp = arr[i];
        arr[i] = pivot;
        arr[endIndex] = tmp;

        return i;
    }
}
