package com.sort;


/**
 * 选择排序 , 从开始位置每次找出最小那个数字, 放到开始位置 ,然后开始位置++
 *
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr_1000 = Common.generate_Arr_1000();

        sort(arr_1000, 0, arr_1000.length);

        Common.showArr(arr_1000);
    }

    private static void sort(int[] arr, int start, int len) {
        for (int i = start; i < len; ++i) {
            int min = i;
            for (int j = i + 1; j < len; ++j) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            Common.swap(arr, i, min);
        }
    }
}
