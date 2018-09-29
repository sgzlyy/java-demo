package sort;

import java.util.Arrays;

/**
 * @author sby
 * @Title: InsertSort
 * @Description: 插入排序
 * @date 2018/9/29 13:11
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {43, 6, 67, 78, 7, 45, 234, 7};

        for (int i = 0; i < arr.length; i++) {

            int j = i;
            int temp = arr[i];

            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}
