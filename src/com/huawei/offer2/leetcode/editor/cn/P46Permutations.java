package com.huawei.offer2.leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// 👍 1735 👎 0

import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> lists = new LinkedList<>();

        private boolean[] booleans;

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            booleans = new boolean[nums.length];
            permute(nums, linkedList);
            return lists;
        }

        public void permute(int[] nums, LinkedList<Integer> list) {
            if (list.size() == nums.length) {
                lists.add(new LinkedList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!booleans[i]) {
                    booleans[i] = true;
                    list.add(nums[i]);
                    permute(nums, list);
                    booleans[i] = false;
                    list.removeLast();
                }

            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}