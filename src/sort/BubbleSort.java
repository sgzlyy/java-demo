package sort;

import java.util.Arrays;

/**
 * @author sby
 * @Title: BubbleSort
 * @Description: 冒泡排序
 * @date 2018/9/29 09:52
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {43, 6, 67, 78, 45, 234, 7};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }

    }
}
