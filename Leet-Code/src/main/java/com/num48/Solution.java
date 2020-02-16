package com.num48;

/**
 * <a href="https://leetcode-cn.com/problems/rotate-image/">48. 旋转图像<a/>
 * <p>
 * 方法一 : 是先转置矩阵(行列位置互换)，然后翻转每一行。题目给定的是n*n不需要我们扩容数组.
 * ======原矩阵======
 * 1	2	3
 * 4	5	6
 * 7	8	9
 * ======转置矩阵======
 * 1	4	7
 * 2	5	8
 * 3	6	9
 * ======顺时针翻转90度======
 * 7	4	1
 * 8	5	2
 * 9	6	3
 * 方法二 :
 * 就是直接转, 很简单 ,各种变幻
 */
class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j);
            }
        }
        printArr(matrix);

        System.out.println("======顺时针翻转90度======");
        // reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }

        printArr(matrix);
    }

    /**
     * 交换
     */
    public static void swap(int[][] matrix, int x, int y) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = tmp;
    }

    /**
     * 翻转每一行
     */
    public static void reverseRow(int[] arr) {
        int len = arr.length;
        int middle = len / 2;
        for (int i = 0; i < middle; i++) {
            int tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }


    private static void printArr(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}