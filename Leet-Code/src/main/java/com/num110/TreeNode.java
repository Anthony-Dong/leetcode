package com.num110;

/**
 * TODO
 *
 * @date:2020/1/5 17:04
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean isBalanced(TreeNode root) {
        int recursion = recursion(root);
        return recursion > 0 && recursion == Integer.MAX_VALUE;
    }

    private int recursion(TreeNode root) {
        if (null == root) return 0;

        int left = recursion(root.left);

        int right = recursion(root.right);

        int x = left - right;

        if ((x > 0 ? x : -x) > 1) {
            return Integer.MAX_VALUE;
        }

        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        TreeNode treeNode = new TreeNode(1, new TreeNode(1, new TreeNode(1), null), null);

        node.left = treeNode;

        TreeNode treeNode1 = new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1)));

        node.right = treeNode1;


        boolean balanced = node.isBalanced(node);
        System.out.println(balanced);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MAX_VALUE+2);
    }
}
