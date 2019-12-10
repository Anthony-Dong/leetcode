package com.num19;

/**
 * 19. 删除链表的倒数第N个节点
 *
 *  利用快慢指针 一次遍历删除
 *
 *   你能尝试使用一趟扫描实现吗？ 这个题,卧槽, 我也是一次遍历, 可是时间花费了才超越了57%基本都是1ms 实现
 *
 *   <a>https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/</a>
 *
 * @date:2019/12/10 18:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 特殊情况
        if (n == 0) return head;
        // 特殊
        if (head == null) return null;
        // 绝对此时 n=1
        if (head.next == null) return null;

        // 开始
        int count = 0;
        ListNode node = head;
        ListNode node2 = null;

        while (node != null) {
            node = node.next;
            count++;
            // 初始化指针
            if (count > n) {
                node2 = (node2 == null) ? head : node2.next;
            }

            if (node == null) {
                // 比如移除第一个节点, 此时count才到n,也就是总长,还没有初始化第二个指针, 需要直接返回
                if (node2 == null) return head.next;

                // 当年node指针和 node2 指针差距 = n+1 其实 ,因为我们node迭代了一次,实际上可以看做是n
                node2.next = node2.next.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));


        ListNode node2 = new ListNode(1);

        ListNode node3 = new ListNode(1, new ListNode(2));
        ListNode node4 = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode node1 = removeNthFromEnd(node4, 2);

        System.out.println(node1);

    }


}
