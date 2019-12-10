package com.num4;

/**
 * <a>https://leetcode-cn.com/problems/median-of-two-sorted-arrays/</a>
 *
 * 寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 *
 *
 * 太难了 我决定先归并排序 , 复杂度 O(m+n) , 达不到要求, 我真垃圾 , 太难了 O(log(m + n))。
 */
public class Solution {


    public static int[] mergingDoubleArrs(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] merge = new int[len];

        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < len; i++) {
            int min = 0;
            if (c1 < len1 && c2 < len2) {
                if (nums1[c1] < nums2[c2]) {
                    min = nums1[c1];
                    c1++;
                } else {
                    min = nums2[c2];
                    c2++;
                }
            } else {
                if (c1 < len1) {
                    min = nums1[c1];
                    c1++;
                }
                if (c2 < len2) {
                    min = nums2[c2];
                    c2++;
                }
            }
            merge[i] = min;
        }

        return merge;
    }


    /**
     * 三元运算符, 我只能说 ,别多用, 可读性差
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = mergingDoubleArrs(nums1, nums2);
        return ints.length % 2 == 0
                ? ((double) ints[ints.length / 2 - 1] + (double) ints[ints.length / 2]) / 2
                : (double) ints[ints.length / 2];
    }


    public static void main(String[] args) {
        double c = findMedianSortedArrays(new int[]{0, 0}, new int[]{0,0});
        System.out.println(c);
    }


}