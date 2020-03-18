package com.num120;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @date:2020/3/5 20:49
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {

    private int min = Integer.MIN_VALUE;

    private int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        for (int high = triangle.size() - 2; high >= 0; high--) {
            for (int index = triangle.get(high).size() - 1; index >= 0; index--) {
                int min = Math.min(triangle.get(high + 1).get(index), triangle.get(high + 1).get(index + 1));
                triangle.get(high).set(index, triangle.get(high).get(index) + min);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        _dfs(triangle, 0, 0, 0);
        return min;
    }


    private int dfs(List<List<Integer>> triangle, int heep, int index, String path, int sum) {
        // terminator
        if (heep == triangle.size() - 1) {
            sum += triangle.get(heep).get(index);
            if (sum < min || min == 0) {
                min = sum;
            }
            path += triangle.get(heep).get(index) + " #sum: " + sum;
            System.out.println(path);
            return triangle.get(heep).get(index);
        }
        path += triangle.get(heep).get(index) + "->";
        sum += triangle.get(heep).get(index);
        // process
        dfs(triangle, heep + 1, index, path, sum);
        dfs(triangle, heep + 1, index + 1, path, sum);
        // state
        return 0;
    }

    private int _dfs(List<List<Integer>> triangle, int heep, int index, int sum) {
        // terminator
        if (heep == triangle.size() - 1) {
            sum += triangle.get(heep).get(index);
            if (sum < min) {
                min = sum;
            }
            return triangle.get(heep).get(index);
        }
        sum += triangle.get(heep).get(index);
        // process
        _dfs(triangle, heep + 1, index, sum);
        _dfs(triangle, heep + 1, index + 1, sum);
        // state
        return 0;
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        Solution solution = new Solution();
        int i = solution.minimumTotal(lists);
        System.out.println(i);
    }


}
