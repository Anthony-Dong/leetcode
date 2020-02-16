package com.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @date:2020/2/9 16:13
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class YangHuiSanJiao {

    public static void main(String[] args) {
        YangHuiSanJiao sanJiao = new YangHuiSanJiao();
        List<List<Integer>> generate = sanJiao.generate(2);

        System.out.println(generate);

    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        generate(lists, numRows, 1);
        return lists;
    }

    /**
     * size 从1开始,代表第几层 , 从1开始
     */
    public void generate(List<List<Integer>> list, int max, int size) {
        if (size == max + 1) return;
        int index = size - 1;
        ArrayList<Integer> cur = new ArrayList<>();
        list.add(index, cur);
        List<Integer> up;
        try {
            up = list.get(index - 1);
        } catch (Exception e1) {
            up = null;
        }
        merger(up, cur, size);
        size++;
        generate(list, max, size);
    }

    /**
     * 合并很简单  up是上一层, cur是当前层 , size=当前第几层(从1开始)
     * cur[1]=up[0]+up[1]
     */
    public void merger(List<Integer> up, List<Integer> cur, int size) {
        if (up == null) {
            cur.add(1);
            return;
        }
        for (int i = 0; i < size; i++) {
            int pre = 0;
            int next = 0;
            try {
                pre = up.get(i - 1);
            } catch (Exception e) {
            }
            try {
                next = up.get(i);
            } catch (Exception e) {
            }
            cur.add(pre + next);
        }
    }
}
