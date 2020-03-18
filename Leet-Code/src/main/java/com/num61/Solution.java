package com.num61;

/**
 * 旋转链表
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 暴力破解
     */
    private ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;
        ListNode node = helper(head);
        return rotateRight(node, --k);
    }

    private ListNode helper(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur.next != null) {
            ListNode tmp = cur.next;
            pre = cur;
            cur = tmp;
        }
        cur.next = head;
        pre.next = null;
        return cur;
    }


    /**
     * 通过找规律实现 , k%len 进行控制
     */
    private ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        // 长度
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }

        // count-k%count表示移动多少次
        int cur_index = count - k % count;

        if (cur_index == count) return first;
        //环
        head.next = first;
        ListNode pre = first;
        while (cur_index != 0) {
            cur_index--;
            pre = first;
            first = first.next;
        }
        pre.next = null;
        return first;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = solution.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3))), 2);
        System.out.println(node);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}