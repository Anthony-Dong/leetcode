package com.num232_255;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @date:2020/2/27 22:37
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution_Q_S<E> {

    private Queue<E> q1 = new LinkedList<>();

    private Queue<E> q2 = new LinkedList<>();


    private void push(E e) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(e);
        }

        if (!q1.isEmpty()) {
            q1.offer(e);
            return;
        }

        if (!q2.isEmpty()) {
            q2.offer(e);
        }
    }


    private E peek() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        if (!q1.isEmpty()) {
            while (true) {
                E poll = q1.poll();
                q2.offer(poll);
                if (q1.isEmpty()) {
                    return poll;
                }
            }
        }

        while (true) {
            E poll = q2.poll();
            q1.offer(poll);
            if (q2.isEmpty()) {
                return poll;
            }
        }
    }


    private E pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        if (!q1.isEmpty()) {
            while (true) {
                E poll = q1.poll();
                if (q1.isEmpty()) {
                    return poll;
                }
                q2.offer(poll);
            }
        }

        while (true) {
            E poll = q2.poll();
            if (q2.isEmpty()) {
                return poll;
            }
            q1.offer(poll);
        }
    }

    public static void main(String[] args) {
        Solution_Q_S<Object> stack = new Solution_Q_S<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
