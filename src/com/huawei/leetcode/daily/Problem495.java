package com.huawei.leetcode.daily;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-11-06 22:31
 **/
public class Problem495 {
    public static void main(String[] args) {
        Problem495 problem = new Problem495();
        System.out.println(problem.findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println(problem.findPoisonedDuration(new int[]{1,2}, 2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            sum += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return sum + duration;
    }
}