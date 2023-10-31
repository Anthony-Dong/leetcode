package com.sort;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 通用包
 *
 * @date:2020/1/3 12:06
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Common {

    private static final Random random = new Random();
    private static final int[] arr = {5, 4, 1, 3, 2, 6};


    public static int[] generate_Arr_1000() {
        int[] arr_1000 = new int[1000];
        IntStream.range(0, 1000).forEach(e -> arr_1000[e] = random.nextInt(10000) + 1000);
        return arr_1000;
    }

    public static void showArr(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count++;
            System.out.printf("%d\t", i);
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }


    public static int[] generate_bit_arr() {
        return arr;
    }
}
