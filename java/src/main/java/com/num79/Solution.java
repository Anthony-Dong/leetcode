package com.num79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (board.length * board[0].length < word.length()) return false;
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != array[0]) {
                    continue;
                }
                if (helper(board, i, j, array, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 行 ， 列
    private boolean helper(char[][] board, int i, int j, char[] target, int index) {
        if (index > target.length - 1) return true;
        if (i > board.length - 1 || i < 0) return false;
        if (j > board[i].length - 1 || j < 0) return false;
        if (board[i][j] != target[index]) {
            return false;
        }
        // 修改
        board[i][j] <<= 1;
        index++;
//        boolean left = helper(board, i, j - 1, target, index) ;
//        boolean right = helper(board, i, j + 1, target, index);
//        boolean up = helper(board, i + 1, j, target, index);
//        boolean low = helper(board, i - 1, j, target, index);
        boolean result = helper(board, i, j - 1, target, index) || helper(board, i, j + 1, target, index) || helper(board, i + 1, j, target, index) || helper(board, i - 1, j, target, index);
        // 修改回来
        board[i][j] >>= 1;
        return result;
    }

    public static boolean get() {
        return get1() || get2();
    }

    public static boolean get1() {
        System.out.println("get1");
        return true;
    }

    public static boolean get2() {
        System.out.println("get2");
        return true;
    }

    public static void main(String[] args) {
        get();
    }
}