package com.timsort;

import java.util.Arrays;

/**
 * TODO
 *
 * @date:2019/12/14 17:23
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestTimSort {


    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 3, 21, 1, 3, 4, 5};

        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
