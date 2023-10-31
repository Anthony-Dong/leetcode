package com.num46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 回溯法
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int sum = 1;
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            sum *= i;
        }
        ArrayList<List<Integer>> res = new ArrayList<>(sum);
        if (len == 1) return res;

        helper(res, new ArrayList<>(), nums, new boolean[len]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            helper(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }




    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        HashSet<Character[]> set = new HashSet<>();
        char[] array = str.toCharArray();
        Character[] chars = new Character[2];
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 1; i1 < array.length; i1++) {
                chars[0] = array[i];
                chars[1] = array[i1];
                set.add(chars);
            }
        }
        System.out.println(set.size());

    }
}