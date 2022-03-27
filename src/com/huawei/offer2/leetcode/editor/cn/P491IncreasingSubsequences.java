package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// 👍 403 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：递增子序列
public class P491IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491IncreasingSubsequences().new Solution();
        System.out.println(solution.findSubsequences(new int[]{4,6,7,7}));
        System.out.println(solution.findSubsequences(new int[]{4,4,3,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private LinkedList<Integer> temp = new LinkedList<>();
        private int[] nums;

        public List<List<Integer>> findSubsequences(int[] nums) {
            this.nums = nums;
            res.clear();
            temp.clear();
            backTracking(0);
            return res;
        }

        private void backTracking(int start) {
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            if (start >= nums.length) {
                return;
            }
            if (temp.isEmpty()) {
                temp.add(nums[start]);
            }
            Integer last = temp.getLast();
            int a = start + 1;
            for (int i = start + 1; i < nums.length; i++) {
                if (nums[i] >= last) {
                    temp.add(nums[i]);
                    a = i;
                    break;
                }
            }
            backTracking(a);
            temp.removeLast();
            backTracking(start + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}