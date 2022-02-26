package com.huawei.offer2.leetcode.editor.cn;

//给定一个正整数数组 nums和整数 k 。 
//
// 请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// 👍 348 👎 0

//Java：乘积小于K的子数组
public class P713SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(new P713SubarrayProductLessThanK()
                .new Solution().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(new P713SubarrayProductLessThanK()
                .new Solution().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int target;

        public int numSubarrayProductLessThanK(int[] nums, int k) {
            this.nums = nums;
            target = k;
            return dfs(nums.length - 1);
        }

        private int dfs(int k) {
            if (k == 0) {
                return nums[0] < target ? 1 : 0;
            }
            int dfs = dfs(k - 1);
            int sum = 1;
            for (int i = k; i >= 0; i--) {
                sum *= nums[i];
                if (sum < target) {
                    dfs++;
                } else {
                    break;
                }
            }
            return dfs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}