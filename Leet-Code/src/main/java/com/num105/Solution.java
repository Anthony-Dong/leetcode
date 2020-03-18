package com.num105;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        if (index == preorder.length) return null;
        int val = preorder[index];
        TreeNode node = new TreeNode(val);
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                index++;
                node.left = buildTree1(preorder, Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree1(preorder, Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return node;
        // 左右，起始位置。
    }

    private int index = 0;


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        return helper(postorder, inorder, 0, inorder.length - 1);
        // 左右，起始位置。
    }

    private TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        if (index < 0) return null;
        if (end - start < 0) return null;
        int val = postorder[index];
        TreeNode node = new TreeNode(val);
        for (int i = start; i <= end; i++) {
            if (val == inorder[i]) {
                index--;

                System.out.println((i + 1) + " , " + (inorder.length - 1));
                // 2,4
                // 4,4
                node.right = helper(postorder, inorder, i + 1, end);
                node.left = helper(postorder, inorder, start, i - 1);
                break;
            }
        }
        return node;
    }


    private TreeNode helper(int[] preorder, int[] inorder, int mid, TreeNode head) {
        if (mid < 0 || mid > preorder.length) return null;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[mid] == inorder[i]) {
                head = new TreeNode(preorder[mid]);
                head.left = helper(preorder, inorder, i - 1, head);
                head.right = helper(preorder, inorder, i + 1, head);
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node);
    }


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
    }
}