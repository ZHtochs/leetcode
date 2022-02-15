package com.huawei.offer2.leetcode.editor.cn;

//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。 
//
// 幸运数是指矩阵中满足同时下列两个条件的元素： 
//
// 
// 在同一行的所有元素中最小 
// 在同一列的所有元素中最大 
// 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 3： 
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10^5 
// 矩阵中的所有元素都是不同的 
// 
// 👍 102 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：矩阵中的幸运数
public class P1380LuckyNumbersInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P1380LuckyNumbersInAMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            int[] rows = new int[matrix.length];
            int[] cols = new int[matrix[0].length];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = Integer.MAX_VALUE;
                for (int j = 0; j < cols.length; j++) {
                    rows[i] = Math.min(rows[i], matrix[i][j]);
                    cols[j] = Math.max(cols[j], matrix[i][j]);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < rows.length; i++) {
                for (int j = 0; j < cols.length; j++) {
                    int t = matrix[i][j];
                    if (t == rows[i] && t == cols[j]) ans.add(t);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}