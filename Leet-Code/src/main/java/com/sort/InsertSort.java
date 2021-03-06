package com.sort;

/**
 * 插入排序  比如 2,3,1  , 此时1进行插入排序,  1拿出来, 3和1比较大,就向后移动
 *
 * @date:2019/11/18 16:11
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class InsertSort {

    public static void main(String[] args) {

        int[] arr_1000 = Common.generate_Arr_1000();
        sort(arr_1000);
        Common.showArr(arr_1000);
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
