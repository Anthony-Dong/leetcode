package com.num206;

/**
 * 翻转链表
 *
 * @date:2020/2/27 16:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {


    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }


    /**
     * 全翻转
     *
     * @param head
     * @return
     */
    private static ListNode reserveAllList(ListNode head) {
        // 1->2->3
        // null<-1<-2<-3
        if (head == null) return null;
        ListNode Null = null;
        while (true) {
            ListNode tmp = head.next;
            head.next = Null;
            Null = head;
            if (tmp != null) {
                head = tmp;
            } else {
                break;
            }
        }
        return head;
    }

    /**
     * 全翻转
     *
     * @param head
     * @return
     */
    private static ListNode reserveAllList2(ListNode head) {
        // 1->2->3
        // null<-1<-2<-3
        if (head == null) return null;
        ListNode Null = null;
        while (head.next != null) {
            ListNode tmp = head.next;
            head.next = Null;
            Null = head;
            head = tmp;
        }
        head.next = Null;
        return head;
    }


    /**
     * 局部翻转之 , 两两翻转    1->2->3->4->5->null   ->  2->1->4->3->5->null
     */
    private static ListNode reserveDouble(ListNode head) {
        ListNode save = head.next;
        // 前前节点
        ListNode pp = null;
        // 前节点
        ListNode pre = null;
        int count = 0;

        while (true) {
            // 下一个节点
            ListNode tmp = head.next;
            if (++count % 2 == 0) {
                if (pp != null) {
                    pp.next = head;
                }
                head.next = pre;
                pre.next = tmp;
                pp = pre;
            }
            // 当下一个节点为空直接跳出循环.
            if (tmp == null) {
                break;
            }
            // 前节点=当前节点
            pre = head;
            // 头部节点=下一个节点.
            head = tmp;
        }

        return save;
    }


    /**
     * 判断是否有环. 快慢指针版.  还有一种就是无脑往下走, 还有一种是利用hashset.
     */
    private static boolean haveCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode node2 = new ListNode(8);
        ListNode node = new ListNode(9);
        node1.next = node2;
        node2.next = node;
//        node.next = node1;


//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
//        System.out.println(listNode);
        System.out.println(haveCircle(node1));
    }

}
