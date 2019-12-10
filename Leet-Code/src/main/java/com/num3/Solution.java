package com.num3;

import java.util.LinkedList;

/**
 * 无重复字符的最长子串 ,
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * <a>https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a>
 *
 * @date:2019/12/9 20:26
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        // 前面就不展示了
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        // 此时最大值绝对是1
        int max = 1;
        LinkedList<Character> list = new LinkedList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            final char index = s.charAt(i);
            // 当比如 `pwwwkew` , 此时到了第二个坐标 ,也就是 `pw`下一个w刚进来,此时如果包含`w`,也就是`pw`,我们就将子串移动
            // 循环 , 直到不重复, 也就是此时的 `空` ,然后
            while (list.contains(index)) {
                list.removeFirst();
            }
            //添加进去
            list.addLast(index);

            // 取最大值
            if (max < list.size()) {
                max = list.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int hello = lengthOfLongestSubstring("abcabcccs31231312sdcbb");
        System.out.println(hello);
    }
}
