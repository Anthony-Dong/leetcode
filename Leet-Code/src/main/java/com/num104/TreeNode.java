package com.num104;

import java.util.HashSet;

/**
 * TODO
 *
 * @date:2019/12/17 16:18
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    /**
     * 最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        // 为空直接返回0
        if (root == null) return 0;
        // 递归求法
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 取最大值
        return ((left >= right) ? left : right) + 1;
    }


    /**
     * 最小深度 , 从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) return left + right + 1;

        return ((left <= right) ? left : right) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
//
//        root.left = node9;
//        root.right = node15;
//        node15.left = node20;

        int i = maxDepth(root);

        int c = minDepth(root);



        System.out.println(i);
        System.out.println(c);
    }










}
