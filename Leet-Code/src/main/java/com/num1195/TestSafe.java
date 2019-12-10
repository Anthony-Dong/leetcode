package com.num1195;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * TODO
 *
 * @date:2019/12/10 13:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestSafe {
    static int x = 1;

    public static void main(String[] args) {

        new Thread(() -> {
            while (x < 10000) {
                System.out.println(x++);
            }
        }).start();
        new Thread(() -> {
            while (x < 10000) {
                System.out.println(x++);
            }
        }).start();
        new Thread(() -> {
            while (x < 10000) {
                System.out.println(x++);
            }
        }).start();
        new Thread(() -> {
            while (x < 10000) {
                System.out.println(x++);
            }
        }).start();
        new Thread(() -> {
            while (x < 10000) {
                System.out.println(x++);
            }
        }).start();
    }
}
