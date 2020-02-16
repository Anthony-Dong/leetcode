package com.num124;

/**
 * LeetCode   <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">二叉树中的最大路径和<a/>
 * <p>
 * 需要注意的是最大路径是一条路, 没有分叉口
 *
 * @date:2020/1/19 16:49
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {

    private int maxValue = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
        getMax(root);
        return maxValue;
    }

    private int getMax(TreeNode node) {
        if (node == null) return 0;

        int temp;

        // 如果为有一个支路返回值为负数,我们就不计入统计
        temp = getMax(node.left);
        int left = temp > 0 ? temp : 0;
        temp = getMax(node.right);
        int right = temp > 0 ? temp : 0;

        // 取最大值
        temp = left + right + node.val;
        maxValue = maxValue > temp ? maxValue : temp;

        // 左右支路最大值 + 当前节点值 // 因为最大路径是一条道连接起来的,不能有多个支路
        temp = left > right ? left : right;
        return temp + node.val;
    }

    public static void order(TreeNode root) {
        if (root == null) return;
        order(root.left);
        System.out.println(root.val);
        order(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        int i = solution.maxPathSum(root);
        System.out.println(i);

        order(root);
    }
}
