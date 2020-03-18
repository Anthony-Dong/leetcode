package com.qianxin;

import java.util.Scanner;

/**
 * TODO
 *
 * @date:2020/2/28 17:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Main {

    private static final double num_1 = 1;
    private static final double count = 1000;
    private static final double a_count = 10;


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        double rate = a_count / count;
//        double result = rate * num;


//        float rest = C(999, 10) / C(1000, 10);


        System.out.println(C(900,10));

    }

    // c 1 h
    public static float C(int l, int h) {
        float p = p(l);

        float p1 = p(h);

        float p2 = p(l - h);

        return p / (p1 * p2);
    }

    public static long p(int num) {
        long res = 1;
        while (num > 0) {
            res *= num--;
        }
        return res;
    }
}
