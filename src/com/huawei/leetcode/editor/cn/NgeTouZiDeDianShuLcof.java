package com.huawei.leetcode.editor.cn;

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 
// 👍 280 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        double[] doubles = solution.dicesProbability(2);
        System.out.println("1");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
            HashMap<Integer, Double> hashMap = recur(n);
            ArrayList<Double> arrayList = new ArrayList<>();
            for (int i = n; i <= 6 * n; i++) {
                arrayList.add(hashMap.get(i));
            }
            return arrayList.stream().mapToDouble(Double::doubleValue).toArray();
        }

        private HashMap<Integer, Double> recur(int n) {
            if (n == 1) {
                return new HashMap<>() {{
                    put(1, 1 / 6.d);
                    put(2, 1 / 6.d);
                    put(3, 1 / 6.d);
                    put(4, 1 / 6.d);
                    put(5, 1 / 6.d);
                    put(6, 1 / 6.d);
                }};
            }
            HashMap<Integer, Double> hashMap = recur(n - 1);
            HashMap<Integer, Double> cur = new HashMap<>();
            for (int i = n; i <= n * 6; i++) {
                int min = Math.max(n - 1, i - 6);
                int max = Math.min(6 * (n - 1), i - 1);
                double sum = 0;
                for (int j = min; j <= max; j++) {
                    sum += hashMap.get(j);
                }
                cur.put(i, sum / 6.0d);
            }
            return cur;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}