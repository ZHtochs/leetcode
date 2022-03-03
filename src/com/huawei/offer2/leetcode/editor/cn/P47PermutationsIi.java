package com.huawei.offer2.leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// 👍 959 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private List<List<Integer>> lists = new LinkedList<>();

        private boolean[] booleans;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
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
                if (booleans[i] || (i > 0 && nums[i] == nums[i - 1] && !booleans[i - 1])) {
                    continue;
                }
                booleans[i] = true;
                list.add(nums[i]);
                permute(nums, list);
                booleans[i] = false;
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}