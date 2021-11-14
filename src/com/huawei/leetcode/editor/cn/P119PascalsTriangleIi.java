//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// 👍 335 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角 II
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        List<List<Integer>> generate = solution.generate(0);
        System.out.println("!23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            return generate(rowIndex + 1).get(rowIndex);
        }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> pre = null;
            for (int i = 1; i < numRows + 1; i++) {
                List<Integer> current;
                if (pre == null) {
                    current = List.of(1);
                } else {
                    current = new ArrayList<>(i);
                    for (int j = 0; j < i; j++) {
                        if (j == 0) {
                            current.add(1);
                        } else if (j == i - 1) {
                            current.add(pre.get(pre.size() - 1));
                        } else {
                            current.add(pre.get(j - 1) + pre.get(j));
                        }
                    }
                }
                pre = current;
                list.add(current);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}