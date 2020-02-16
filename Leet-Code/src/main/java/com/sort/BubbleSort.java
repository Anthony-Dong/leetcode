package com.sort;


/**
 * 冒泡排序 ; 就是将大的数组往上冒(我这里上指的是数组尾端) , 所以冒一次就可以将一个最大的数冒的最上面, 所以不需要每次都全部冒
 *
 * @date:2020/1/3 12:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr_1000 = Common.generate_Arr_1000();
        sort(arr_1000, 0, arr_1000.length);
        Common.showArr(arr_1000);
    }


    private static void sort(int[] arr, int start, int len) {
        for (int i = start; i < len; i++) {
            for (int j = start; j < len - start - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Common.swap(arr, j, j + 1);
                }
            }
        }
    }
}
