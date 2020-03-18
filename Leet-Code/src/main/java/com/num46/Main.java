package com.num46;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @date:2020/3/3 19:44
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Main {


    private static List<List<Character>> permute(char[] nums) {
        int sum = 1;
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            sum *= i;
        }
        ArrayList<List<Character>> res = new ArrayList<>(sum);
        if (len == 1) return res;

        helper(res, new ArrayList<>(), nums, new boolean[len]);
        return res;
    }

    private static void helper(List<List<Character>> res, List<Character> cur, char[] nums, boolean[] visited) {
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
        char[] array = str.toCharArray();
        int out = array.length - 1;
        List<List<Character>> permute = permute(array);
        permute.forEach(e -> {
            for (int i = 0; i < out-1; i++) {
                System.out.printf("%s,",e.get(i));
            }
            System.out.printf("%s\n", e.get(out - 1));
        });
    }
}
