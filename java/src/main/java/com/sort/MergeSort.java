package com.sort;

/**
 * 归并排序
 *
 * @date:2020/1/1 18:34
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr_1000 = Common.generate_Arr_1000();

//
//        int[] arr1 = {5, 6, 7, 8};
//        int[] arr2 = {1, 2, 3, 4};
//
//        merge(arr1, arr2);

        splitAndMergerSort(arr_1000, 0, arr_1000.length - 1);


        Common.showArr(arr_1000);
    }


    /**
     * 将数组分割成 一个一个的 ,递归实现
     *
     * @param arr   数组
     * @param start 开始位置 ,索引从0开始
     * @param end   结束位置 , 索引0开始
     */
    private static void splitAndMergerSort(int[] arr, int start, int end) {
        if (start == end) return;

        int middle = (end + start) >> 1;

        splitAndMergerSort(arr, start, middle);

        splitAndMergerSort(arr, middle + 1, end);

        merge(arr, start, end, middle + 1);
    }


    /**
     * @param arr       数据
     * @param start     索引从0开始 , 数组开始位置
     * @param end       索引从0开始 , 数组结束位置
     * @param delimiter 切割位置 : [1,2,4,5]   参数(arr,0 , 3 , 2) , 分隔符是 (star+end)/2+1
     */
    private static void merge(int[] arr, int start, int end, int delimiter) {
//        System.out.println(start + "," + end + "," + delimiter);
        if (start == end) return;

        // 1. 初始化数组
        int llen = delimiter - start;
        int rlen = (end - delimiter) + 1;

        int[] left = new int[llen];
        int[] right = new int[rlen];

        //2. 将分割数组 , 填充数据
        System.arraycopy(arr, start, left, 0, llen);
        System.arraycopy(arr, delimiter, right, 0, rlen);

        // 3.归并步骤
        int l = 0;
        int r = 0;
        int len = end + 1;
        for (int i = start; i < len; ++i) {
            if (l < llen && r < rlen) {
                if (left[l] < right[r]) {
                    arr[i] = left[l];
                    l++;
                } else {
                    arr[i] = right[r];
                    r++;
                }
            } else {
                if (l < llen) {
                    arr[i] = left[l];
                    l++;
                }
                if (r < rlen) {
                    arr[i] = right[r];
                    r++;
                }
            }
        }
    }


    private static void insertSort(int[] arr) {
        if (null == arr || arr.length == 1) return;
        // 1,3,4,2
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int end = i - 1;
            while (end >= 0 && temp < arr[end]) {
                arr[end + 1] = arr[end];
                end = end - 1;
            }
            arr[end + 1] = temp;
        }
    }


    private static void merge(int[] left_arr, int[] right_arr) {
        int lL = left_arr.length;
        int rL = right_arr.length;
        int resultL = lL + rL;
        int[] result = new int[resultL];

        int l = 0;
        int r = 0;
        int w = 0;
        while (w < resultL) {
            if (l < lL && r < rL) {
                if (left_arr[l] < right_arr[r]) {
                    result[w] = left_arr[l];
                    l++;
                    w++;
                } else {
                    result[w] = right_arr[r];
                    r++;
                    w++;
                }
            } else {
                if (l < lL) {
                    System.arraycopy(left_arr, l, result, w, lL - l);
                    break;
                }
                if (r < rL) {
                    System.arraycopy(right_arr, r, result, w, rL - r);
                    break;
                }
            }
        }

        Common.showArr(result);
    }
}
