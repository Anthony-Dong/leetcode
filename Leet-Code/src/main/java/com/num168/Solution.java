package com.num168;

/**
 * Excel表列名称  其实就是进制转换 26进制的转换(不过是 1-26) 不是(0-25)
 */
class Solution {

    /**
     * 10进制 转换 26进制转换
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        // 输出值
        StringBuilder res = new StringBuilder();

        // 循环
        while (n != 0) {
            // n-- 的目的是因为n是从1开始的 , 当n=26的时候, 26%26=0, 应该是 25%26=25才对
            n = n - 1;

            // 当前值
            int temp = n % 26;

            // 添加到头部
            res.insert(0, (char) (temp + 'A'));

            // 返回
            n = n / 26;
        }
        return res.toString();

    }

    /**
     * 10 进制转换二进制
     * @param x
     * @return
     */
    public static String convertToBinary(int x) {
        StringBuilder res = new StringBuilder();
        while (x != 0) {
            int temp = x % 2;
            //res = temp + res;
            res.insert(0, temp);
            x = x / 2;
        }
        return res.length() == 0 ? "0" : res.toString();
    }


    public static void main(String[] args) {

        String s1 = convertToBinary(0);

        System.out.println(s1);

    }
}