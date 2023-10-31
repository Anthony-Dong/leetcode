package com.num98;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO
 *
 * @date:2020/3/3 19:32
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i : arr) {
            if (queue.size() < k) {
                queue.add(i);
                continue;
            }
            Integer peek = queue.peek();
            if (i > peek) {
                queue.poll();
                queue.add(i);
            }
        }
        System.out.println(queue.peek());
    }
}
