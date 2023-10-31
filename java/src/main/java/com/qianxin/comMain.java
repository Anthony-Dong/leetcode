package com.qianxin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @date:2020/2/28 18:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class comMain {

    static int x = 10;

    private static class Rabbit {
        int month;

        public Rabbit(int month) {
            this.month = month;
        }
    }

    public static void main(String[] args) {

        comMain comMain = new comMain();
        comMain.x = 11;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Rabbit init = new Rabbit(0);
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(init);
        for (int x = 1; x <= n; x++) {
            List<Rabbit> list = new ArrayList<>();
            rabbits.forEach(e -> {
                e.month++;
                if (e.month >= 5) {
                    Rabbit rabbit = new Rabbit(1);
                    list.add(rabbit);
                }
            });
            rabbits.addAll(list);
        }
        System.out.println(rabbits.size());
    }

}
