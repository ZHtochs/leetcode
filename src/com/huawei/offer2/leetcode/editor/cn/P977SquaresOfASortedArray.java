package com.huawei.offer2.leetcode.editor.cn;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// 👍 392 👎 0

import java.util.Arrays;

//Java：有序数组的平方
public class P977SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            int pos = res.length - 1;
            int i = 0, j = pos;
            while (i <= j) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                    res[pos] = Math.abs(nums[i]) * Math.abs(nums[i]);
                    i++;
                } else {
                    res[pos] = Math.abs(nums[j]) * Math.abs(nums[j]);
                    j--;
                }
                pos--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}