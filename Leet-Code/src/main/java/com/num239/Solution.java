package com.num239;

import java.util.*;

/**
 * TODO
 *
 * @date:2020/2/28 22:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {

    private static final int[] NULL = new int[0];

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return NULL;
        if (nums.length == 1) return nums;
        int length = nums.length;
        int[] result = new int[length + 1 - k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        int first = nums[0];
        for (int i = 0; i < k - 1; i++) {
            queue.add(nums[i]);
        }


        int count = 0;
        for (int i = k - 1; i < nums.length; i++) {
            // add
            queue.add(nums[i]);
            //
            result[count++] = queue.peek();
            // 移除前一个
            queue.remove(first);
            if (count < nums.length) {
                first = nums[count];
            }
        }
        return result;
    }


    private static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return NULL;

        Deque<Integer> deque = new ArrayDeque<>();



//        ArrayList<Integer> result = new ArrayList<>(nums.length - k + 1);

        int[] res = new int[nums.length + 1 - k];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // 当前节点
            int cur = nums[i];

            // 大于第一个节点.就是不断循环, 移除.
            try {
                while (cur > nums[deque.getFirst()]) {
                    deque.pollFirst();
                }
            } catch (Exception e) {
                //
            }

            // 将当前节点位置添加进去
            deque.addLast(i);

            if (i >= k - 1) {
                res[count] = nums[deque.getFirst()];
                count++;
//                result.add(nums[deque.getFirst()]);
            }
            if (deque.getFirst() == i - k + 1) {
                deque.removeFirst();
                try {
                    while (cur > nums[deque.getFirst()]) {
                        deque.pollFirst();
                    }
                } catch (Exception e) {
                    //
                }
            }
        }

//        System.out.println(result);

        return res;
    }


    public static void main(String[] args) {

        // [1,3,1,2,0,5]
        int[] ints = maxSlidingWindow2(new int[]{1,3,1,2,0,5}, 3);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


}
