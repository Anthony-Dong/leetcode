package com.num41;

import java.util.Scanner;

/**
 * TODO
 *
 * @date:2020/3/12 20:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String next = scanner.next();
//        String[] arr = next.split(" ");
//        if (arr.length != 4) return;
//
//        int n = Integer.parseInt(arr[0]);
//        int k = Integer.parseInt(arr[1]);
//        int L = Integer.parseInt(arr[2]);
//        int R = Integer.parseInt(arr[3]);
//
//        // 排列组合
//        // A（L-R）(L-R)
//        // k-n

        dfs(0, 0, 0);

        System.out.println(count);
    }

    static int count = 0;

    public static void dfs(int num, int sum, int level) {
        if (level == 9) {
            if (sum % 1 == 0) {
                count++;
            }
            return;
        }
        dfs(1, sum + 1, level + 1);
        dfs(2, sum + 2, level + 1);
        dfs(3, sum + 3, level + 1);
    }
}
