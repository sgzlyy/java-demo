package sort;

import java.util.Arrays;

/**
 * @author sby
 * @Title: SelectSort
 * @Description: 选择排序
 * @date 2018/9/29 10:21
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {43, 6, 67, 78, 45, 234, 7};

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

            System.out.println(Arrays.toString(arr));
        }
    }
}
