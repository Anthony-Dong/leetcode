package com.erfen;

import java.util.HashMap;
import java.util.Map;


/**
 * 二分法 的使用.
 *
 * @date:2020/3/18 11:02
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        Map<Integer, Integer> index = solution.findIndex(ints);
        index.forEach((integer, integer2) -> System.out.println(integer + " - " + integer2));
    }

    /**
     * 输入  [1,1,1,2,2,2,3,3,3]  返回 每个重复项第一次出现的位置. 返回 [1:0,2:3,3:6]
     *
     * @param arr [1,1,1,2,2,2,3,3,3]
     * @return [1:0,2:3,3:6]
     */
    public Map<Integer, Integer> findIndex(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        helper(arr, 0, arr.length - 1, map);
        return map;
    }

    public void helper(int[] arr, int start, int end, Map<Integer, Integer> map) {
        if (start == end) return;
        int mid = (start + end) / 2;
        if (arr[mid] != arr[mid + 1]) {
            map.put(arr[mid + 1], mid + 1);
        }
        helper(arr, start, mid, map);
        helper(arr, mid + 1, end, map);
    }


    /**
     * 字符串替换  abc -> b替换成c  -> acc
     *
     * @param str   字符串
     * @param start 开始位置
     * @param end   结束位置
     */
    public void convert(char[] str, int start, int end) {
        if (start == end) {
            if (str[start] == ' ') {
                str[start] = '%';
            }
            return;
        }
        int mid = (start + end) / 2;
        convert(str, start, mid);
        convert(str, mid + 1, end);
    }
}
