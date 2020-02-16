package com.num5;

import java.util.ArrayList;

/**
 * TODO
 *
 * @date:2020/1/2 19:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {


    public static void main(String[] args) {

        String babad = longestPalindrome("ababc");
        System.out.println(babad);
    }


    private static String longestPalindrome(String s) {
        if (s == null) return null;

        if (s.length() == 0 || s.length() == 1) return s;

        char[] chars = s.toCharArray();

        int length = chars.length;

        int length_1 = length - 1;

        String maxLenStr = "" + chars[0];
        // 开始
        int start = -1;
        while (start < length) {
            start++;
            int len = length - start;

            if (maxLenStr.length() >= len) {
                return maxLenStr;
            }
            ArrayList<Integer> list = null;
            int right = start;
            while (right < length_1) {
                right++;
                if (chars[right] == chars[start]) {
                    if (null == list) {
                        list = new ArrayList<>();
                    }
                    list.add(right);
                }
            }

            if (null == list) {
                continue;
            }

            for (Integer integer : list) {
                right = integer;
                int end = right;
                int left = start;
                boolean flag = true;
                while (left < right) {
                    left++;
                    right--;
                    if (chars[left] != chars[right]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    String substring = s.substring(start, (end + 1));
                    if (substring.length() > maxLenStr.length()) {
                        maxLenStr = substring;
                    }
                }
            }
        }
        return maxLenStr;
    }





    private static boolean isPalindromic2(String subStr) {
        char[] chars = subStr.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    private static boolean isPalindromic1(String subStr) {
        char[] chars = subStr.toCharArray();

        int length = chars.length;

        // 偶数
        boolean flag = length % 2 == 0;
        int mid = length / 2;
        if (flag) {
            int appen = mid - 1;
            while (appen >= 0) {
                if (chars[appen] != mid) {
                    return false;
                }
                mid++;
                appen--;
            }
        } else {
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left--;
                right++;
            }
        }
        return true;
    }
}
