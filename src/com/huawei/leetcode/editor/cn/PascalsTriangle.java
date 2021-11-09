package com.huawei.leetcode.editor.cn;

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// 👍 622 👎 0

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        List<List<Integer>> list = solution.generate(4);
        System.out.println("123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
                            current.add(pre.get(0));
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