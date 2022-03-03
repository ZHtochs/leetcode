package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// 👍 749 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(new ArrayList(), 0, nums);
            return res;
        }

        public void dfs(List<Integer> list, int index, int[] nums) {
            if (index == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            list.add(nums[index]);
            dfs(list, index + 1, nums);
            list.remove(list.size() - 1);
            while (index < nums.length - 1 && nums[index] == nums[index + 1]) { // 去重，不选当前数递归时直接跳过重复数
                index++;    // 所有重复数的可能性在前面递归中均会出现
            }
            dfs(list, index + 1, nums); // 不选择当前的数
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}