package com.sort;

import java.util.Arrays;

/**
 * 桶排序  ,其实就是区间排序  1,2,3,4,5,6  ,我们分成 0-3, 3-6的区间(首先区间是有顺序的)
 * , 1,2,3 进去区间一, 4,5,6进去区间二 , 然后区间内排序, 此时就构建了新的数组
 *
 * @date:2019/11/27 16:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class BucketSort {

    public static void main(String[] args) {

        int[] arr_1000 = Common.generate_Arr_1000();

        bucketSort(arr_1000, 10);

        Common.showArr(arr_1000);
    }

    /**
     * @param arr         数组
     * @param bucketCount 桶的个数
     */
    public static void bucketSort(int[] arr, int bucketCount) {
        int len = arr.length;
        if (len <= 1 || bucketCount <= 0) {
            return;
        }

        // 遍历一次找到最大值 最小值
        int max = arr[0], min = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        /**
         * 划分区间 , 比如  5 - 11 ,此时我们需要 / 桶数量 (假如 是 2), 如果我们不+1 , 6 / 2 = 3 ,那么 (11-5)/3=2 , 此时坐标2这个桶
         *
         * 所以区间需要+1 操作 , 所以上面就是 7/2=3.5=4 , (11-5)/4=1
         */
        int range = ((max - min + 1) % bucketCount) == 0 ? (max - min + 1) / bucketCount : (max - min + 1) / bucketCount + 1;


        // 创建桶 ,是一个二维数组
        int[][] bucket = new int[bucketCount][];

        for (int i : arr) {
            bucket[(i - min) / range] = arrAppend(bucket[(i - min) / range], i);
        }


        for (int[] ints : bucket) {
            sort(ints);
        }

        int count = 0;
        for (int[] ints : bucket) {
            if (ints != null) {
                for (int anInt : ints) {
                    arr[count++] = anInt;
                }
            }
        }


    }

    /**
     * 数组拷贝
     *
     * @param arr
     * @param value
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        //数组如果为空, 新建一个数组,
        if (arr == null) {
            arr = new int[0];
        }
        // 数组拷贝 , 其实就是长度+1
        arr = Arrays.copyOf(arr, arr.length + 1);
        // 将值复制
        arr[arr.length - 1] = value;

        //返回
        return arr;
    }


    private static void sort(int[] arr) {

        /**
         * 空 或者  0 / 1 都直接返回
         */
        if (null == arr || arr.length <= 1) {
            return;
        }

        // 2 3 1
        for (int index = 1; index < arr.length; index++) {

            // 当前位置 , 开始必须从第二个开始
            int temp = arr[index];

            // 左边位置
            int left = index - 1;

            // 移动坐标其实就是 ...
            while (left >= 0 && arr[left] > temp) {

                // 互换位置
                arr[left + 1] = arr[left];

                // 向前移动
                left--;
            }

            // 最后保存数据
            arr[left + 1] = temp;
        }
    }

}
