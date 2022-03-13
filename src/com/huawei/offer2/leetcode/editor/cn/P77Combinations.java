package com.huawei.offer2.leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// 👍 833 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(3, 2);
        System.out.println("123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<List<Integer>> res = new LinkedList<>();

        private int n;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            res.clear();
            backTracking(new LinkedList<>(), k, 1);
            return res;
        }

        private void backTracking(LinkedList<Integer> arrayList, int k, int start) {
            if (arrayList.size() == k) {
                res.add(new ArrayList<>(arrayList));
                return;
            }
            for (int i = start; i <= n; i++) {
                arrayList.add(i);
                backTracking(arrayList, k, i + 1);
                arrayList.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}