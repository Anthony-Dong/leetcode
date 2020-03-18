package com.num41;


import java.util.Scanner;

/**
 * TODO
 *
 * @date:2020/3/12 20:40
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String line1 = scanner.next();
        String[] arr1 = line1.split("");
        String line2 = scanner.next();
        String[] arr2 = line2.split("");
        String[][] arr = new String[][]{arr1, arr2};

        hand(arr, 0, 0);

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
        }
    }

    private static int sum = 0;

    public static void hand(String[][] arr, int x, int y) {
        if (x < 0 || x > arr.length - 1) return;
        if (y < 0 || y > arr[x].length - 1) return;
        if (arr[x][y].equals("X")) {
            return;
        }
        if (x == arr.length - 1 && y == arr[1].length - 1) {
            sum++;
            return;
        }
        hand(arr, x, y + 1);
        hand(arr, x - 1, y + 1);
        hand(arr, x + 1, y + 1);
    }
}
