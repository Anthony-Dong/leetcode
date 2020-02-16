package com.num102;

import com.sun.istack.internal.NotNull;
import jdk.nashorn.internal.ir.ThrowNode;

import java.util.*;

/**
 * TODO
 *
 * @date:2019/12/31 12:17
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (null == root) return levels;
        recursion(root, levels, 0);
        return levels;
    }


    public static void recursion(TreeNode node, List<List<Integer>> levels, int level) {

        // 空就不走下面
        if (null == node) return;

        // 获取当前level位置的list,获取不到,实例化一个
        try {
            levels.get(level);
        } catch (Exception e) {
            levels.add(level, new ArrayList<>());
        }

        // 直接加进去
        levels.get(level).add(node.val);

        recursion(node.left, levels, level + 1);

        recursion(node.right, levels, level + 1);
    }

    public static void main(String[] args) {

//        Queue<Integer> queue = new LinkedList<>();
//
//
//        queue.offer(1);
//        queue.offer(2);
//
//
//        System.out.println("queue.poll() = " + queue.poll());
//
//        System.out.println("queue.peek() = " + queue.poll());

        TreeNode root = new TreeNode(-10);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
//        TreeNode node = new TreeNode(6);
//        node.right = new TreeNode(7);
//        right.left = node;

        int i = root.maxPathSum(root);
        System.out.println(i);





//        List<List<Integer>> lists = levelOrder(root);
//
//        System.out.println(lists.size());
//
//        lists.forEach(e -> {
//            e.forEach(System.out::println);
//            System.out.println();
//        });
    }


    private List<Integer> aftOrderFirstSearch(TreeNode root) {
        if (null == root) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        recursion(list, root);
        return list;
    }


    private void recursion(List<Integer> list, TreeNode root) {
        if (null == root) return;
        recursion(list, root.left);
        recursion(list, root.right);
        list.add(root.val);
    }

    private List<Integer> depthFirstSearch(TreeNode root) {
        if (null == root) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        // 栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        // 压栈
        stack.push(root);
        while (stack.size() > 0) {

            // 出栈
            TreeNode node = stack.pop();

            TreeNode right = node.right;
            if (null != right) {
                stack.push(right);
            }

            TreeNode left = node.left;
            if (null != left) {
                stack.push(left);
            }

            list.add(node.val);
        }
        return list;
    }

    private List<Integer> midFirstSearchUnRecursion(TreeNode root) {
        if (null == root) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        // 栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        // 压栈
        stack.push(root);

        while (stack.size() > 0) {
            // 出栈
            TreeNode node = stack.pop();

            TreeNode right = node.right;
            TreeNode left = node.left;

            if (null != right || null != left) {
                stack.push(node);
            }

            if (null != right) {
                node.right = null;
                stack.push(right);
            }


            if (null != left) {
                node.left = null;
                stack.push(left);
            }


            if (null == left && null == right) {
                list.add(node.val);
            }
        }
        return list;
    }


    private List<Integer> breadthFirstSearch(TreeNode root) {
        if (null == root) return Collections.emptyList();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (queue.peek() != null) {

            TreeNode poll = queue.poll();

            TreeNode left = poll.left;
            if (null != left) {
                queue.offer(left);
            }

            TreeNode right = poll.right;
            if (null != right) {
                queue.offer(right);
            }

            list.add(poll.val);
        }


        return list;
    }


    /**
     * DFS
     *
     * @return List<Integer>
     */
    public static List<Integer> bfs(TreeNode root) {
        // 用数组的目的, 是为了好添加, 不用每次手动复制
        List<Integer> list = new ArrayList<>();
        if (null == root) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        // 1.添加根节点进去
        queue.offer(root);
        // 3. 如果大于0
        if (queue.size() > 0) {
            // 弹出去
            TreeNode node = queue.poll();

            // 不为空添加进去
            TreeNode left = node.left;
            if (null != left) {
                queue.offer(left);
            }

            // 不为空添加进去
            TreeNode right = node.right;
            if (null != right) {
                queue.offer(right);
            }

            list.add(node.val);
        }
        return list;
    }


    private int countDepth(TreeNode root) {
        if (null == root) return 0;
        int left = countDepth(root.left);
        int right = countDepth(root.right);
        return left >= right ? left + 1 : right + 1;
    }


    private int countNode(TreeNode root) {
        if (null == root) return 0;
        return countNode(root.left) + countNode(root.right)+1;
    }


    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }


}
