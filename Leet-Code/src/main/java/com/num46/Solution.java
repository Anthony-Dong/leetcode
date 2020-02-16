package com.num46;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int sum = 1;
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            sum *= i;
        }
        ArrayList<List<Integer>> res = new ArrayList<>(sum);
        if (len == 1) return res;

        helper(res, new ArrayList<>(), nums, new boolean[len]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            helper(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});

        System.out.println(permute);
    }
}