package com.num226;

/**
 * TODO
 *
 * @date:2020/1/5 17:50
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {


        recursion(root);

        return root;
    }

    private void recursion(TreeNode root) {
        if (null==root) return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        recursion(root.left);
        recursion(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(4);

        TreeNode node2 = new TreeNode(3);

        node.left = node1;
        node.right = node2;

        solution.invertTree(node);

        System.out.println(node);

    }

}
