package com.num232_255;

import java.util.LinkedList;

/**
 * 用栈实现 队列.
 *
 * @date:2020/2/27 22:08
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution<E> {

    private LinkedList<E> in = new LinkedList<>();
    private LinkedList<E> out = new LinkedList<>();


    private void push(E e) {
        in.push(e);
    }


    private E peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                E pop = in.pop();
                out.push(pop);
            }
            return out.peek();
        } else {
            return out.peek();
        }
    }

    private E poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                E pop = in.pop();
                out.push(pop);
            }
            if (out.isEmpty()) {
                return null;
            }
            return out.pop();
        } else {
            return out.pop();
        }
    }


    public static void main(String[] args) {

        Solution<Object> solution = new Solution<>();

        solution.push(1);
        solution.push(2);

        System.out.println(solution.poll());

        System.out.println(solution.poll());
        System.out.println(solution.poll());

        System.out.println();
    }


}
