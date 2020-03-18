package com.num79;

/**
 * TODO
 *
 * @date:2020/3/6 11:08
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution2 {

    public boolean exist(char[][] board, String word) {
        boolean result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = dsf(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dsf(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        boolean result;
        board[i][j] <<= 2;
        result = dsf(board, word, i - 1, j, index + 1)
                || dsf(board, word, i + 1, j, index + 1)
                || dsf(board, word, i, j - 1, index + 1)
                || dsf(board, word, i, j + 1, index + 1);
        board[i][j] >>= 2;

        return result;
    }

}
