package com.num19;

public class Solution {
    public static ListNode swapPairs(ListNode head) {
        if (head ==null)return null;
        swapPairs(head, 0);
        return head;
    }

    public static void swapPairs(ListNode head, int x) {
        if (head.next == null) return;
        if (x % 2 == 0) {
            int tmp = head.next.val;
            head.next.val = head.val;
            head.val = tmp;
        }
        x++;
        swapPairs(head.next, x);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node1 = swapPairs(node);
        System.out.println(node1);
    }
}