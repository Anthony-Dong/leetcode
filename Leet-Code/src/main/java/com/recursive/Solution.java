package com.recursive;

/**
 * 递归翻转链表 , 这里要求递归
 */
public class Solution {


    private ListNode res = new ListNode(1);
    private ListNode result = res;


    /**
     * 方法一
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        handler(head);
        return res;
    }

    public ListNode handler(ListNode head) {
        if (head == null) return null;
        ListNode node = handler(head.next);
        ListNode cur = new ListNode(head.val);
        // 最后一个
        if (node == null) {
            // 最后一个 5
            result = cur;
            res = result;
        } else {
            result.next = cur;
            result = result.next;
        }
        return result;
    }

    /**
     * 方法二 : 复杂度高
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = reverseList(head.next);
        ListNode cur = new ListNode(head.val);
        if (node == null) {
            // 最后一个 5
            node = cur;
        } else {
            ListNode tmp = node;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = cur;
        }
        return node;
    }

}