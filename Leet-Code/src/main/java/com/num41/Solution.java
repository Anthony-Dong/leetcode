package com.num41;


public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            helper(i, nums);
        }
        int res = 1;
        for (int num : nums) {
            if (num == res) {
                res++;
                continue;
            }
            return res;
        }
        return res;
    }

    // 当前下标值
    private void helper(int i, int[] nums) {
        int cur = nums[i];
        if (cur <= 0 || cur > nums.length) return;
        if (cur == nums[cur - 1]) return;
        swap(nums, i, nums[i] - 1);
        helper(i, nums);
    }

    private void swap(int[] nums, int a1, int a2) {
        int tmp = nums[a1];
        nums[a1] = nums[a2];
        nums[a2] = tmp;
    }

}