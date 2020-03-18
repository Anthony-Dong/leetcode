package com.feibonaci;

/**
 * 斐波那契数列
 *
 * @date:2020/3/5 16:20
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Demo {


    private static int helper(int index, int[] arr) {
        if (index < 2) return 1;
        if (arr[index] == 0) {
            arr[index] = helper(index - 1, arr) + helper(index - 2, arr);
        }
        return arr[index];
    }

    public static void main(String[] args) {
//        int helper = helper(4, new int[5]);
//        System.out.println(helper);


        System.out.println(8&1);
    }


}
