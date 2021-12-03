package com.huawei.offer2.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
// 👍 182 👎 0

import java.util.Arrays;

//Java：K 次取反后最大化的数组和
public class P1005MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new P1005MaximizeSumOfArrayAfterKNegations().new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            int i = 0;
            while (k >= 0) {
                if (nums[i] >= 0 || i == nums.length - 1) {
                    Arrays.sort(nums);
                    if (k % 2 != 0) {
                        nums[0] = -nums[0];
                    }
                    return sum(nums);
                }
                if (k == 0) {
                    return sum(nums);
                }
                nums[i] = -nums[i];
                i++;
                k--;
            }
            return i;
        }

        private int sum(int[] ints) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}