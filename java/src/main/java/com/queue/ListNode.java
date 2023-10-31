package com.queue;

/**
 * TODO
 *
 * @date:2020/1/13 14:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public static ListNode reserve(ListNode head) {
        ListNode p = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = p;
            p = head;
            head = temp;
        }

        return p;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public static void change(ListNode head) {
        head = null;
    }

    static class User {
        String name;

        public User(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        User user = new User("a");
        change(user);
        System.out.println(user.name);
    }

    static void change(User u) {
        u = new User("b");
    }
}


