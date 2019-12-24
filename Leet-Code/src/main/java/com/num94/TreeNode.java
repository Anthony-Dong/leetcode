package com.num94;

import java.util.ArrayList;
import java.util.List;


/**
 * 二叉树的中序遍历
 * <a>https://leetcode-cn.com/problems/binary-tree-inorder-traversal/</a>
 *
 *
 *  递归遍历so easy
 *
 * @date:2019/12/12 17:44
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
     * 递归遍历发
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        inorderTraversal(root, integers);
        return integers;
    }


    public static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (null == root) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        node.right = treeNode;
        treeNode.left = new TreeNode(3);
        List<Integer> integers = inorderTraversal(node);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }


}
