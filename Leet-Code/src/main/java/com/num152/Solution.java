package com.num152;

/**
 * 152. 乘积最大子序列
 * <a>https://leetcode-cn.com/problems/maximum-product-subarray</a>
 */
class Solution {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Args are not null !");
        int len = nums.length;
        // 1. 最大值
        int max = nums[0];
        // 2. 最小值
        int min = nums[0];
        // 3. 当前最大值
        int res = nums[0];
        // 4. 一次遍历
        for (int x = 1; x < len; x++) {
            int cur = nums[x];
            // cur , cur*max , cur*min
            int temp = Math.max(Math.max(cur * max, cur * min), cur);
            min = Math.min(Math.min(cur * max, cur * min), cur);
            max = temp;
            if (res < max) res = max;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-4, -3, -2};
        Runtime.getRuntime().totalMemory();
        int i = maxProduct(arr);
        System.out.println(i);
    }

}