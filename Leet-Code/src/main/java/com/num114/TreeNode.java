package com.num114;

import com.num19.ListNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 二叉树的中序遍历
 * <a>https://leetcode-cn.com/problems/binary-tree-inorder-traversal/</a>
 * <p>
 * <p>
 * 递归遍历so easy
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 递归遍历发
     *
     * @param root
     * @return
     */
    public static void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;
    }


    public static void recursionPreOrderTraversal(TreeNode root, TreeNode treeNode) {
        if (root==null) return;
        if (treeNode == null) {
            treeNode = new TreeNode(root.val);
        } else {
            treeNode.val = root.val;
        }
        recursionPreOrderTraversal(root.left, treeNode.right);
        recursionPreOrderTraversal(root.right, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        node1.left=new TreeNode(3);
        node1.right=new TreeNode(4);
        node2.right=new TreeNode(6);
        node.left=node1;
        node.right=node2;
        flatten(node);
        System.out.println(node);



    }


}
