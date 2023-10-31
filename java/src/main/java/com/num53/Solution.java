package com.num53;

/**
 * 53. 最大子序和
 * <a>https://leetcode-cn.com/problems/maximum-subarray</a>
 *
 * @date:2019/12/24 12:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Solution {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Args are not null !");
        int len = nums.length;
        int max = nums[0];
        int res = max;
        for (int x = 1; x < len; x++) {
            int cur = nums[x];
            max = (max + cur) > cur ? (max + cur) : cur;
            if (max > res) res = max;
        }
        return res;
    }


    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
