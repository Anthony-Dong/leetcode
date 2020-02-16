package com.num98;

public class Solution {

    int min = 0;
    int max = 0;

    public boolean isValidBST(TreeNode root) {


        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

//        if (! helper(node.right, val, upper)) return false;
//        if (! helper(node.left, lower, val)) return false;
        return isValidBST(node.right, val, upper) && isValidBST(node.left, lower, val);
    }


    Integer low;

    public boolean isValidBST2(TreeNode node) {
        if (node == null) return true;
        boolean left = isValidBST2(node.left);
        if (low == null) {
            low = node.val;
        } else {
            if (node.val <= low) return false;
            low = node.val;
        }
        boolean right = isValidBST2(node.right);
        return left && right;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
//        TreeNode left = new TreeNode(5);
//
//        TreeNode right = new TreeNode(15);
//        right.left = new TreeNode(6);
//        right.right = new TreeNode(20);
//        root.left = left;
//        root.right = right;


//        solution.low = root.val;
        boolean validBST = solution.isValidBST2(root);

        System.out.println(validBST);


    }
}