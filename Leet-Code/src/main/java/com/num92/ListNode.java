package com.num92;

/**
 * 链表翻转 :
 * <a>https://leetcode-cn.com/problems/reverse-linked-list-ii/</a>
 * 其实链表翻转核心思想就是 pre cur temp 三个指针的玩法, 找到pre , 然后cur ,开始玩了 temp=cur.next ,cur.next=pre , pre=cur , cur=temp
 * <p>
 * 当我们翻转指定链表时(start,end) : pre=(start-1)处节点 , cur=(start)处节点 ,
 * 开始遍历 , temp=cur.next , cur.next=temp.next , temp.next=pre.next , pre.next=temp  ;
 * 比如  : 1->2->3->4->5->null
 * 条件 : (2,4)
 * 1 -> 3 ->2 -> 4 ->5  然后 1->4->3->2->5
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

    /**
     * 别人的
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        // 初始化一个空的
        ListNode dummy = new ListNode(0);

        // 下一个节点为头节点
        dummy.next = head;

        //
        ListNode pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        head = pre.next;

        for (int i = m; i < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }


    /**
     * 自己实现的
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode pre = null;
        ListNode cur = null;

        // 一是比较特殊的情况,此时我们无法实例化pre ,下面会出现异常, 所以我们这里取巧
        if (m == 1) {
            pre = new ListNode(0);
            pre.next = head;
            cur = head;
        } else {
            // 如果不是1 一般都是下面这种写法
            for (int x = 1; x < m; x++) {
                cur = cur == null ? head : cur.next;
            }
            // 第N个前一个节点 ,
            pre = cur;
            // 这是当前开始要改变的节点,
            cur = cur.next;
        }

        for (int x = m; x < n; x++) {
            // 这里几乎是固定写法
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        if (m == 1) return pre.next;
        return head;
    }


    public static ListNode reserve(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = reverseBetween2(node1, 2, 4);
        System.out.println(node);
        System.out.println(node1);
    }
}