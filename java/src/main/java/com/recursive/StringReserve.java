package com.recursive;

/**
 * 翻转字符串 , 要求递归
 *
 * @date:2020/2/9 16:12
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class StringReserve {

    public static void reverseString(char[] s) {
        reverseString(s, s.length - 1);
    }

    public static void reverseString(char[] str, int index) {
        if (str.length % 2 == 0) {
            if (index == (str.length / 2) - 1) return;
        } else {
            if (index == str.length / 2) return;
        }
        char tmp = str[index];
        str[index] = str[str.length - index - 1];
        str[str.length - index - 1] = tmp;
        reverseString(str, --index);
    }
}
