package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// 👍 1496 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Java：子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{3,9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> dfs = dfs(nums, nums.length);
            dfs.add(new ArrayList<>());
            return dfs;
        }

        private List<List<Integer>> dfs(int[] nums, int i) {
            if (i == 1) {
                List<List<Integer>> res = new ArrayList<>();
                List<Integer> list = new ArrayList<>(List.of(nums[0]));
                res.add(list);
                return res;
            }
            List<List<Integer>> dfs = dfs(nums, i - 1);
            int size = dfs.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(dfs.get(j));
                list.add(nums[i - 1]);
                dfs.add(list);
            }
            dfs.add(new ArrayList<>(List.of(nums[i - 1])));
            return dfs;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}