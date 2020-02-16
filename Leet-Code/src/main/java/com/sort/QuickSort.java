package com.sort;

/**
 * 快速排序
 * <p>
 *
 *
 * @date:2019/11/28 14:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr_1000 = Common.generate_Arr_1000();
        quickSort(arr_1000, 0, arr_1000.length);
        showarr(arr_1000);
    }


    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int index = getIndex2(arr, low, high);
        quickSort(arr, low, index - 1);
        quickSort(arr, index + 1, high);
    }


    /**
     * 方法一 目的就是找到一个值 , 其实就是low索引所对应的的那个值
     * 他的左边全部小于他的右边, 然后返回他的位置, 继续递归
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }


    /**
     * 方法二
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int getIndex2(int[] arr, int low, int high) {
        int start = low;
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            swap(arr, low, high);
        }
        // 这里最好自己试一试
        arr[start] = arr[low];
        // 这里也是想一想就理解了
        arr[low] = tmp;
        return low;
    }


    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    private static void showarr(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count++;
            System.out.printf("%d\t", i);
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
}
