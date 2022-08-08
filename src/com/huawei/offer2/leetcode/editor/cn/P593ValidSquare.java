package com.huawei.offer2.leetcode.editor.cn;

//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
// 👍 150 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Java：有效的正方形
public class P593ValidSquare {
    public static void main(String[] args) {
        Solution solution = new P593ValidSquare().new Solution();
        solution.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            if (p1[0] == p2[0] && p1[1] == p2[1]) {
                return false;
            }
            ArrayList<int[]> arrayList = new ArrayList<>();
            arrayList.add(p1);
            arrayList.add(p2);
            arrayList.add(p3);
            arrayList.add(p4);
            arrayList.sort((ints, t1) -> {
                if (ints[0] != t1[0]) {
                    return Integer.compare(ints[0], t1[0]);
                }
                return Integer.compare(ints[1], t1[1]);
            });

            int l1 = compute(arrayList.get(0), arrayList.get(1));
            int l2 = compute(arrayList.get(1), arrayList.get(3));
            if (l2 != l1) {
                return false;
            }
            int l3 = compute(arrayList.get(3), arrayList.get(2));
            if (l3 != l1) {
                return false;
            }
            int l4 = compute(arrayList.get(2), arrayList.get(0));
            if (l4 != l1) {
                return false;
            }
            int m1 = compute(arrayList.get(0), arrayList.get(3));
            int m2 = compute(arrayList.get(1), arrayList.get(2));
            return m1 == m2;
        }

        private int compute(int[] p1, int[] p2) {
            return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}