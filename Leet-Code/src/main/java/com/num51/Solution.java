package com.num51;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @date:2020/3/5 21:51
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 下标代表行，值代表列。如result[0] = 3 表示第1行的Q在第3列
        int[] result = new int[n];
        List<List<String>> resultList = new LinkedList<>();
        dfs(resultList, result, 0, n);
        return resultList;
    }

    void dfs(List<List<String>> resultList, int[] result, int row, int n) {
        // 递归终止条件
        if (row == n) {
            List<String> list = new LinkedList<>();
            for (int x = 0; x < n; ++x) {
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; ++y)
                    sb.append(result[x] == y ? "Q" : ".");
                list.add(sb.toString());
            }
            resultList.add(list);
            return;
        }
        for (int column = 0; column < n; ++column) {
            boolean isValid = true;
            result[row] = column;
            /*
             * 逐行往下考察每一行。同列，result[i] == column
             * 同对角线，row - i == Math.abs(result[i] - column)
             */
            for (int i = row - 1; i >= 0; --i) {
                if (result[i] == column || row - i == Math.abs(result[i] - column)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) dfs(resultList, result, row + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        lists.forEach(list -> {
            System.out.println(list);

            System.out.println("=================");
        });
    }

}
