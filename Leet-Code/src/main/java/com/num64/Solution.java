package com.num64;

import java.util.concurrent.locks.ReentrantLock;

class Solution {

    private int min = Integer.MAX_VALUE;

    public int minPathSum1(int[][] grid) {
        if (grid.length == 0) return 0;
        helper1(grid, 0, 0, 0);
        return min;
    }

    private void helper1(int[][] grid, int x, int y, int sum) {
        // 尾部返回0
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[x].length) return;
        sum += grid[x][y];
        if (x == grid.length - 1 && y == grid[grid.length - 1].length - 1) {
            if (min > sum) min = sum;
        }
        helper1(grid, x + 1, y, sum);
        helper1(grid, x, y + 1, sum);
    }


    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (i==grid.length-1&&j==grid[i].length - 1){
                    continue;
                }
                if (i == grid.length - 1 ) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                    continue;
                }
                if (j == grid[i].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                    continue;
                }
                grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }

    private void helper(int[][] grid, int x, int y, int sum) {
        // 尾部返回0
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[x].length) return;
        sum += grid[x][y];
        if (x == grid.length - 1 && y == grid[grid.length - 1].length - 1) {
            if (min > sum) min = sum;
        }
        helper(grid, x + 1, y, sum);
        helper(grid, x, y + 1, sum);
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 2}, {1, 1}}));
    }
}