package com.huawei.leetcode.daily;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-11-07 21:47
 **/
public class Problem598 {
    public static void main(String[] args) {

    }

    public int maxCount(int m, int n, int[][] ops) {
        int max_x = m;
        int max_y = n;
        for (int[] op : ops) {
            max_x = Math.min(max_x, op[0]);
            max_y = Math.min(max_y, op[1]);
        }
        return max_x * max_y;
    }
}