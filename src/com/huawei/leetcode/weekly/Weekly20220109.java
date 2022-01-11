package com.huawei.leetcode.weekly;

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: offer双周赛
 * @author: zhuhe
 * @create: 2022-01-08 22:26
 **/
public class Weekly20220109 {
    public static void main(String[] args) {
    }

    public boolean checkValid(int[][] matrix) {
        int length = matrix.length;
        HashSet<Integer> hashSet = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            hashSet.clear();
            int[] ints = matrix[i];
            for (int j = 0; j < length; j++) {
                hashSet.add(ints[j]);
            }
            if (hashSet.size() != length) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            hashSet.clear();
            int[] ints = matrix[i];
            for (int j = 0; j < length; j++) {
                hashSet.add(matrix[j][i]);
            }
            if (hashSet.size() != length) {
                return false;
            }
        }

        return true;
    }

}