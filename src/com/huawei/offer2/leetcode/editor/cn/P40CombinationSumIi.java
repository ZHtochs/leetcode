package com.huawei.offer2.leetcode.editor.cn;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// 👍 875 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] candidates;
        private int target;
        private LinkedList<Integer> list = new LinkedList<>();
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            res.clear();
            list.clear();
            this.candidates = candidates;
            this.target = target;
            backTracking(0, 0);
            return res;
        }

        private void backTracking(int start, int sum) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (sum > target || start >= candidates.length) {
                return;
            }
            sum += candidates[start];
            list.add(candidates[start]);
            backTracking(start + 1, sum);
            sum -= candidates[start];
            list.removeLast();
            int temp = start;
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] == candidates[start]) {
                    temp = i;
                } else {
                    break;
                }
            }
            backTracking(temp + 1, sum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}