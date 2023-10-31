package com.num1;

import java.util.HashMap;

/**
 * 两数字之和
 *
 * @date:2019/12/9 19:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        int n1 = 0;
        int n2 = 0;

        // 这个属于保留字 , goto
        flag:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    n1 = i;
                    n2 = j;
                    break flag;
                }
            }
        }
        int[] ints = new int[2];
        ints[0] = n1;
        ints[1] = n2;
        return ints;
    }


    public static int[] twoSum2(int[] nums, int target) {
        // 利用hash map , 只遍历一次
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //  2  = 9-7 ,需要 2 配偶
            int need = target - nums[i];
            //  2 = 看看里面有没有2
            if (map.containsKey(nums[i])) {
                // 有就拿出来
                int n1 = map.get(nums[i]);
                // 返回
                return new int[]{n1, i};
            }
            map.put(need, i);
        }
        return null;
    }



    public static void main(String[] args) {
        int[] ints = twoSum2(new int[]{3, 2, 11, 15}, 5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
