package com.num20;

import java.util.*;

/**
 * TODO
 *
 * @date:2020/2/27 21:14
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Solution {

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }


    private static boolean isLegal(String str) {
        LinkedList<Character> stack = new LinkedList<>();

        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            Character peek = stack.peek();
            if (peek == null) {
                stack.push(aChar);
                continue;
            }

            if (peek == aChar) {
                stack.push(aChar);
                continue;
            }

            Character pair = map.get(aChar);

            if (pair == null) {
                stack.push(aChar);
                continue;
            }

            if (pair == peek) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }


    private static boolean isLegal2(String str) {
        LinkedList<Character> stack = new LinkedList<>();

        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            Character pair = map.get(aChar);
            if (pair == null) {
                stack.push(aChar);
                continue;
            }

            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (peek == pair) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        boolean legal = isLegal("({[]})");
        System.out.println(legal);
    }

}
