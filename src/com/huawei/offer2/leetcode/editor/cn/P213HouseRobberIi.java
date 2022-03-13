package com.huawei.offer2.leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// 👍 949 👎 0

import java.util.Arrays;

//Java：打家劫舍 II
public class P213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length <= 3) {
                int num = Integer.MIN_VALUE;
                for (int i : nums) {
                    if (i > num) {
                        num = i;
                    }
                }
                return num;
            }
            int res1 = nums[0];
            int first = nums[0];
            int second = first;
            for (int i = 2; i < nums.length - 1; i++) {
                res1 = Math.max(first + nums[i], second);
                first = second;
                second = res1;
            }
            System.out.println("res1 " + res1);
            int res2 = nums[1];
            first = nums[1];
            second = Math.max(nums[1], nums[2]);
            for (int i = 3; i < nums.length; i++) {
                res2 = Math.max(first + nums[i], second);
                first = second;
                second = res2;
            }
            System.out.println("res2 " + res2);
            return Math.max(res1, res2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}