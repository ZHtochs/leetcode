package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 
//true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？ 
// 👍 494 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：递增的三元子序列
public class P334IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution solution = new P334IncreasingTripletSubsequence().new Solution();
        System.out.println(solution.increasingTriplet(new int[]{0, 4, 2, 1, 0, -1, -3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int first = nums[0];
            int second = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > second) {
                    return true;
                } else if (nums[i] > first) {
                    second = nums[i];
                } else {
                    first = nums[i];
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}