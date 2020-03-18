package com.num79;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 破解游戏算法
 *
 * @date:2020/3/7 13:20
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class Game {
    /**
     * @param <R> 行
     * @param <C> 列
     */
    static class Pair<R, C> {
        final R row;
        final C col;

        Pair(R row, C col) {
            this.row = row;
            this.col = col;
        }
    }

    private final int[][] sheet;
    private final Map<Integer, List<Integer>> block;
    private final Pair<Integer, Integer> start;
    private final Pair<Integer, Integer> end;
    private final int sum;


    /**
     * @param row   表格行数
     * @param col   表格列数
     * @param block 障碍物位置
     * @param start 开始位置
     * @param end   结束位置
     */
    private Game(int row, int col, Map<Integer, List<Integer>> block, Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        this.sheet = new int[row][col];
        this.block = block;
        this.start = start;
        this.end = end;

        AtomicInteger count = new AtomicInteger(0);
        block.forEach((integer, list) -> list.forEach(integer1 -> {
            count.incrementAndGet();
        }));

        // 由于不算最后终点, 所以减少一步
        this.sum = sheet.length * sheet[0].length - count.get() - 1;
    }


    /**
     * 横竖
     */
    private void test() {
        // 必须走过多少
        helper(start.row, start.col, 0, "start->");
    }

    private void helper(int row, int col, int count, String path) {
        // 越界
        if (row < 0 || row > sheet.length - 1) return;
        if (col < 0 || col > sheet[row].length - 1) return;
        List<Integer> list = block.get(row);
        if (list != null && list.contains(col)) return;
        if (sheet[row][col] == 1) return;
        if (row == end.row && col == end.col) {
            if (count != sum) return;
            System.out.println(String.format("%s(%d,%d)->end", path, end.row, end.col));
            return;
        }
        count++;
        path += String.format("(%d,%d)->", row, col);
        sheet[row][col] = 1;
        helper(row, col + 1, count, path);
        helper(row, col - 1, count, path);
        helper(row - 1, col, count, path);
        helper(row + 1, col, count, path);
        // 复位
        sheet[row][col] = 0;
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("=======start======");
        // 用set最好,由于数据量小,list也可以
        final Map<Integer, List<Integer>> block = new HashMap<>();
        // 放入障碍物的坐标.左下角第一个为(0,0)
        block.put(0, Arrays.asList(4));
//        block.put(1, Arrays.asList(2));
        block.put(2, Arrays.asList(5));
        block.put(3, Arrays.asList(0,3));
//        block.put(4, Arrays.asList(4));
//        block.put(5, Arrays.asList(3));
        // 开始位置
        final Pair<Integer, Integer> start = new Pair<>(0, 5);
        // 表的行数
        final int s_row = 6;
        // 表的列数
        final int s_col = 6;
        final long start_time = System.currentTimeMillis();

        // 多线程跑,不怕浪费CPU资源,跑满
        final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        IntStream.range(0, s_row).forEach(row -> IntStream.range(0, s_col).forEach(col -> {
            List<Integer> list = block.get(row);
            if (list != null && !list.contains(col) && row != start.row || col != start.col) {
                pool.execute(() -> {
                    Game game = new Game(s_row, s_col, block, start, new Pair<>(row, col));
                    game.test();
                });
            }
        }));
        pool.shutdown();
        pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
        System.out.println(String.format("=======terminal - spend: %dms.======", System.currentTimeMillis() - start_time));
    }
}
