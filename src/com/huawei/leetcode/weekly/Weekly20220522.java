package com.huawei.leetcode.weekly;

import com.huawei.leetcode.editor.cn.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2022-05-22 10:36
 **/
public class Weekly20220522 {

    public static void main(String[] args) {
        Weekly20220522 weekly20220522 = new Weekly20220522();
        System.out.println(weekly20220522.minimumLines(ListNode.getIntArrays("[[1,7],[2,7],[3,7],[4,7],[5,7],[6,7],[7,7],[8,7]]")));
    }

    public int percentageLetter(String s, char letter) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter == s.charAt(i)) {
                sum++;
            }
        }
        return sum * 100 / s.length();
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] res = new int[capacity.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(res);
        int result = 0;
        for (int i = 0; i < res.length; i++) {
            int current = res[i];
            if (current == 0) {
                result++;
                continue;
            }
            if (current <= additionalRocks) {
                result++;
            }
            additionalRocks -= current;
            if (additionalRocks <= 0) {
                break;
            }
        }
        return result;
    }

    public int minimumLines(int[][] stockPrices) {
        ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(stockPrices));
        arrayList.sort(Comparator.comparingInt(ints -> ints[0]));
        if (stockPrices.length == 1 || stockPrices.length == 2) {
            return stockPrices.length - 1;
        }
        int count = 1;
        int[] current = arrayList.get(0);
        int[] next = arrayList.get(1);
        long[] diff = new long[2];
        diff[0] = next[0] - current[0];
        diff[1] = next[1] - current[1];
        for (int i = 1; i < arrayList.size() - 1; i++) {
            next = arrayList.get(i + 1);
            current = arrayList.get(i);
            long[] temp = new long[2];
            temp[0] = next[0] - current[0];
            temp[1] = next[1] - current[1];
            if (diff[0] * temp[1] != diff[1] * temp[0]) {
                count++;
                diff = temp;
            }
        }
        return count;
    }

}