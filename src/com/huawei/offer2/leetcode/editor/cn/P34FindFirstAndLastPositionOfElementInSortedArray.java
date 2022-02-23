package com.huawei.offer2.leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// 👍 1463 👎 0

import java.util.Arrays;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{2, 2}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int i = Arrays.binarySearch(nums, target);
            if (i < 0) {
                return new int[]{-1, -1};
            }
            int[] res = new int[2];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != target) {
                    res[1] = j - 1;
                    break;
                }
                if (nums[j] == target && j == nums.length - 1) {
                    res[1] = j;
                }
            }
            for (int j = i; j >= 0; j--) {
                if (nums[j] != target) {
                    res[0] = j + 1;
                    break;
                }
                if (nums[j] == target && j == 0) {
                    res[0] = j;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}