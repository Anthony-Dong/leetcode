package com.queue;

import java.util.LinkedList;

/**
 * TODO
 *
 * @date:2020/1/13 13:48
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class ListQueue<E> {

    private Node<E> head;
    private Node<E> tail;


    public void offer(E value) {
        if (null == head || null == tail) {
            tail = new Node<>(value);
            head = tail;
            return;
        }
        Node<E> node = new Node<>(value);
        tail.next = node;
        tail = node;
    }


    public E peek(E value) {
        if (null == head || null == tail) {
            return null;
        }
        return head.value;
    }

    public E pull() {
        if (null == head || null == tail) {
            return null;
        }
        Node<E> h = head;
        head = head.next;
        if (head == null) {
            tail = null;
            return h.value;
        }
        h.next = null;
        return h.value;
    }


    public static void main(String[] args) {

    }


    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }
}
