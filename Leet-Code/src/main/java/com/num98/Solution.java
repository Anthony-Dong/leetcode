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


    private TreeNode pre;

    /**
     * 中序遍历
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST3(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return isValidBST3(root.right);
    }


    public boolean isVaildBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        if (max != null && root.val >= max) return false;
        if (min != null && root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }

    /**
     * 查找node
     */
    private static TreeNode findNodeEqualTow(TreeNode root, int p1, int p2) {
        if (root == null) return null;
        if (root.val == p1 || root.val == p2) return root;
        TreeNode left = findNodeEqualTow(root.left, p1, p2);
        TreeNode right = findNodeEqualTow(root.right, p1, p2);
        // 左边找不到, 返回右边(一定在右边)
        // 右边找不到, 返回左边(一定正左边)
        // 左右都找到了, 就返回父节点.
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    private static TreeNode findNodeEqualTowInBTS(TreeNode root, int p1, int p2) {
        if (root == null) return null;
        if (p1 < root.val && p2 < root.val) {
            return findNodeEqualTowInBTS(root.left, p1, p2);
        }
        if (p1 > root.val && p2 > root.val) {
            return findNodeEqualTowInBTS(root.right, p1, p2);
        }
        return root;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(1);

        TreeNode right = new TreeNode(15);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        root.left = left;
        root.right = right;


//        solution.low = root.val;
        TreeNode validBST = findNodeEqualTow(root, 20, 1);

        System.out.println(validBST.val);

    }
}