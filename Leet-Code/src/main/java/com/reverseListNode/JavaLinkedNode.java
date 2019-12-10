package com.reverseListNode;

/**
 * @date:2019/11/12 12:24
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class JavaLinkedNode {
    private int value;

    public JavaLinkedNode next;

    public JavaLinkedNode(int value, JavaLinkedNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "JavaLinkedNode{" +
                "value='" + value + '\'' +
                '}';
    }

    /**
     * 1 -> 2 -> 3 -> null
     * <p>
     * null 1 -> 2 - > 3 -null
     * <p>
     * null <- 1  2 -> 3 -> null
     *
     * @param head
     * @return
     */
    public static JavaLinkedNode reserve(JavaLinkedNode head) {
        JavaLinkedNode prev = null;
        JavaLinkedNode cur = head;
        while (cur != null) {

            JavaLinkedNode temp = cur.next;

            cur.next = prev;

            prev = cur;

            cur = temp;
        }
        return prev;
    }


    public static JavaLinkedNode reserve2(JavaLinkedNode head) {
        if (head == null || head.next == null) {
            System.out.println("===========");
            return head;
        }
        JavaLinkedNode next = head.next;
        JavaLinkedNode newHead = reserve2(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        JavaLinkedNode head = new JavaLinkedNode(1, new JavaLinkedNode(2, new JavaLinkedNode(3, new JavaLinkedNode(4, null))));

        JavaLinkedNode javaLinkedNode = reserve(head);

        System.out.println(javaLinkedNode);
        System.out.println(javaLinkedNode.next);
        System.out.println(javaLinkedNode.next.next);

    }
}
