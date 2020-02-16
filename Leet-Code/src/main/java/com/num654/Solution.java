package com.num654;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0) return null;
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }

        if (low == high) {
            return new TreeNode(arr[low]);
        }

        int max = dep(arr, low, high);
        TreeNode root = new TreeNode(arr[max]);
        root.left = construct(arr, low, max - 1);
        root.right = construct(arr, max + 1, high);
        return root;
    }


    public int dep(int[] arr, int low, int high) {
        int max = low;
        for (int x = low; x <= high; ++x) {
            if (arr[x] > arr[max]) {
                max = x;
            }
        }
        System.out.println(max+","+low+","+high);
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();


        TreeNode node = solution.constructMaximumBinaryTree(new int[]{4, 1, 3, 5});

        System.out.println(node);
    }
}